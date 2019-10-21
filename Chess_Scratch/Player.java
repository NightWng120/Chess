import java.util.*;
public abstract class Player{
	
	protected Pawn pawn;
	protected Rook rook;
	protected Knight knight;
	protected King king;
	protected Bishop bishop;
	protected boolean color;
	protected Vector<int[]> vecpos;
	protected Vector<int[]> vecfilt;
	protected static int[][] w = {{0,1},{1,1},{2,1},{3,1},{4,1},{5,1},{6,1},{7,1},
		 	{0,2},{1,2},{2,2},{3,2},{4,2},{5,2},{6,2},{7,2}};
	
	protected static int[][] b = {{0,6},{1,6},{2,6},{3,6},{4,6},{5,6},{6,6},{7,6}, 
			{0,5},{1,5},{2,5},{3,5},{4,5},{5,5},{6,5},{7,5}};
/* ***NOTE***
	You can make the array of piece positions by
	using a 2d array and getPos() methods.

	For Instance:

	int[][] array = {this.rook.getPos(), this.knight.getPos(), this.queen.getPos(), etc};
	
*/
	public Player(boolean color){
		this.vecpos = new Vector<int[]>();
		this.vecfilt = new Vector<int[]>();
		this.color = color;
		this.king = new King(this.color);
		this.rook = new Rook(this.color);
		this.knight = new Knight(this.color);
		this.pawn = new Pawn(this.color);
		this.bishop = new Bishop(this.color);
	
		
		
		
	}//end constructor
		
	public <J extends Player> boolean MoveCheck(J player, int[] pos, int[] next, boolean take){
		int[] arK = this.knight.getPos();
		int[] arR = this.rook.getPos();
		int[] arP = this.pawn.getPos();
		

		if(Arrays.equals(pos, this.king.getPos())){
			kingFilt(player);
			if(collision(player, this.king.getPos(), next) && this.king.moveChoose(next, player.vecfilt)){
				
				System.out.println(this.vecpos.size());
				vecpos.remove(this.king.getPos());
				System.out.println(this.vecpos.size());

				this.king.setPos(next);	
				this.vecpos.add(this.king.getPos());

				this.vecfilt = redFilt(player, false);
				
				return true;
			}//end if
			else{
				return false;
			}//end else

		}//end if		

		if(Arrays.equals(pos, arK)){
			
			if(this.knight.MoveChoose(next)){//If statement  checks if arrays are the same and if the inputted next move is valid
					
				if(collision(player,arK,next) && pieceLock(player, this.knight, next)){//collision method call
					
					this.vecpos.remove(arK);

					this.knight.setPos(next);
					this.vecpos.add(this.knight.getPos());

					this.vecfilt = redFilt(player, false);
					return true;
				}//end if

			}//end if
			else{
				return false;
			}//end else
			
		}//end if
		else if(Arrays.equals(pos, arR)){

			if(this.rook.MoveChoose(next)){//If statement  checks if arrays are the same and if the inputted next move is valid


	
				if(collision(player,arR,next) &&  pieceLock(player, this.rook, next)){
					
					this.vecpos.remove(arR);

					this.rook.setPos(next);
					this.vecpos.add(this.rook.getPos());

					this.vecfilt = redFilt(player, false);
					return true;
				}//end if

			}//end if
			else{
				return false;
			}//end else
		}//end else if
		
		else if(Arrays.equals(pos, arP)){

			if(this.pawn.moveChoose(next, take)){



	
				if(collision(player,arP,next) && pieceLock(player, this.pawn, next)){
					
					this.pawn.start = false;
					this.vecpos.remove(arP);

					this.pawn.setPos(next);
					this.vecpos.add(this.pawn.getPos());

					this.vecfilt = redFilt(player, false);
					return true;
				}//end if

			}//end if
			
			
			else{

				return false;
			}//end else


		}//end else if
		
		else if(Arrays.equals(pos, this.bishop.getPos())){

			if(this.bishop.MoveChoose(next)){//If statement  checks if arrays are the same and if the inputted next move is valid


	
				if(collision(player,this.bishop.getPos(),next) &&  pieceLock(player, this.bishop, next)){
					
					this.vecpos.remove(this.bishop.getPos());

					this.bishop.setPos(next);
					this.vecpos.add(this.bishop.getPos());

					this.vecfilt = redFilt(player, false);
					return true;
				}//end if

			}//end if
			
			else{
				return false;
			}//end else
		}//end else if

		return false;
	}//end MoveCheck
	
