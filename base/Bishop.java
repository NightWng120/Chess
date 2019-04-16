import java.util.*;

class Bishop extends Piece{


	public Bishop(){
	}//end constructor

	public void moveUp(boolean move, int dist){

		if(move && bound(this.position[0], dist, 8) && bound(this.position[1], dist, 8)){

			this.position[0] += dist;
			this.position[1] += dist;

		}//end if
		else if(!move && bound(this.position[0], -dist, -1) && bound(this.position[1], dist, 8)){

			this.position[0] -= dist;
			this.position[1] += dist;

		}//end else if

	}//end moveUp
	public void moveDown(boolean move, int dist){

		if(move && bound(this.position[0], dist, 8) && bound(this.position[1], -dist, -1)){

			this.position[0] += dist;
			this.position[1] -= dist;

		}//end if
		else if(!move && bound(this.position[0], -dist, -1) && bound(this.position[1], -dist, -1)){

			this.position[0] -= dist;
			this.position[1] -= dist;

		}//end else if


	}//end moveDown

}//end Bishop class 
