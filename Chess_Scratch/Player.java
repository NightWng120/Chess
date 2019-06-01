import java.util.*;
public abstract class Player{

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
		
	}//end constructor
		
	public boolean MoveCheck(int[] pos, int[] next){
		int[] arK = this.knight.getPos();
		int[] arR = this.rook.getPos();
		if(Arrays.equals(pos, arK)){
			
			if(!Arrays.equals(next, arR) && this.knight.MoveChoose(next)){//If statement  checks if arrays are the same and if the inputted next move is valid
				this.knight.setPos(next);
				return true;

			}//end if
			else{
				return false;
			}//end else
			
		}//end if
		else if(Arrays.equals(pos, arR)){

			if(!Arrays.equals(next, arK) && this.rook.MoveChoose(next)){//If statement  checks if arrays are the same and if the inputted next move is valid
				this.rook.setPos(next);
				return true;				

			}//end if
			else{
				return false;
			}//end else
		}//end else if
		

		return false;
	}//end MoveCheck



}//end Player abstract class
