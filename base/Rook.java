import java.util.*;

class Rook extends Piece{


	public Rook(){
	}//end constructor

	public void moveX(boolean move, int dist){

		if(move && bound(this.position[0], dist, 8)){

			this.position[0] += dist;

		}//end if
		else if(!move && bound(this.position[0], -dist, -1)){

			this.position[0] -= dist;

		}//end else if

	}//end moveX
	public void moveY(boolean move, int dist){

		if(move && bound(this.position[1], dist, 8)){

			this.position[1] += dist;

		}//end if
		else if(!move && bound(this.position[1], -dist, -1)){

			this.position[1] -= dist;

		}//end else if

	}//end moveY


}//end Rook class
