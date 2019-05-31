class Knight extends Piece{

	

	public Knight(){
		if(this.color){
			this.name = "N";
		}//end if
		else if(!this.color){
			this.name = "n";
		}//end else if

	}//end constructor

	//Method determines whether a chosen move position is valid or not using slope and distance formulas
	public boolean MoveChoose(int[] next){	
		double dist = dist(this.position, next);
		double slope = slope(this.position, next);
		if(slope == .5 || slope == -.5 || slope == 2 || slope == -2){
			if(dist > 3.5 && dist < 3.7){
				return true;
			}//end if
			else{
				return false;
			}//end else

		}//end if
		else{
			return false;
		}//end else

	}//end MoveChoose



}//end Knight class
