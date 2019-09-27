import java.util.*;
class Pawn extends Piece{

	public boolean start;
	
	public Pawn(boolean color){
		this.start = true;
		this.color = color;

		if(color){
		
			this.name = "P";
		}//end if
		else if(!color){

			this.name = "p";
		}//end else if

	}//end constructor
	public boolean MoveChoose(int[] next){
		boolean dumb = true;
		return dumb;
	}//end MoveChoose
	public boolean moveChoose(int[] next, boolean take){

		double slope = slope(this.position, next);
		double dist = dist(this.position, next);
		if(!take){

			if(this.color){
				
				if(Math.abs(slope) == 1 && next[1] > this.position[1] || slope == 100 && next[1] > this.position[1]){
					
					if(this.start) {
						
						if(dist == 1 || dist == 2){
							return true;
	
						}//end else if
						
						else{
							
							return false;
	
						}//end else
						
					}//end if
					
					else if(!this.start) {
					
						if(dist == 1){
							
							return true;
	
						}//end else if
						
						else{
							
							return false;
	
						}//end else
		
						
					}//end else if
					
					else {
						
						return false;
						
					}//end else
					
				}//end if  
				
				else{

					return false;

				}//end else

			}//end if
		
			else if(!this.color){
				
				if(this.start) {
					
					if(dist == 1 || dist == 2){
						return true;

					}//end else if
					
					else{
						
						return false;

					}//end else
					
				}//end if
				
				else if(!this.start) {
				
					if(dist == 1){
						
						return true;

					}//end else if
					
					else{
						
						return false;

					}//end else
	
					
				}//end else if
				
				else {
					
					return false;
					
				}//end else
			
			}//end else if
			
		}//end if	
		
		else if(take){


			if(this.color){	
		
				if(Math.abs(slope) == 1 && this.position[1] < next[1]){
					
					if(dist > 1.3 && dist < 1.5){
						
						return true;

					}//end if
					else{

						return false;

					}//end else
					
			
				}//end if

				else{

					return false;

				}//end else



			}//end if


			else if(!this.color){

				double bigGay = Math.abs(slope);
				if(bigGay == 1 && this.position[1] > next [1]){
					
					if(dist > 1.3 && dist < 1.5){
						
						return true;

					}//end if
					else{

						return false;

					}//end else
					
			
				}//end if

				else{

					return false;

				}//end else



			}//end else if

			else{

				return false;

			}//end else

			
		}//end else if
			


		return false;

	}//end Move Choose



	public Vector<int[]> RedSpot(){

		int[] ar[][] = {{{0,0},{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0}},{{0,1},{1,1},{2,1},{3,1},{4,1},{5,1},{6,1},{7,1}},{{0,2},{1,2},{2,2},{3,2},{4,2},{5,2},{6,2},{7,2}}
		,{{0,3},{1,3},{2,3},{3,3},{4,3},{5,3},{6,3},{7,3}},{{0,4},{1,4},{2,4},{3,4},{4,4},{5,4},{6,4},{7,4}},{{0,5},{1,5},{2,5},{3,5},{4,5},{5,5},{6,5},{7,5}}
		,{{0,6},{1,6},{2,6},{3,6},{4,6},{5,6},{6,6},{7,6}},{{0,7},{1,7},{2,7},{3,7},{4,7},{5,7},{6,7},{7,7}}};
		
		Vector<int[]> vecred = new Vector<int[]>();
		int j, i;
		
		for(i = 0; i < 8; i++){

			for(j = 0; j < 8; j++){
				
				if(moveChoose(ar[i][j], false)){
					
					vecred.add(ar[i][j]);
				
				}//end if


			}//end for loop
			

		}//end for loop
		
		return vecred;

	}//end redSpot

	

	

}//end Pawn class
