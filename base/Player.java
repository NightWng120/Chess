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
		this.queen.setColor(color);
		this.king.setColor(color);
		this.bishopW.setColor(color);
		this.bishopB.setColor(color);
		this.rookW.setColor(color);
		this.rookB.setColor(color);
		this.knightB.setColor(color);
		this.knightW.setColor(color);

		for(i = 0; i < 8; i++){

			this.vecPawn.add(new Pawn());
			this.vecPawn.lastElement().setColor(color);
		}//end for loop



	}//end constructor
	
	public boolean movePiece(int[] pos, int[] next){


		
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
		int i;	
			
			

	
			
		if(pos[0] > 7 || pos[1] > 7 || next[0] > 7 || next[1] > 7 || pos[0] < 0 || pos[1] < 0 || next[0] < 0 || next[1] < 0){

			return false;

		}//end if
		
		else{
        
			if(pos[0] == arQ[0] && pos[1] == arQ[1]){

				if(queen.moveChoose(next)){
					
					return valid(queen, next);
				}//end if
				return false;

			}//end if
			if(pos[0] == arK[0] && pos[1] == arK[1]){
				


			}//end if
			if(pos[0] == arkB[0] && pos[1] == arkB[1]){
				if(knightB.moveChoose){

					return valid(
				}//end if	
				

			}//end if
			if(pos[0] == arkW[0] && pos[1] == arkW[1]){



			}//end if
			if(pos[0] == arbW[0] && pos[1] == arbW[1]){

				if(valid(bishopW, next)){
					bishopW.moveChoose(next);
			
					return true;
				}//end if

			}//end if
			if(pos[0] == arbB[0] && pos[1] == arbB[1]){
				
				if(valid(bishopB, next)){
					
					bishopB.moveChoose(next);
					
					return true;
				}//end if

			}//end if
			if(pos[0] == arrW[0] && pos[1] == arrW[1]){

				if(valid(rookW, next)){

					rookW.moveChoose(next);

					return true;
				}//end if
			}//end if
			if(pos[0] == arrB[0] && pos[1] == arrB[1]){
				
				
				if(valid(rookB, next)){
					
					
					
					rookW.moveChoose(next);
					
					return true;
				}//end if


			}//end if
			if(pos[0] == arp1[0] && pos[1] == arp1[1]){

				if(validPawn(vecPawn(0), next, 0)){
					
					vecPawn(0).moveChoose(next);
		
					return true;
				}//end if

			}//end if
			if(pos[0] == arp2[0] && pos[1] == arp2[1]){

				if(validPawn(vecPawn(1), next, 1)){
					
					vecPawn(1).moveChoose(next);
			

					return true;
				}//end if
			}//end if
			if(pos[0] == arp3[0] && pos[1] == arp3[1]){

				if(validPawn(vecPawn(2), next, 2)){
					
					vecPawn(2).moveChoose(next);
				
					return true;
				}//end if

			}//end if
			if(pos[0] == arp4[0] && pos[1] == arp4[1]){

				if(validPawn(vecPawn(3), next, 3)){
					
					vecPawn(3).moveChoose(next);
				
					return true;
				}//end if

			}//end if
			if(pos[0] == arp5[0] && pos[1] == arp5[1]){

				if(validPawn(vecPawn(4), next, 4)){
					
					vecPawn(4).moveChoose(next);
				
					return true;
				}//end if

			}//end if
			if(pos[0] == arp6[0] && pos[1] == arp6[1]){

				if(validPawn(vecPawn(5), next, 5)){
					
					vecPawn(5).moveChoose(next);
			
					return true;
				}//end if

			}//end if
			if(pos[0] == arp7[0] && pos[1] == arp7[1]){

				if(validPawn(vecPawn(6), next, 6)){
					
					vecPawn(6).moveChoose(next);
				
					return true;
				}//end if

			}//end if
			if(pos[0] == arp8[0] && pos[1] == arp8[1]){
				
				if(validPawn(vecPawn(7), next, 7)){
					
					vecPawn(7).moveChoose(next);
			
					return true;
				}//end if
			
			}//end if
			
        
		}//end else
		return false;
	}//end movePiece
	
	public boolean validPawn(Pawn pawn, int[] next, int iter){
		
		int i;
		int[] endB = {8,8};
		int[] endW = {-1,-1};
		
		if(pawn.slope(next) == 1 && pawn.dist(next) == sqrt(2)){
					
					if(pawn.getPosX() > next[0] || pawn.getPosY() > next[1]){
							
							return false;
						
					}//end if
					
					else if(next[0] == knightB.getPosX() && next[1] == knightB.getPosY()){
						
						
						
						if(this.color && !knightB.getColor()){
							
							knightB.setPos(endW);
							return true;
						}//end if
						
						else if(!this.color && knightB.getColor()){
							knightB.setPos(endB);
							return true;
							
						}//end else if
						else{
							
							return false;
							
						}//end else
						
					}//end else if
					/*------------------------------------------------------------------*/
									
					else if(next[0] == knightW.getPosX() && next[1] == knightW.getPosY()){
						
						if(this.color && !knightW.getColor()){
							
							knightW.setPos(endW);
							return true;
						}//end if
						
						else if(!this.color && knightW.getColor()){
							knightW.setPos(endB);
							return true;
							
						}//end else if
						else{
							
							return false;
							
						}//end else
						
					}//end else if
					/*------------------------------------------------------------------*/
					
					else if(next[0] == rookB.getPosX() && next[1] == rookB.getPosY()){
						
						if(this.color && !rookB.getColor()){
							
							rookB.setPos(endW);
							return true;
						}//end if
						
						else if(!this.color && rookB.getColor()){
							rookB.setPos(endB);
							returntrue;
							
						}//end else if
						else{
							
							return false;
							
						}//end else
						
					}//end else if
					/*------------------------------------------------------------------*/
					
					else if(next[0] == rookW.getPosX() && next[1] == rookW.getPosY()){
						
						if(this.color && !rookW.getColor()){
							
							rookW.setPos(endW);
							return true;
						}//end if
						
						else if(!this.color && rookW.getColor()){
							rookW.setPos(endB);
							return true;
							
						}//end else if
						else{
							
							return false;
							
						}//end else
						
					}//end else if
					/*------------------------------------------------------------------*/
					
					else if(next[0] == bishopB.getPosX() && next[1] == bishopB.getPosY()){
						
						if(this.color && !bishopB.getColor()){
							
							bishopB.setPos(endW);
							return true;
						}//end if
						
						else if(!this.color && bishopB.getColor()){
							bishopB.setPos(endB);
							return true;
							
						}//end else if
						else{
							
							return false;
							
						}//end else
						
					}//end else if
					/*------------------------------------------------------------------*/
					
					else if(next[0] == bishopW.getPosX() && next[1] == bishopW.getPosY()){
						
						if(this.color && !bishopW.getColor()){
							
							bishopW.setPos(endW);
							return true;
						}//end if
						
						else if(!this.color && bishopW.getColor()){
							bishopW.setPos(endB);
							return true;
							
						}//end else if
						else{
							
							return false;
							
						}//end else
						
					}//end else if
					/*------------------------------------------------------------------*/
					
					else if(next[0] == queen.getPosX() && next[1] == queen.getPosY()){
						
						if(this.color && !queen.getColor()){
							
							queen.setPos(endW);
							return true;
						}//end if
						
						else if(!this.color && queen.getColor()){
							queen.setPos(endB);
							return true);
							
						}//end else if
						else{
							
							return false;
							
						}//end else
						
					}//end else if
					/*------------------------------------------------------------------*/
					
					else if(next[0] == king.getPosX() && next[1] == king.getPosY()){
						
						if(this.color && !king.getColor()){
							
							king.setPos(endW);
							return true;
						}//end if
						
						else if(!this.color && king.getColor()){
							king.setPos(endB);
							return true;
							
						}//end else if
						else{
							
							return false;
							
						}//end else
						
					}//end else if
					/*------------------------------------------------------------------*/
					
					for(i = 0; i < 8; i++){
					
						if(i == iter){
							
							continue;
							
						}//end if
						if(next[0] == vecPawn.get(i).getPosX() && next[1] == vecPawn.get(i).getPosY()){
						
							if(this.color && !vecPawn.get(i).getColor()){
							
							vecPawn.get(i).setPos(endW);
							return true;
							}//end if
						
							else if(!this.color && vecPawn.get(i).getColor()){
							vecPawn.get(i).setPos(endB);
							return true;
							
							}//end else if
							else{
							
								return false;
							
							}//end else
						
						}//end if
					}//end for loop
					/*------------------------------------------------------------------*/
					
					
	
		}//end if
		else if(pawn.slope(next) == 3){

			return true;

		}//end if
		else{
			
			return false;
		}//end else
		
		
	}//end validPawn

	public <T extends Piece> boolean valid(T obj, int[] next){

		int[] pos = obj.getPos();
		int i;
		int[] endW = {-1, -1};
		int[] endB = {8, 8};		
			
	
	
	
	
	
			if(next[0] == pos[0] && next[1] == pos[1]){

				return true;
			}//end if

			if(obj.slope(next) == knightB.slope(pos) && knightB.getPosX() == next[0] && knightB.getPosY() == next[1]){
				

					
				if(this.color && !knightB.getColor()){
					obj.setPos(next);
					knightB.setPos(endW);
					return true;
				}//end if
				else if(!this.color && knightB.getColor()){
					obj.setPos(next);
					knightB.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			else if(obj.slope(next) == knightB.slope(pos) && obj.dist(knightB.getPos()) < obj.dist(next)){

				return false;
					
			
			}//end else if 
			else if(obj.slope(next) == knightB.slope(pos) && obj.dist(knightB.getPos()) > obj.dist(next)){

				
				obj.setPos(next);
				return true;

			}//end else if
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == knightW.slope(pos) && knightW.getPosX() == next[0] && knightW.getPosY() == next[1]){
				

									
				if(this.color && !knightW.getColor()){
					obj.setPos(next);
					knightW.setPos(endW);
					return true;
				}//end if
				else if(!this.color && knightW.getColor()){
					obj.setPos(next);
					knightW.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			else if(obj.slope(next) == knightW.slope(pos) && obj.dist(knightW.getPos()) < obj.dist(next)){

				return false;
					
			
			}//end else if 
			else if(obj.slope(next) == knightW.slope(pos) && obj.dist(knightW.getPos()) > obj.dist(next)){

				
				obj.setPos(next);
				return true;

			}//end else if
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == rookB.slope(pos) && rookB.getPosX() == next[0] && rookB.getPosY() == next[1]){
				

								
				if(this.color && !rookB.getColor()){
					obj.setPos(next);
					rookB.setPos(endW);
					return true;
				}//end if
				else if(!this.color && rookB.getColor()){
					obj.setPos(next);
					rookB.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			else if(obj.slope(next) == rookB.slope(pos) && obj.dist(rookB.getPos()) < obj.dist(next)){

				return false;
					
			
			}//end else if 
			else if(obj.slope(next) == rookB.slope(pos) && obj.dist(rookB.getPos()) > obj.dist(next)){

				
				obj.setPos(next);
				return true;

			}//end else if
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == rookW.slope(pos) && rookW.getPosX() == next[0] && rookW.getPosY() == next[1]){
				

									
				if(this.color && !rookW.getColor()){
					obj.setPos(next);
					rookW.setPos(endW);
					return true;
				}//end if
				else if(!this.color && rookW.getColor()){
					obj.setPos(next);
					rookW.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			else if(obj.slope(next) == rookW.slope(pos) && obj.dist(rookW.getPos()) < obj.dist(next)){

				return false;
					
			
			}//end else if 
			else if(obj.slope(next) == rookW.slope(pos) && obj.dist(rookW.getPos()) > obj.dist(next)){

				
				obj.setPos(next);
				return true;

			}//end else if
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == bishopB.slope(pos) && bishopB.getPosX() == next[0] && bishopB.getPosY() == next[1]){
				
					
				if(this.color && !bishopB.getColor()){
					obj.setPos(next);
					bishopB.setPos(endW);
					return true;
				}//end if
				else if(!this.color && bishopB.getColor()){
					obj.setPos(next);
					bishopB.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			else if(obj.slope(next) == bishopB.slope(pos) && obj.dist(bishopB.getPos()) < obj.dist(next)){

				return false;
					
			
			}//end else if 
			else if(obj.slope(next) == bishopB.slope(pos) && obj.dist(bishopB.getPos()) > obj.dist(next)){

				
				obj.setPos(next);
				return true;

			}//end else if
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == bishopW.slope(pos) && bishopW.getPosX() == next[0] && bishopW.getPosY() == next[1]){
				

									
				if(this.color && !bishopW.getColor()){
					obj.setPos(next);
					bishopW.setPos(endW);
					return true;
				}//end if
				else if(!this.color && bishopW.getColor()){
					obj.setPos(next);
					bishopW.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			else if(obj.slope(next) == bishopW.slope(pos) && obj.dist(bishopW.getPos()) < obj.dist(next)){

				return false;
					
			
			}//end else if 
			else if(obj.slope(next) == bishopW.slope(pos) && obj.dist(bishopW.getPos()) > obj.dist(next)){

				
				obj.setPos(next);
				return true;

			}//end else if
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == king.slope(pos) && king.getPosX() == next[0] && king.getPosY() == next[1]){
				

									
				if(this.color && !king.getColor()){
					obj.setPos(next);
					king.setPos(endW);
					return true;
				}//end if
				else if(!this.color && king.getColor()){
					obj.setPos(next);
					king.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			else if(obj.slope(next) == king.slope(pos) && obj.dist(king.getPos()) < obj.dist(next)){

				return false;
					
			
			}//end else if 
			else if(obj.slope(next) == king.slope(pos) && obj.dist(king.getPos()) > obj.dist(next)){

				
				obj.setPos(next);
				return true;

			}//end else if
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			else if(obj.slope(next) == queen.slope(pos) && queen.getPosX() == next[0] && queen.getPosY() == next[1]){
				

									
				if(this.color && !queen.getColor()){
					obj.setPos(next);
					queen.setPos(endW);
					return true;
				}//end if
				else if(!this.color && queen.getColor()){
					obj.setPos(next);
					queen.setPos(endB);
					return true;
				}//end else
				else{
					return false;
				}

			}//end if 
			else if(obj.slope(next) == queen.slope(pos) && obj.dist(queen.getPos()) < obj.dist(next)){

				return false;
					
			
			}//end else if 
			else if(obj.slope(next) == queen.slope(pos) && obj.dist(queen.getPos()) > obj.dist(next)){

				
				obj.setPos(next);
				return true;

			}//end else if
			/*---------------------------------------------------------------------------------------------------------------------*/
			
			for(i = 0; i < 8; i++){
			
				if(obj.slope(next) == vecPawn.get(i).slope(pos) && knightB.getPosX() == next[0] && vecPawn.get(i).getPosY() == next[1]){
				

										
					if(this.color && !vecPawn.get(i).getColor()){
						obj.setPos(next);
						vecPawn.get(i).setPos(endW);
						return true;
					}//end if
					else if(!this.color && vecPawn.get(i).getColor()){
						obj.setPos(next);
						vecPawn.get(i).setPos(endB);
						return true;
					}//end else
					else{
						return false;
					}

					}//end if 
				else if(obj.slope(next) == vecPawn.get(i).slope(pos) && obj.dist(vecPawn.get(i).getPos()) < obj.dist(next)){

					return false;
					
			
				}//end else if 
				else if(obj.slope(next) == vecPawn.get(i).slope(pos) && obj.dist(vecPawn.get(i).getPos()) > obj.dist(next)){
	
				
					obj.setPos(next);
					return true;

				}//end else if
				/*---------------------------------------------------------------------------------------------------------------------*/
			}//end for loop
				return true;
	}//end valid

}//end Player class




























