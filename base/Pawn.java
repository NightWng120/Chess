import java.util.*;


class Pawn extends Piece{

	boolean start;
	public Pawn(){
		this.start = true;
	}//end Pawn

	public void move(boolean move){
		
		if(start){
			if(move && bound(this.position[1], 2, 8)){
                		this.position[1] += 2;
			}//end if
			else if(!move && bound(this.position[1], 1, 8)){
				this.position[1] += 1;
			}//end else if
			start = false;
		}//end if
		else if(bound(this.position[1], 1, 8)){
			this.position[1] += 1;
		}//end else if
	}//end move
	
	public void moveX(boolean move){

		if(move && bound(this.position[0], 1, 8) && bound(this.position[1], 1, 8)){
			this.position[0] += 1;
			this.position[1] += 1;	
		}//end if		
		else if(!move && bound(this.position[0], -1, -1) && bound(this.position[1], 1, 8)){
			this.position[0] -= 1;
			this.position[1] += 1;
		}//end else if	

	}//end moveX
	
}//end Pawn clas











