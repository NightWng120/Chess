import java.util.*;
import java.math.*;
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
			if(collision(player, king, next) && this.king.moveChoose(next, player.vecfilt)){
				
				vecpos.remove(this.king.getPos());

				this.king.setPos(next);	
				this.vecpos.add(this.king.getPos());
				this.vecfilt.clear();
				this.vecfilt = redFilt(player, false);
				
				return true;
			}//end if
			else{
				return false;
			}//end else

		}//end if		

		if(Arrays.equals(pos, arK)){
			
			if(this.knight.MoveChoose(next)){//If statement  checks if arrays are the same and if the inputted next move is valid
					
				if(collision(player,knight,next) && pieceLock(player, this.knight, next)){//collision method call
					
					this.vecpos.remove(arK);

					this.knight.setPos(next);
					this.vecpos.add(this.knight.getPos());
					this.vecfilt.clear();

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


	
				if(collision(player,rook,next) &&  pieceLock(player, this.rook, next)){
					
					this.vecpos.remove(arR);

					this.rook.setPos(next);
					this.vecpos.add(this.rook.getPos());
					this.vecfilt.clear();

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



	
				if(collision(player,pawn,next) && pieceLock(player, this.pawn, next)){
					
					this.pawn.start = false;
					this.vecpos.remove(arP);

					this.pawn.setPos(next);
					this.vecpos.add(this.pawn.getPos());
					this.vecfilt.clear();

					this.vecfilt = redFilt(player, false);
					return true;
				}//end if

			}//end if
			
			
			else{

				return false;
			}//end else


		}//end else if
		
		else if(Arrays.equals(pos, this.bishop.getPos())){

			if(this.bishop.MoveChoose(next)){//If statement  checks if arrays are the same and if the inputed next move is valid


	
				if(collision(player,bishop,next) &&  pieceLock(player, this.bishop, next)){
					
					this.vecpos.remove(this.bishop.getPos());

					this.bishop.setPos(next);
					this.vecpos.add(this.bishop.getPos());
					this.vecfilt.clear();

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
	
	public <J extends Player, K extends Piece> boolean collision(J player, K piece, int[] next){
	/*This method determines if the selected piece has a slope that is the same as another piece on
	  the board and the selected move position. If the slope is the same and the distance between the
	  other piece on the board is and the selected piece is less than the distance between the selected 
	  next position and the next piece, then the method returns false. Otherwise, it returns true
	*/
		
		

		if(Arrays.equals(next, this.bishop.getPos()) || Arrays.equals(next, this.rook.getPos()) || Arrays.equals(next, this.knight.getPos()) || Arrays.equals(next, this.pawn.getPos()) || Arrays.equals(next, this.king.getPos())){
			return false;
		}//end if
		
		for(int i = 0; i < player.vecpos.size(); i++) {
			if(isBetween(piece.getPos(),next,player.vecpos.get(i)) &&  !Arrays.equals(player.vecpos.get(i), piece.getPos())){	

				if(Arrays.equals(next, player.vecpos.get(i))) {
					
					return true;
					
				}//end if
	
					return false;
				
					
					
			}//end if
					
				
		}//end for loop
		
		for(int i = 0; i < this.vecpos.size(); i++) {
			if(isBetween(piece.getPos(),next,this.vecpos.get(i)) &&  !Arrays.equals(this.vecpos.get(i), piece.getPos())){	

						return false;
					
					
			}//end if
		}//end for loop

		return true;
	}//end Collision
	
	
	public <J extends Player, K extends Piece> boolean pieceLock(J player, K piece, int[] next) {//determines if a piece is lodged between it's king an an opposing piece
		
		int i;
		
		if(player.rook.slope(player.rook.getPos(), piece.getPos()) == player.rook.slope(player.rook.getPos(), this.king.getPos())){
			
			if(Arrays.equals(player.rook.getPos(), next)) {
				return true;
			}//end if
			
			else if(!player.collision(this, rook, this.king.getPos())) {

				
				if(isBetween(player.rook.getPos(), this.king.getPos(), piece.getPos())) {
					
					for(i = 0; i < this.vecpos.size(); i++) {
						
						if(isBetween(player.rook.getPos(), this.king.getPos(), piece.getPos()) && !isBetween(player.rook.getPos(), this.king.getPos(), this.vecpos.get(i)) && 
								!isBetween(player.rook.getPos(), this.king.getPos(), player.vecpos.get(i))) {
							
								return false;
							
						}//end if
						
					}//end for loop
				
				}//end if
			}//end if
			
			
			
			
					
		}//end if
		
		if(player.bishop.slope(player.bishop.getPos(), piece.getPos()) == player.bishop.slope(player.bishop.getPos(), this.king.getPos())){
			
			if(Arrays.equals(player.bishop.getPos(), next)) {
				return true;
			}//end if
			
			else if(!player.collision(this, bishop, this.bishop.getPos())) {

				
				if(player.bishop.dist(player.bishop.getPos(), this.king.getPos()) > player.bishop.dist(player.bishop.getPos(), piece.getPos()) && 
						player.bishop.dist(player.bishop.getPos(), this.king.getPos()) > player.bishop.dist(this.king.getPos(), piece.getPos())) {
					
					for(i = 0; i < this.vecpos.size(); i++) {
						
						if(isBetween(player.bishop.getPos(), this.king.getPos(), piece.getPos()) && !isBetween(player.bishop.getPos(), this.king.getPos(), this.vecpos.get(i)) && 
								!isBetween(player.bishop.getPos(), this.king.getPos(), player.vecpos.get(i))) {
							
								return false;
							
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
			if(this.knight.alive){
				vecall.add(vecred.get(i));
			}//end if
			

		}//end for loop
		vecred.clear();
		vecred = this.rook.redSpot();
		
		for(i = 0; i < vecred.size(); i++){
			if(collision(player, rook, vecred.get(i)) && this.rook.alive){

				vecall.add(vecred.get(i));
			}//end if
		}//end for loop
		vecred.clear();
		vecred = this.pawn.RedSpot();
		
		for(i = 0; i < vecred.size(); i++){
			if(collision(player, pawn, vecred.get(i)) && this.pawn.alive){

				vecall.add(vecred.get(i));
			}//end if
		}//end for loop
		
		vecred.clear();
		vecred = this.bishop.redSpot();
		for(i = 0; i < vecred.size(); i++){
			if(collision(player, bishop, vecred.get(i)) && this.bishop.alive){

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
	
	public boolean isBetween(int[] pos, int[] next, int[] inter) {
		
		
		BigDecimal bd1 = new BigDecimal(this.rook.dist(pos,inter));
		BigDecimal bd2 = new BigDecimal(this.rook.dist(inter,next));
		
		BigDecimal bd3 = new BigDecimal(this.rook.dist(pos,next));
		BigDecimal sum = bd1.add(bd2);
		sum = sum.divide(BigDecimal.ONE, 2, RoundingMode.HALF_EVEN);
		bd3 = bd3.divide(BigDecimal.ONE, 2, RoundingMode.HALF_EVEN);
		
		double together = sum.doubleValue();
		double dist = bd3.doubleValue();
		
		
		
		
		return together == dist;
	}//end isBetween


	


	












}//end Player abstract class
