class Knight extends Piece{


	public Knight(boolean name){
		
		if(name){
			
			this.name = "N";

		}//end if
		else if(!name){

			this.name = "n";
		}//end else if
	}//end constructor
	public boolean moveChoose(int[] next) {
		
		if(slope(next) == 2) {
			if((this.position[0] - next[0]) > 0 && (this.position[1] - next[1]) > 0) {
				
				return moveDleft(true);
				
			}//end if
			else if((this.position[0] - next[0]) > 0 && (next[1] - this.position[1]) > 0) {
				
				
				return moveUleft(true);
				
			}//end else if
			else if((next[0] - this.position[0]) > 0 && (this.position[1] - next[1]) > 0) {
				
				
				return moveDright(true);
					
			}//end else if
			else if((next[0] - this.position[0]) > 0 && (next[1] - this.position[1]) > 0) {
				
				
				return moveUright(true);
				
			}//end else if
			
		}//end if
		else if(slope(next) == .5) {
		
			if((this.position[0] - next[0]) > 0 && (this.position[1] - next[1]) > 0) {
				
				return moveDleft(false);
				
			}//end if
			else if((this.position[0] - next[0]) > 0 && (next[1] - this.position[1]) > 0) {
				
				
				return moveUleft(false);
				
			}//end else if
			else if((next[0] - this.position[0]) > 0 && (this.position[1] - next[1]) > 0) {
				
				
				return moveDright(false);
					
			}//end else if
			else if((next[0] - this.position[0]) > 0 && (next[1] - this.position[1]) > 0) {
				
				
				return moveUright(false);
				
			}//end else if
		
		}//end else if
		return false;
	
	}//end moveChoose

	public boolean moveUleft(boolean move){
		if(move && bound(this.position[0], -1, -1) && bound(this.position[1], 2, 8)){
			
			return true;	
		}//end if
		else if(!move && bound(this.position[0], -2, -1) && bound(this.position[1], 1, 8)){

			return true;
		}//end else if
		return false;
	}//end moveUleft
	public boolean moveUright(boolean move){
	
		if(move && bound(this.position[0], 1, 8) && bound(this.position[1], 2, 8)){

			return true;
		}//end if
		else if(!move && bound(this.position[0], 2, 8) && bound(this.position[1], 1, 8)){

			return true;
		}//end else if
		return false;
	}//end moveUright	
	public boolean moveDleft(boolean move){

		if(move && bound(this.position[0], -1, -1) && bound(this.position[1], -2, -1)){
			return true;
		}//end if
		else if(!move && bound(this.position[0], -2, -1) && bound(this.position[1], -1, -1)){
			return true;
		}//end else if
		return false;
	}//end moveDleft
	public boolean moveDright(boolean move){
		if(move && bound(this.position[0], 1, 8) && bound(this.position[1], -2, -1)){
			return true;
		}//end if
		else if(!move && bound(this.position[0], 2, 8) && bound(this.position[1], -1, -1)){
			return true;
		}//end else if
		return false;

	}//end moveDright



}//end Knight class
