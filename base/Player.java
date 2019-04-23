import java.util.*;


public abstract class Player{



	protected Queen queen;
	protected King king;
	protected Bishop bishopW;
	protected Bishop bishopB;
	protected Rook rookW;
	protected Rook rookB;
	protected Knight knightB;
	protected Knight knightW;
	protected Vector<Pawn> vecPawn;
	protected boolean color;
	protected int points;

	public Player(boolean color){
		
		int i;
		this.color = color;
		this.points = 0;
		this.queen = new Queen(this.color);
		this.king = new King(this.color);
		this.bishopW = new Bishop(this.color);
		this.bishopB = new Bishop(this.color);
		this.rookW = new Rook(this.color);
		this.rookB = new Rook(this.color);
		this.knightB = new Knight(this.color);
		this.knightW = new Knight(this.color);
		this.vecPawn = new Vector<Pawn>();
		for(i = 0; i < 8; i++){

			this.vecPawn.add(new Pawn(this.color));
		}//end for loop



	}//end constructor
	
	
	
	public <J extends Player>boolean movePiece(J player, int[] pos, int[] next){


		
		int[] arQ = this.queen.getPos();
		int[] arK = this.king.getPos();
		int[] arkW = this.knightW.getPos();
		int[] arkB = this.knightB.getPos();
		int[] arbB = this.bishopB.getPos();
		int[] arbW = this.bishopW.getPos();
		int[] arrB = this.rookB.getPos();
		int[] arrW = this.rookW.getPos();
		int[] arp1 = this.vecPawn.get(0).getPos();
		int[] arp2 = this.vecPawn.get(1).getPos();
		int[] arp3 = this.vecPawn.get(2).getPos();
		int[] arp4 = this.vecPawn.get(3).getPos();
		int[] arp5 = this.vecPawn.get(4).getPos();
		int[] arp6 = this.vecPawn.get(5).getPos();
		int[] arp7 = this.vecPawn.get(6).getPos();
		int[] arp8 = this.vecPawn.get(7).getPos();
			
			

	
			
		if(pos[0] > 7 || pos[1] > 7 || next[0] > 7 || next[1] > 7 || pos[0] < 0 || pos[1] < 0 || next[0] < 0 || next[1] < 0){

			return false;

		}//end if
		
		else{
        
			if(pos[0] == arQ[0] && pos[1] == arQ[1]){

				if(queen.moveChoose(next)){
					
					return valid(queen,player, next);
				}//end if
				return false;

			}//end if
			if(pos[0] == arK[0] && pos[1] == arK[1]){
				if(king.moveChoose(next)) {
					
					return valid(king, player,next);
					
				}


			}//end if
			if(pos[0] == arkB[0] && pos[1] == arkB[1]){

					if(knightB.moveChoose(next)){
						
						return validKnight(knightB,player, next);
					}//end if
					return false;	
				

			}//end if
			if(pos[0] == arkW[0] && pos[1] == arkW[1]){

					if(knightW.moveChoose(next)){
						
						return validKnight(knightW, player,next);
					}//end if
					return false;


			}//end if
			if(pos[0] == arbW[0] && pos[1] == arbW[1]){


					if(bishopW.moveChoose(next)){
						
						return valid(bishopW,player, next);
					}//end if
					return false;
			}//end if
			if(pos[0] == arbB[0] && pos[1] == arbB[1]){

					if(bishopB.moveChoose(next)){
						
						return valid(bishopB,player, next);
					}//end if
					return false;

			}//end if
			if(pos[0] == arrW[0] && pos[1] == arrW[1]){


					if(rookW.moveChoose(next)){
						
						return valid(rookW,player, next);
					}//end if
					return false;
			}//end if
			if(pos[0] == arrB[0] && pos[1] == arrB[1]){
				

					if(rookB.moveChoose(next)){
						
						return valid(rookB, player,next);
					}//end if
					return false;

			}//end if
			if(pos[0] == arp1[0] && pos[1] == arp1[1]){

				if(validPawn(vecPawn.get(0), player, next)){
					
					return vecPawn.get(0).moveChoose(next, true);
		
				
				}//end if
				
				else if(!validPawn(vecPawn.get(0), player,next)) {
					
					
					return vecPawn.get(0).moveChoose(next, false);
				}//end else if
			}//end if
			if(pos[0] == arp2[0] && pos[1] == arp2[1]){

				if(validPawn(vecPawn.get(1), player,next)){
					
					return vecPawn.get(1).moveChoose(next, true);
		
				
				}//end if
				
				else if(!validPawn(vecPawn.get(1), player,next)) {
					
					
					return vecPawn.get(1).moveChoose(next, false);
				}//end else if
			}//end if
			if(pos[0] == arp3[0] && pos[1] == arp3[1]){
				if(validPawn(vecPawn.get(2), player,next)){
					
					return vecPawn.get(2).moveChoose(next, true);
		
				
				}//end if
				
				else if(!validPawn(vecPawn.get(2), player,next)) {
					
					
					return vecPawn.get(2).moveChoose(next, false);
				}//end else if
			}//end if
			if(pos[0] == arp4[0] && pos[1] == arp4[1]){

				if(validPawn(vecPawn.get(3), player,next)){
					
					return vecPawn.get(3).moveChoose(next, true);
		
				
				}//end if
				
				else if(!validPawn(vecPawn.get(3), player,next)) {
					
					
					return vecPawn.get(3).moveChoose(next, false);
				}//end else if
			}//end if
			if(pos[0] == arp5[0] && pos[1] == arp5[1]){
				if(validPawn(vecPawn.get(4), player,next)){
					
					return vecPawn.get(4).moveChoose(next, true);
		
				
				}//end if
				
				else if(!validPawn(vecPawn.get(4), player,next)) {
					
					
					return vecPawn.get(4).moveChoose(next, false);
				}//end else if
			}//end if
			if(pos[0] == arp6[0] && pos[1] == arp6[1]){

				if(validPawn(vecPawn.get(5), player,next)){
					
					return vecPawn.get(5).moveChoose(next, true);
		
				
				}//end if
				
				else if(!validPawn(vecPawn.get(5), player,next)) {
					
					
					return vecPawn.get(5).moveChoose(next, false);
				}//end else if
			}//end if
			if(pos[0] == arp7[0] && pos[1] == arp7[1]){

				if(validPawn(vecPawn.get(6), player,next)){
					
					return vecPawn.get(6).moveChoose(next, true);
		
				
				}//end if
				
				else if(!validPawn(vecPawn.get(6), player,next)) {
					
					
					return vecPawn.get(6).moveChoose(next, false);
				}//end else if
			}//end if
			if(pos[0] == arp8[0] && pos[1] == arp8[1]){
				
				if(validPawn(vecPawn.get(7), player,next)){
					
					return vecPawn.get(7).moveChoose(next, true);
		
				
				}//end if
			
				else if(!validPawn(vecPawn.get(7), player,next)) {
					
					
					return vecPawn.get(7).moveChoose(next, false);
				}//end else if
			
			}//end if
			
			return false;
		}//end else
	
	}//end movePiece
	public <T extends Piece, J extends Player> boolean validPawn(T obj, J player, int[] next) {
		int[] pos = obj.getPos();
		int i;
		
		
			if(obj.slope(next) == 1) {
				if(next[0] == player.knightW.getPosX() && next[1] == player.knightW.getPosY()) {
					
					return true;
				}//end if
				
				else if(next[0] == player.knightB.getPosX() && next[1] == player.knightB.getPosY()) {
					
					return true;
				}//end if
				
				else if(next[0] == player.rookW.getPosX() && next[1] == player.rookW.getPosY()) {
					
					return true;
				}//end if
				
				else if(next[0] == player.rookB.getPosX() && next[1] == player.rookB.getPosY()) {
					
					return true;
				}//end if
				
				else if(next[0] == player.bishopB.getPosX() && next[1] == player.bishopB.getPosY()) {
					
					return true;
				}//end if
				
				else if(next[0] == player.bishopW.getPosX() && next[1] == player.bishopW.getPosY()) {
					
					return true;
				}//end if
				
				else if(next[0] == player.queen.getPosX() && next[1] == player.queen.getPosY()) {
					
					return true;
				}//end if
				
				else if(next[0] == player.king.getPosX() && next[1] == player.king.getPosY()) {
					
					return false;
				}//end if
				
				for(i = 0; i < 8 ;i ++) {
					
					if(pos[0] == player.vecPawn.get(i).getPosX() && pos[1] == player.vecPawn.get(i).getPosY()) {
						
						
						continue;
					}//end if
					if(next[0] == player.vecPawn.get(i).getPosX() && next[1] == player.vecPawn.get(i).getPosY()) {
					
						return true;
					}//end if
	
				}//end for loop
				obj.setPos(next);
				return true;
			}//end if
			
		return false;
	}//end validPawn
	
