
public class Bishop extends Piece {
	
	public Bishop(boolean color){
		
		this.color = color;	
	
		if(color){
			name = "B";			
		}//end if	
		else if(!color){
			name = "b";
		}//end else if		
		
		//Determines name base on what color piece is
		
	}//end constructor
	public boolean MoveChoose(int[] next){
		
		double slope = slope(position, next);
		if(bound(next)){
			if(slope == 1 || slope == -1){
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

}
