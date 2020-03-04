import java.util.*;

class King extends Piece{


	public boolean safety;

	public King(boolean color){
		
		this.safety = true;

		this.color = color;

		if(color){

			this.name = "K";
		}//end if
		else if(!color){

			this.name = "k";
		}//end else if

	}//end king	

	public boolean MoveChoose(int[] next){

		boolean dumb = true;	
		return dumb;
	}//end MoveChoose

	public boolean moveChoose(int[] next, Vector<int[]> vecfilt){

		double slope = slope(this.position, next);
		double dist = dist(this.position, next);
		int i;

		if(Math.abs(slope) == 1){

			if(dist < 1.5 && dist > 1.3){
				
				for(i = 0; i < vecfilt.size(); i++){
					
					if(Arrays.equals(vecfilt.get(i), next)){
						return false;

					}//end if

				}//end for loop
				return true;
			}//end if

			else{
 
				return false;
			}//end else

		}//end if
		
		else if(slope == 0 || slope == 100) {
			
			if(dist == 1) {
				
				for(i = 0; i < vecfilt.size(); i++){
					
					if(Arrays.equals(vecfilt.get(i), next)){
						return false;

					}//end if

				}//end for loop
				return true;
			}//end if
			
			else return false;
			
			
		}//end else if

		else{
			return false;
		}//end else

	}//end moveChoose

	public Vector<int[]> RedSpot(Vector<int[]> vecfilt){

		int[] ar[][] = {{{0,0},{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0}},{{0,1},{1,1},{2,1},{3,1},{4,1},{5,1},{6,1},{7,1}},{{0,2},{1,2},{2,2},{3,2},{4,2},{5,2},{6,2},{7,2}}
		,{{0,3},{1,3},{2,3},{3,3},{4,3},{5,3},{6,3},{7,3}},{{0,4},{1,4},{2,4},{3,4},{4,4},{5,4},{6,4},{7,4}},{{0,5},{1,5},{2,5},{3,5},{4,5},{5,5},{6,5},{7,5}}
		,{{0,6},{1,6},{2,6},{3,6},{4,6},{5,6},{6,6},{7,6}},{{0,7},{1,7},{2,7},{3,7},{4,7},{5,7},{6,7},{7,7}}};
		
		Vector<int[]> vecred = new Vector<int[]>();
		int j, i;
		
		for(i = 0; i < 8; i++){

			for(j = 0; j < 8; j++){
				
				if(moveChoose(ar[i][j], vecfilt)){
					
					vecred.add(ar[i][j]);
				
				}//end if


			}//end for loop
			

		}//end for loop
		
		return vecred;

	}//end redSpot


	public String mate(Vector<int[]> vecfilt){
		int i;
		Vector<int[]> vectemp = vecfilt;
	
			
		for(i = 0; i < vecfilt.size(); i++) {
				
			if(Arrays.equals(this.position, vecfilt.get(i))) {
					
				if(vectemp.isEmpty()) {
					
					return "m";
					
				}//end if
				
				else {
					
					return "c";
				}//end else
					
			}//end if
			
		}//end for loop
				
		
			
		return "";
			
		
		
	}//end mate




}//end King class