	public <T extends Piece, J extends Player> boolean validKnight(T obj, J player, int[] next){

		int[] pos = obj.getPos();
		int i;
		int[] endW = {-1, -1};
		int[] endB = {8, 8};		
			
	
	
	
	
	
			if(next[0] == pos[0] && next[1] == pos[1]){

				return false;
			}//end if

			if(obj.slope(next) == player.knightB.slope(pos) && player.knightB.getPosX() == next[0] && player.knightB.getPosY() == next[1]){
				

					
				if(this.color && !player.knightB.getColor()){
					
					obj.setPos(next);
					player.knightB.setPos(endW);
					return true;
				}//end if
				else if(!this.color && player.knightB.getColor()){
					obj.setPos(next);
					player.knightB.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			
			
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == player.knightW.slope(pos) && player.knightW.getPosX() == next[0] && player.knightW.getPosY() == next[1]){
				

									
				if(this.color && !player.knightW.getColor()){
					obj.setPos(next);
					player.knightW.setPos(endW);
					return true;
				}//end if
				else if(!this.color && player.knightW.getColor()){
					obj.setPos(next);
					player.knightW.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == player.rookB.slope(pos) && player.rookB.getPosX() == next[0] && player.rookB.getPosY() == next[1]){
				

								
				if(this.color && !player.rookB.getColor()){
					obj.setPos(next);
					player.rookB.setPos(endW);
					return true;
				}//end if
				else if(!this.color && player.rookB.getColor()){
					obj.setPos(next);
					player.rookB.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == player.rookW.slope(pos) && player.rookW.getPosX() == next[0] && player.rookW.getPosY() == next[1]){
				

									
				if(this.color && !player.rookW.getColor()){
					obj.setPos(next);
					player.rookW.setPos(endW);
					return true;
				}//end if
				else if(!this.color && player.rookW.getColor()){
					obj.setPos(next);
					player.rookW.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == player.bishopB.slope(pos) && player.bishopB.getPosX() == next[0] && player.bishopB.getPosY() == next[1]){
				
					
				if(this.color && !player.bishopB.getColor()){
					obj.setPos(next);
					player.bishopB.setPos(endW);
					return true;
				}//end if
				else if(!this.color && player.bishopB.getColor()){
					obj.setPos(next);
					player.bishopB.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == player.bishopW.slope(pos) && player.bishopW.getPosX() == next[0] && player.bishopW.getPosY() == next[1]){
				

									
				if(this.color && !player.bishopW.getColor()){
					obj.setPos(next);
					player.bishopW.setPos(endW);
					return true;
				}//end if
				else if(!this.color && player.bishopW.getColor()){
					obj.setPos(next);
					player.bishopW.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == player.king.slope(pos) && player.king.getPosX() == next[0] && player.king.getPosY() == next[1]){
				

				return false;

			}//end if 
			
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == player.queen.slope(pos) && player.queen.getPosX() == next[0] && player.queen.getPosY() == next[1]){
				

									
				if(this.color && !player.queen.getColor()){
					obj.setPos(next);
					player.queen.setPos(endW);
					return true;
				}//end if
				else if(!this.color && player.queen.getColor()){
					obj.setPos(next);
					player.queen.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			for(i = 0; i < 8; i++){
			
				
				
				if(obj.slope(next) == player.vecPawn.get(i).slope(pos) && player.vecPawn.get(i).getPosX() == next[0] && player.vecPawn.get(i).getPosY() == next[1]){
				

										
					if(this.color && !player.vecPawn.get(i).getColor()){
						obj.setPos(next);
						vecPawn.get(i).setPos(endW);
						return true;
					}//end if
					else if(!this.color && player.vecPawn.get(i).getColor()){
						obj.setPos(next);
						player.vecPawn.get(i).setPos(endB);
						return true;
					}//end else
					else{
						return false;
					}

					}//end if 
				
				/*---------------------------------------------------------------------------------------------------------------------*/
			}//end for loop
			obj.setPos(next);
			return true;		
	}//end validKnight

	
	
	public <T extends Piece, J extends Player> boolean valid(T obj, J player, int[] next){

		int[] pos = obj.getPos();
		int i;
		int[] endW = {-1, -1};
		int[] endB = {8, 8};		
			
	
	
	
	
	
			if(next[0] == pos[0] && next[1] == pos[1]){

				return true;
			}//end if

			if(obj.slope(next) == player.knightB.slope(pos) && player.knightB.getPosX() == next[0] && player.knightB.getPosY() == next[1]){
				

					
				if(this.color && !player.knightB.getColor()){
					obj.setPos(next);
					player.knightB.setPos(endW);
					return true;
				}//end if
				else if(!this.color && player.knightB.getColor()){
					obj.setPos(next);
					player.knightB.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			else if(obj.slope(next) == player.knightB.slope(pos) && obj.dist(player.knightB.getPos()) < obj.dist(next)){

				return false;
					
			
			}//end else if 
			else if(obj.slope(next) == player.knightB.slope(pos) && obj.dist(player.knightB.getPos()) > obj.dist(next)){

				
				obj.setPos(next);
				return true;

			}//end else if
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == player.knightW.slope(pos) && player.knightW.getPosX() == next[0] && player.knightW.getPosY() == next[1]){
				

									
				if(this.color && !player.knightW.getColor()){
					obj.setPos(next);
					player.knightW.setPos(endW);
					return true;
				}//end if
				else if(!this.color && player.knightW.getColor()){
					obj.setPos(next);
					player.knightW.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			else if(obj.slope(next) == player.knightW.slope(pos) && obj.dist(player.knightW.getPos()) < obj.dist(next)){

				return false;
					
			
			}//end else if 
			else if(obj.slope(next) == player.knightW.slope(pos) && obj.dist(player.knightW.getPos()) > obj.dist(next)){

				
				obj.setPos(next);
				return true;

			}//end else if
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == player.rookB.slope(pos) && player.rookB.getPosX() == next[0] && player.rookB.getPosY() == next[1]){
				

								
				if(this.color && !player.rookB.getColor()){
					obj.setPos(next);
					player.rookB.setPos(endW);
					return true;
				}//end if
				else if(!this.color && player.rookB.getColor()){
					obj.setPos(next);
					player.rookB.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			else if(obj.slope(next) == player.rookB.slope(pos) && obj.dist(player.rookB.getPos()) < obj.dist(next)){

				return false;
					
			
			}//end else if 
			else if(obj.slope(next) == player.rookB.slope(pos) && obj.dist(player.rookB.getPos()) > obj.dist(next)){

				
				obj.setPos(next);
				return true;

			}//end else if
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == player.rookW.slope(pos) && player.rookW.getPosX() == next[0] && player.rookW.getPosY() == next[1]){
				

									
				if(this.color && !player.rookW.getColor()){
					obj.setPos(next);
					player.rookW.setPos(endW);
					return true;
				}//end if
				else if(!this.color && player.rookW.getColor()){
					obj.setPos(next);
					player.rookW.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			else if(obj.slope(next) == player.rookW.slope(pos) && obj.dist(player.rookW.getPos()) < obj.dist(next)){

				return false;
					
			
			}//end else if 
			else if(obj.slope(next) == player.rookW.slope(pos) && obj.dist(player.rookW.getPos()) > obj.dist(next)){

				
				obj.setPos(next);
				return true;

			}//end else if
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == player.bishopB.slope(pos) && player.bishopB.getPosX() == next[0] && player.bishopB.getPosY() == next[1]){
				
					
				if(this.color && !player.bishopB.getColor()){
					obj.setPos(next);
					player.bishopB.setPos(endW);
					return true;
				}//end if
				else if(!this.color && player.bishopB.getColor()){
					obj.setPos(next);
					player.bishopB.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			else if(obj.slope(next) == player.bishopB.slope(pos) && obj.dist(player.bishopB.getPos()) < obj.dist(next)){

				return false;
					
			
			}//end else if 
			else if(obj.slope(next) == player.bishopB.slope(pos) && obj.dist(player.bishopB.getPos()) > obj.dist(next)){

				
				obj.setPos(next);
				return true;

			}//end else if
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == player.bishopW.slope(pos) && player.bishopW.getPosX() == next[0] && player.bishopW.getPosY() == next[1]){
				

									
				if(this.color && !player.bishopW.getColor()){
					obj.setPos(next);
					player.bishopW.setPos(endW);
					return true;
				}//end if
				else if(!this.color && player.bishopW.getColor()){
					obj.setPos(next);
					player.bishopW.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			else if(obj.slope(next) == player.bishopW.slope(pos) && obj.dist(player.bishopW.getPos()) < obj.dist(next)){

				return false;
					
			
			}//end else if 
			else if(obj.slope(next) == player.bishopW.slope(pos) && obj.dist(player.bishopW.getPos()) > obj.dist(next)){

				
				obj.setPos(next);
				return true;

			}//end else if
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == player.king.slope(pos) && player.king.getPosX() == next[0] && player.king.getPosY() == next[1]){
				

				return false;

			}//end if 
			else if(obj.slope(next) == player.king.slope(pos) && obj.dist(player.king.getPos()) < obj.dist(next)){

				return false;
					
			
			}//end else if 
			else if(obj.slope(next) == player.king.slope(pos) && obj.dist(player.king.getPos()) > obj.dist(next)){

				
				obj.setPos(next);
				return true;

			}//end else if
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == player.queen.slope(pos) && player.queen.getPosX() == next[0] && player.queen.getPosY() == next[1]){
				

									
				if(this.color && !player.queen.getColor()){
					obj.setPos(next);
					player.queen.setPos(endW);
					return true;
				}//end if
				else if(!this.color && player.queen.getColor()){
					obj.setPos(next);
					player.queen.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			else if(obj.slope(next) == player.queen.slope(pos) && obj.dist(player.queen.getPos()) < obj.dist(next)){

				return false;
					
			
			}//end else if 
			else if(obj.slope(next) == player.queen.slope(pos) && obj.dist(player.queen.getPos()) > obj.dist(next)){

				
				obj.setPos(next);
				return true;

			}//end else if
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			for(i = 0; i < 8; i++){
			
				
				
				if(obj.slope(next) == player.vecPawn.get(i).slope(pos) && player.vecPawn.get(i).getPosX() == next[0] && player.vecPawn.get(i).getPosY() == next[1]){
				

										
					if(this.color && !player.vecPawn.get(i).getColor()){
						obj.setPos(next);
						vecPawn.get(i).setPos(endW);
						return true;
					}//end if
					else if(!this.color && player.vecPawn.get(i).getColor()){
						obj.setPos(next);
						player.vecPawn.get(i).setPos(endB);
						return true;
					}//end else
					else{
						return false;
					}

					}//end if 
				else if(obj.slope(next) == player.vecPawn.get(i).slope(pos) && obj.dist(player.vecPawn.get(i).getPos()) < obj.dist(next)){

					return false;
					
			
				}//end else if 
				else if(obj.slope(next) == player.vecPawn.get(i).slope(pos) && obj.dist(player.vecPawn.get(i).getPos()) > obj.dist(next)){
	
				
					obj.setPos(next);
					return true;

				}//end else if
				/*---------------------------------------------------------------------------------------------------------------------*/
			}//end for loop
				return false;
	}//end valid

}//end Player class




























