import java.util.*;
public abstract class Player{

	protected Rook rook;
	protected Knight knight;
	
/* ***NOTE***
	You can make the array of piece positions by
	using a 2d array and getPos() methods.

	For Instance:

	int[][] array = {this.rook.getPos(), this.knight.getPos(), this.queen.getPos(), etc};
	
*/
	public Player(boolean color){
		this.rook = new Rook();
		this.knight = new Knight();
		this.rook.setColor(color);
		this.knight.setColor(color);
	}//end constructor
		
	public boolean MoveCheck(int[] pos, int[] next){
		
		if(Arrays.equals(pos, this.knight.getPos())){
			
			if(!Arrays.equals(next, this.rook.getPos()) && this.knight.MoveChoose(next)){
				this.knight.setPos(next);
				return true;

			}//end if
			else{
				return false;
			}//end else
			
		}//end if
		else if(Arrays.equals(pos, this.rook.getPos())){

			if(!Arrays.equals(next, this.knight.getPos()) && this.rook.MoveChoose(next)){
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
