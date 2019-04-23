

class Rook extends Piece{


	public Rook(boolean name){

		if(name){

			this.name = "R";
		}//end if
		else if(!name){

			this.name = "r";
		}//end else if
	}//end constructor

	public boolean moveChoose(int[] next){

		if(slope(next) == 0){

			if((this.position[0] - next[0]) > 0){
				
				return moveX(false, (this.position[0] - next[0]));
			}//end if
			else if((next[0] - this.position[0]) > 0){


				return moveX(true, (next[0] - this.position[0]));
			}//end else if
		}//end if
		else if(slope(next) == 3){

			if((this.position[1] - next[1]) > 0){

				return moveY(false, (this.position[1] - next[1]));

			}//end if
			else if((next[1] - this.position[1]) > 0){

				return moveY(true, (this.position[1] - next[1]));
			}//end else if
		}//end else if
			return false;
		
	}//end moveChoose

	public boolean moveX(boolean move, int dist){

		if(move && bound(this.position[0], dist, 8)){

			return true;
		}//end if
		else if(!move && bound(this.position[0], -dist, -1)){

			return true;
		}//end else if

			return false;

	}//end moveX
	public boolean moveY(boolean move, int dist){

		if(move && bound(this.position[1], dist, 8)){

			return true;
		}//end if
		else if(!move && bound(this.position[1], -dist, -1)){

			return true;
		}//end else if

			return false;
	}//end moveY


}//end Rook class
