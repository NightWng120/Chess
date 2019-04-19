class Queen extends Piece{

	public Queen(){
		
		this.name = "Q";	
	
	}//end constructor
	

	public boolean moveChoose(int[] next){

		double slope = slope(next);
		(slope == 1){
			if((this.position[0] - next[0]) > 0){

				moveDownX(false, (this.position[0] - next[0]));
				return true;
			}//end if
			else if((next[0] - this.position[0]) > 0){
	
				moveUpX(true, (next[0] - this.position[0]));
				return true;

			}//end else if
								
		}//end if

		else if(slope == -1){

			if((this.position[0] - next[0]) > 0){

			
				moveUpX(false, (this.position[0] - next[0]));
				return true;
			}//end if
			else if((next[0] - this.position[0]) > 0){

				moveUpX(true, (next[0] - this.position[0]));
				return true;
			}//end else if

		}//end else if
		else if(slope == 0){
			
			if((this.position[0] - next[0]) > 0){

				moveX(false, (this.position[0] - next[0]));
				return true;				
			}//end if
			else if((next[0] - this.position[0]) > 0){

				moveX(true, (next[0] - this.position[0]));
				return true;
			}//end else if

		}//end else if
		else if(slope == 3){

			if((this.position[1] - next[1]) > 0){

				moveY(false, (this.position[1] - next[1]));
				return true;				

			}//end if
			else if((next[1] - this.position[1]) > 0){

				moveY(true, (next[1] - this.position[1]));
				return true;

			}//end else if

		}//end else if
		else{
			return false;

		}//end else
		return false;
	}//end moveChoose


	public void moveUpX(boolean move, int dist){

		if(move && bound(this.position[0], dist, 8) && bound(this.position[1], dist,  8)){
			this.position[0] += dist;
			this.position[1] += dist; 
		}//end if	
		
		else if(!move && bound(this.position[0], -dist, -1) && bound(this.position[1], dist,  8)) {
			this.position[0] -= dist;
			this.position[1] += dist;
		}//end else	
	}//end moveUpX		

	public void moveY(boolean move, int dist){
		
		if(move && bound(this.position[1], dist, 8)){
			this.position[1] += dist;

		}//end if
		else if(!move && bound(this.position[1], -dist, -1)){
			this.position[1] -= dist;
		}//end if


	}//end moveY
	public void moveX(boolean move, int dist){

		if(move && bound(this.position[0], dist, 8)){
			this.position[0] += dist;
		}//end if
		else if(!move && bound(this.position[0], -dist, -1)){
			this.position[0] -= dist;
		}//end else if

	}//end moveX
	public void moveDownX(boolean move, int dist){


		if(move && bound(this.position[0], 1, 8) && bound(this.position[1], -dist, -1)){
			this.position[0] += dist;
			this.position[1] -= dist;
		}//end if
		else if(!move && bound(this.position[0], -dist, -1) && bound(this.position[1], dist, 8)){

			this.position[0] -= dist;
			this.position[1] += dist;
		}//end else if


	}//end moveDownX

}//end Queen class












