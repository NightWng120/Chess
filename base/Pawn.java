


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
	

	public boolean moveChoose(int[] next, boolean move){
		
		if(move){
	
			return moveX(next);
		}//end if
		if(this.start){
				
			if((next[1] - this.position[1]) == 1 || (next[1] - this.position[1]) == 2){
				setPos(next);	
				return true;
			}//end if
			else if((next[1] - this.position[1]) < 1 || (next[1] - this.position[1]) > 2){

				return false;
			}//end else if
			
		}//end if


		return false;
	}//end moveChoose

	
	public boolean moveX(int[] next){
		
		
		if(slope(next) == 1 && (next[0] - this.position[0]) == 1 && (next[1] - this.position[1]) == 1){
			setPos(next);
			return true;
		}//end if		
		return false;

	}//end moveX
	
}//end Pawn class











