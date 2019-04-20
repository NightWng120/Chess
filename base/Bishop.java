import java.util.*;

class Bishop extends Piece{


	public Bishop(boolean name){

		if(name){
			this.name = "B";

		}//end 
		else if(!name){

			this.name = "b";
		}//end else if


	}//end constructor
	public boolean moveChoose(int[] next){

		if(slope(next) == 1){

			if((this.position[1] - next[1]) > 0){

				if((this.position[0] - next[0]) > 0){
					
					return moveDown(false, (this.position[0] - next[0]));
				}//end if
				else if((next[0] - this.position[0]) > 0){
		
					return moveDown(true, (next[0] - this.position[0]));
				}//end else if
			}//end if
			else if((next[1] - this.position[1]) > 0){
				
				if((this.position[0] - next[0]) > 0){

					return moveUp(false, (this.position[0] - next[0]));
				}//end if
				else if((next[0] - this.position[0]) > 0){
					

					return moveUp(true, (next[0] - this.position[0]));

				}//end else if


			}//end else if
		

		}//end if


	}//end moveChoose
	public boolean moveUp(boolean move, int dist){

		if(move && bound(this.position[0], dist, 8) && bound(this.position[1], dist, 8)){

			this.position[0] += dist;
			this.position[1] += dist;
			return true;
		}//end if
		else if(!move && bound(this.position[0], -dist, -1) && bound(this.position[1], dist, 8)){

			this.position[0] -= dist;
			this.position[1] += dist;
			return true;
		}//end else if
		return false;
	}//end moveUp
	public void moveDown(boolean move, int dist){

		if(move && bound(this.position[0], dist, 8) && bound(this.position[1], -dist, -1)){

			this.position[0] += dist;
			this.position[1] -= dist;
			return true;
		}//end if
		else if(!move && bound(this.position[0], -dist, -1) && bound(this.position[1], -dist, -1)){

			this.position[0] -= dist;
			this.position[1] -= dist;
			return true;
		}//end else if

		return false;
	}//end moveDown

}//end Bishop class 
