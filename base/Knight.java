import java.util.*;

class Knight extends Piece{


	public Knight(boolean name){
		
		if(name){
			
			this.name = "N";

		}//end if
		else if(!name){

			this.name = "n";
		}//end else if
	}//end constructor

	public void moveUleft(boolean move){
		if(move && bound(this.position[0], -1, -1) && bound(this.position[1], 2, 8)){
			
			return true;	
		}//end if
		else if(!move && bound(this.position[0], -2, -1) && bound(this.position[1], 1, 8)){

			return true;
		}//end else if
		return false;
	}//end moveUleft
	public void moveUright(boolean move){
	
		if(move && bound(this.position[0], 2, 8) && bound(this.position[1], 1, 8)){

			return true;
		}//end if
		else if(!move && bound(this.position[0], 1, 8) && bound(this.position[1], 2, 8)){

			return true;
		}//end else if
		return false;
	}//end moveUright	
	public void moveDleft(boolean move){

		if(move && bound(this.position[0], -1, -1) && bound(this.position[1], -2, -1)){
			return true;
		}//end if
		else if(!move && bound(this.position[0], -2, -1) && bound(this.position[1], -1, -1)){
			return true;
		}//end else if
		return false;
	}//end moveDleft
	public void moveDright(boolean move){
		if(move && bound(this.position[0], 1, 8) && bound(this.position[1], -2, -1)){
			return true;
		}//end if
		else if(!move && bound(this.position[0], 2, 8) && bound(this.position[1], -1, -1)){
			return true;
		}//end else if
		return false;

	}//end moveDright



}//end Knight class
