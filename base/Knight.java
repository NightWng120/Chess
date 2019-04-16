import java.util.*;

class Knight extends Piece{


	public Knight(){
		
		this.name = "k";		

	}//end constructor

	public void moveUleft(boolean move){
		if(move && bound(this.position[0], -1, -1) && bound(this.position[1], 2, 8)){
			
			this.position[0] -= 1;
			this.position[1] += 2;
	
		}//end if
		else if(!move && bound(this.position[0], -2, -1) && bound(this.position[1], 1, 8)){

			this.position[0] -= 2;
			this.position[1] += 1;

		}//end else if
	}//end moveUleft
	public void moveUright(boolean move){
	
		if(move && bound(this.position[0], 2, 8) && bound(this.position[1], 1, 8)){

			this.position[0] += 1;
			this.position[1] += 2;

		}//end if
		else if(!move && bound(this.position[0], 1, 8) && bound(this.position[1], 2, 8)){

			this.position[0] += 2;
			this.position[1] += 1;

		}//end else if

	}//end moveUright
	public void moveDleft(boolean move){

		if(move && bound(this.position[0], -1, -1) && bound(this.position[1], -2, -1)){
			this.position[0] -= 1;
			this.position[1] -= 2;
		}//end if
		else if(!move && bound(this.position[0], -2, -1) && bound(this.position[1], -1, -1)){
			this.position[0] -= 2;
			this.position[1] -= 1;
		}//end else if
	}//end moveDleft
	public void moveDright(boolean move){
		if(move && bound(this.position[0], 1, 8) && bound(this.position[1], -2, -1)){
			this.position[0] += 1;
			this.position[1] -= 2;
		}//end if
		else if(!move && bound(this.position[0], 2, 8) && bound(this.position[1], -1, -1)){
			this.position[0] += 2;
			this.position[1] -= 1;
		}//end else if


	}//end moveDright



}//end Knight class
