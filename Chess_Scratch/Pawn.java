class Pawn extends Piece{

	private boolean start;
	
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
	
	public boolean MoveChoose(int[] next, boolean take){
		double slope = slope(this.position, next);
		double dist = dist(this.position, next);
		if(!take){

			if(this.color){
				
				if(slope == 1 && next[1] > this.position[1] || slope == 100 && next[1] > this.position[1]){
					
					if(this.start) {
						
						if(dist == 1 || dist == 2){
							this.start = false;
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
						this.start = false;
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


				if(slope == 1 && this.position[1] > next [1]){
					
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


}//end Pawn class
