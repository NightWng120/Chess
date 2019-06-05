import java.util.*;
public abstract class Player{
	
	protected Pawn pawn;
	protected Rook rook;
	protected Knight knight;
	protected boolean color;
	
/* ***NOTE***
	You can make the array of piece positions by
	using a 2d array and getPos() methods.

	For Instance:

	int[][] array = {this.rook.getPos(), this.knight.getPos(), this.queen.getPos(), etc};
	
*/
	public Player(boolean color){
		this.color = color;
		this.rook = new Rook(this.color);
		this.knight = new Knight(this.color);
		this.pawn = new Pawn(this.color);
	}//end constructor
		
	public boolean MoveCheck(int[] pos, int[] next){
		int[] arK = this.knight.getPos();
		int[] arR = this.rook.getPos();
		int[] arP = this.pawn.getPos();
		
		if(Arrays.equals(pos, arK)){
			
			if(!Arrays.equals(next, arR) && !Arrays.equals(next, arP) && this.knight.MoveChoose(next)){//If statement  checks if arrays are the same and if the inputted next move is valid
				this.knight.setPos(next);
				return true;

			}//end if
			else{
				return false;
			}//end else
			
		}//end if
		else if(Arrays.equals(pos, arR)){

			if(!Arrays.equals(next, arK) && !Arrays.equals(next, arP) && this.rook.MoveChoose(next)){//If statement  checks if arrays are the same and if the inputted next move is valid
				this.rook.setPos(next);
				return true;				

			}//end if
			else{
				return false;
			}//end else
		}//end else if
		
		else if(Arrays.equals(pos, arP)){

			if(!Arrays.equals(next, arK) && !Arrays.equals(next, arR) && this.pawn.MoveChoose(next, false)){

				this.pawn.setPos(next);
				return true;

			}//end if
			else{

				return false;
			}//end else


		}//end else if

		return false;
	}//end MoveCheck



}//end Player abstract class