	public <J extends Player> boolean collision(J player, int[] pos, int[] next){
	/*This method determines if the selected piece has a slope that is the same as another piece on
	  the board and the selected move position. If the slope is the same and the distance between the
	  other piece on the board is and the selected piece is less than the distance between the selected 
	  next position and the next piece, then the method returns false. Otherwise, it returns true
	*/
		int[] arKi = this.king.getPos();
		int[] arK = this.knight.getPos();
		int[] arR = this.rook.getPos();
		int[] arP = this.pawn.getPos();
		int[] pArP = player.pawn.getPos();
		int[] pArK = player.knight.getPos();
		int[] pArR = player.rook.getPos();
		/*Debugger's Corner*/

		boolean state = true;
		/*I used a boolean variable here as a catch all
		  so that I can check every piece for collision
		  in case of a situation where there are multiple cases
		  meeting the criteria for a false method return 
		*/


		if(Arrays.equals(next, this.bishop.getPos()) || Arrays.equals(next, this.rook.getPos()) || Arrays.equals(next, this.knight.getPos()) || Arrays.equals(next, this.pawn.getPos()) || Arrays.equals(next, this.king.getPos())){
			return false;
		}//end if





		

		/*----------------------------------King if--------------------------*/
		if(Arrays.equals(pos, this.king.getPos())){//If determines which piece has been selected
			

				state = true;
		
		}//end if
		/*----------------------------------Rook if--------------------------*/
		if(Arrays.equals(pos, this.rook.getPos())){//If determines which piece has been selected
			



			if(this.rook.slope(this.rook.getPos(), this.king.getPos()) == this.rook.slope(this.rook.getPos(), next)){	

				if(this.rook.dist(this.rook.getPos(), this.king.getPos()) < this.rook.dist(this.rook.getPos(), next)){

					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.rook.slope(arR, arK) == this.rook.slope(arR, next)){//if determines if slopes are the same between other piece and next
				if(this.rook.dist(arR,arK) < this.rook.dist(arR, next)){//if determines if distance between piece is less than next
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.rook.slope(arR, arP) == this.rook.slope(arR, next)){
				if(this.rook.dist(arR, arP) < this.rook.dist(arR, next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.rook.slope(arR, pArK) == this.rook.slope(arR, next)){
				if(this.rook.dist(arR, pArK) < this.rook.dist(arR, next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.rook.slope(arR, pArR) == this.rook.slope(arR, next)){
			
				if(this.rook.dist(this.rook.getPos(), pArR) < this.rook.dist(arR, next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.rook.slope(arR, pArP) == this.rook.slope(arR, next)){
				if(this.rook.dist(arR, pArP) < this.rook.dist(arR, next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

		}//end if
		
		/*---------------------Bishop if--------------------------------*/
		if(Arrays.equals(pos, this.bishop.getPos())){//If determines which piece has been selected
			



			if(this.bishop.slope(this.bishop.getPos(), this.king.getPos()) == this.bishop.slope(this.bishop.getPos(), next)){	

				if(this.bishop.dist(this.bishop.getPos(), this.king.getPos()) < this.bishop.dist(this.bishop.getPos(), next)){

					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.bishop.slope(arR, arK) == this.bishop.slope(arR, next)){//if determines if slopes are the same between other piece and next
				if(this.bishop.dist(arR,arK) < this.bishop.dist(arR, next)){//if determines if distance between piece is less than next
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.bishop.slope(arR, arP) == this.bishop.slope(arR, next)){
				if(this.bishop.dist(arR, arP) < this.bishop.dist(arR, next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.bishop.slope(arR, pArK) == this.bishop.slope(arR, next)){
				if(this.bishop.dist(arR, pArK) < this.bishop.dist(arR, next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.bishop.slope(arR, pArR) == this.bishop.slope(arR, next)){
			
				if(this.bishop.dist(this.bishop.getPos(), pArR) < this.bishop.dist(arR, next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.bishop.slope(arR, pArP) == this.bishop.slope(arR, next)){
				if(this.bishop.dist(arR, pArP) < this.bishop.dist(arR, next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

		}//end if




		/*----------------------Knight if--------------------------------*/
		else if(Arrays.equals(pos, this.knight.getPos())){//No arguments for knight piece because of its move set

			state = true;



		}//end if

		/*----------------------Pawn if----------------------------------*/
		else if(Arrays.equals(pos, arP)){



			if(this.pawn.slope(arP, arKi) == this.pawn.slope(arP, next)){	

				if(this.pawn.color) {
					
					if(this.pawn.dist(arP, arKi) < this.pawn.dist(arP, next) && arP[1] < arKi[1]){
	
						state = false;
					}//end if
					else{
						state = true;
					}//end else
					
				}//end if
					
				else if(!this.pawn.color) {
					
					if(this.pawn.dist(arP, arKi) > this.pawn.dist(arP, next) && arP[1] > arKi[1]){

						state = false;
					}//end if
					else{
						state = true;
					}//end else
					
				}//end else if


			}//end if

			if(this.pawn.slope(arP, arK) == this.pawn.slope(arP, next)){	

				if(this.pawn.color) {
					
					if(this.pawn.dist(arP, arK) < this.pawn.dist(arP, next) && arP[1] < arK[1]){
	
						state = false;
					}//end if
					else{
						state = true;
					}//end else
					
				}//end if
					
				else if(!this.pawn.color) {
					
					if(this.pawn.dist(arP, arK) > this.pawn.dist(arP, next) && arP[1] > arK[1]){

						state = false;
					}//end if
					else{
						state = true;
					}//end else
					
				}//end else if


			}//end if

			if(this.pawn.slope(arP, arR) == this.pawn.slope(arP, next)){	

				if(this.pawn.color) {
					
					if(this.pawn.dist(arP, arR) < this.pawn.dist(arP, next) && arP[1] < arR[1]){
	
						state = false;
					}//end if
					else{
						state = true;
					}//end else
					
				}//end if
					
				else if(!this.pawn.color) {
					
					if(this.pawn.dist(arP, arR) > this.pawn.dist(arP, next) && arP[1] > arR[1]){

						state = false;
					}//end if
					else{
						state = true;
					}//end else
					
				}//end else if


			}//end if

			if(this.pawn.slope(arP, pArP) == this.pawn.slope(arP, next)){	

				if(this.pawn.color) {
					
					if(this.pawn.dist(arP, pArP) < this.pawn.dist(arP, next) && arP[1] < pArP[1]){
	
						state = false;
					}//end if
					else{
						state = true;
					}//end else
					
				}//end if
					
				else if(!this.pawn.color) {
					
					if(this.pawn.dist(arP, pArP) > this.pawn.dist(arP, next) && arP[1] > pArP[1]){

						state = false;
					}//end if
					else{
						state = true;
					}//end else
					
				}//end else if


			}//end if

			if(this.pawn.slope(arP, pArR) == this.pawn.slope(arP, next)){	

				if(this.pawn.color) {
					
					if(this.pawn.dist(arP, pArR) < this.pawn.dist(arP, next) && arP[1] < pArR[1]){
	
						state = false;
					}//end if
					else{
						state = true;
					}//end else
					
				}//end if
					
				else if(!this.pawn.color) {
					
					if(this.pawn.dist(arP, pArR) > this.pawn.dist(arP, next) && arP[1] > pArR[1]){

						state = false;
					}//end if
					else{
						state = true;
					}//end else
					
				}//end else if


			}//end if

			if(this.pawn.slope(arP, pArK) == this.pawn.slope(arP, next)){	

				if(this.pawn.color) {
					
					if(this.pawn.dist(arP, pArK) < this.pawn.dist(arP, next) && arP[1] < pArK[1]){
	
						state = false;
					}//end if
					else{
						state = true;
					}//end else
					
				}//end if
					
				else if(!this.pawn.color) {
					
					if(this.pawn.dist(arP, pArK) > this.pawn.dist(arP, next) && arP[1] > pArK[1]){

						state = false;
					}//end if
					else{
						state = true;
					}//end else
					
				}//end else if


			}//end if


		}//end if
		

		return state;
	}//end Collision
	
	
	public <J extends Player, K extends Piece> boolean pieceLock(J player, K piece, int[] next) {//determines if a piece is lodged between it's king an an opposing piece
		
		int i;
		double slope = player.rook.slope(player.rook.getPos(), piece.getPos());
		
		if(player.rook.slope(player.rook.getPos(), piece.getPos()) == player.rook.slope(player.rook.getPos(), this.king.getPos())){
			
			if(Arrays.equals(player.rook.getPos(), next)) {
				return true;
			}//end if
			
			else if(!player.collision(this, player.rook.getPos(), this.king.getPos())) {

				
				if(player.rook.dist(player.rook.getPos(), this.king.getPos()) > player.rook.dist(player.rook.getPos(), piece.getPos()) && 
						player.rook.dist(player.rook.getPos(), this.king.getPos()) > player.rook.dist(this.king.getPos(), piece.getPos())) {
					
					for(i = 0; i < this.vecpos.size(); i++) {
						
						if(player.rook.dist(player.rook.getPos(), this.king.getPos()) < player.rook.dist(player.rook.getPos(), this.vecpos.get(i)) || 
								player.rook.dist(player.rook.getPos(), this.king.getPos()) < player.rook.dist(this.king.getPos(), this.vecpos.get(i)) || 
									player.rook.dist(player.rook.getPos(), this.king.getPos()) < player.rook.dist(player.rook.getPos(), player.vecpos.get(i)) || 
										player.rook.dist(player.rook.getPos(), this.king.getPos()) < player.rook.dist(this.king.getPos(), player.vecpos.get(i))) {
							
							if(player.rook.slope(player.rook.getPos(), this.vecpos.get(i)) == slope || player.rook.slope(player.rook.getPos(), player.vecpos.get(i)) == slope) {	
								return false;
							}//end if
							
						}//end if
						
					}//end for loop
				
				}//end if
			}//end if
					
		}//end if
		
		
		
		
		
		
		
		return true;
	}//end pieceLock
	
	
	
	
	public <J extends Player> Vector<int[]> redFilt(J player, boolean black){
		
		Vector<int[]> vecred;
		Vector<int[]> vecall = new Vector<int[]>();
		int i;

		vecred = this.knight.redSpot();
		for(i = 0; i < vecred.size(); i++){
			if(collision(player, this.knight.getPos(), vecred.get(i)) && this.knight.alive){
				vecall.add(vecred.get(i));
			}//end if
			

		}//end for loop
		vecred.clear();
		vecred = this.rook.redSpot();
		
		for(i = 0; i < vecred.size(); i++){
			if(collision(player, this.rook.getPos(), vecred.get(i)) && this.rook.alive){

				vecall.add(vecred.get(i));
			}//end if
		}//end for loop
		vecred.clear();
		vecred = this.pawn.RedSpot();
		
		for(i = 0; i < vecred.size(); i++){
			if(collision(player, this.pawn.getPos(), vecred.get(i)) && this.pawn.alive){

				vecall.add(vecred.get(i));
			}//end if
		}//end for loop
		
		vecred.clear();
		vecred = this.bishop.redSpot();
		for(i = 0; i < vecred.size(); i++){
			if(collision(player, this.bishop.getPos(), vecred.get(i)) && this.bishop.alive){

				vecall.add(vecred.get(i));
			}//end if
		}//end for loop
		
		
		return vecall;
	}//end redFilt
	
	public <J extends Player> void kingFilt(J player){

		Vector<int[]> vecMe = new Vector<int[]>();
		Vector<int[]> vecThem = new Vector<int[]>();
		int i;
		int j;
		
		vecMe = this.king.RedSpot(player.vecfilt);
		vecThem = player.king.RedSpot(this.vecfilt);

		for(i = 0; i < vecMe.size() ; i++){


			for(j = 0; j < vecThem.size(); j++){
				if(Arrays.equals(vecMe.get(i), vecThem.get(j))){
					this.vecfilt.add(vecMe.get(i));
					player.vecfilt.add(vecThem.get(j));
				}//end if
				
			}//end for loop
			
		}//end for loop

	}//end kingFilt


	


	












}//end Player abstract class
