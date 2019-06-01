class Rook extends Piece{


	public static void main(String[] args){
		new Rook();
	}//end main
	public Rook(){
		if(this.color){
			name = "R";			
		}//end if	
		else if(!this.color){
			name = "r";
		}//end else if		
		
		//Determines name base on what color piece is
		
	}//end constructor
	public boolean MoveChoose(int[] next){
		
		double slope = slope(position, next);
		if(bound(next)){
			if(slope == 0 || slope == 100){
				return true;
			}//end if
			else{
				return false;
			}// end else
		}//end if
		else{
			return false;
		}//end else

		/*if statement determines if the piece is on the board when move is made and then determines
		whether or not the move is valid for the piece*/

	}//end MoveChoose

}//end Rook class
