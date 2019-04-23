class King extends Piece{

	public King(boolean name){
		if(name){

			this.name = "K";
		}//end if
		else if(!name){

			this.name = "k";
		}//end else if
	}//end constructor
	
	public boolean moveChoose(int[] next){


		if(slope(next) == 0){
				
			if((this.position[0] - next[0]) > 0){

				return moveX(false);
			}//end if
			else if((next[0] - this.position[0]) > 0){

				return moveX(true);

			}//end else if
			return false;
		}//end if
		else if(slope(next) == 3){
			if((this.position[1] - next[1]) > 0){
				
				return moveY(false);

			}//end if
			else if((next[1] - this.position[1]) > 0){

				return moveY(true);
			}//end else if
			return false;
		}//end else if
		else if(slope(next) == 1){
			if((this.position[0] - next[0]) > 0){

				return moveDownX(false);
			}//end if
			else if((next[0] - this.position[0]) > 0){

				return moveUpX(true);
			}//end else if
			return false;
		}//end else if
		else if(slope(next) == -1){
			if((this.position[0] - next[0]) > 0){

				return moveDownX(true);
			}//end if
			else if((next[0] - this.position[0]) > 0){

				return moveUpX(false);
			}//end else if
			return false;
		}//end else if
		return false;
	}//end moveChoose

	public boolean moveUpX(boolean move){
		
		if(move && bound(this.position[0], 1,  8) && bound(this.position[1], 1,  8)){
			return true;
		}//end if
		else if(!move && bound(this.position[0], -1, -1) && bound(this.position[1], 1, 8)){
			return true;

		}//end else
		return false;
	}//end moveUpX
	public boolean moveY(boolean move){

		if(move && bound(this.position[1], 1, 8)){
			return true;
		}//end if
		else if(!move && bound(this.position[1], -1, -1)){
			return true;
		}//end else
		return false;
	}//end moveY
	
	public boolean moveX(boolean move){

		if(move && bound(this.position[0], 1, 8)){
			return true;
		}//end if
		else if(!move && bound(this.position[0], -1, -1)){
			return true;
		}//end else if
		return false;
	}//moveX
	public boolean moveDownX(boolean move){

		if(move && bound(this.position[0],1,8) && bound(this.position[1], -1, -1)){
			return true;
		}//end if
		else if(!move && bound(this.position[0], -1, -1) && bound(this.position[1], 1, 8)){
			return true;
		}//end else
		return false;
	}//end moveDownX





}//end King class
