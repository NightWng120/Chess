import java.util.*;


class Pawn extends Piece{

	boolean start;
	public Pawn(boolean name){
		this.start = true;
		if(name){

			this.name = "P";
		}//end if
		else if(!name){

			this.name = "p";
		}//end else if
	}//end Pawn
	

	public boolean moveChoose(int[] next){

		if(this.start){
			if((next[1] - this.position[1]) <= 0){

				return false;
			}//end if
			if((next[1] - this.position[1]) == 1 || (next[1] - this.position[1]) == 2){
				setPos(next);
				return true;
			}//end if
			
			
		}//end if

	}//end moveChoose

	
	public void moveX(int[] next){
		
		boolean move;
		if(slope(next) == 1 && (next[0] - this.position[0]) == 1 && (next[1] - this.position[1]) == 1){

			setPos(next);
		}//end if		


	}//end moveX
	
}//end Pawn clas











