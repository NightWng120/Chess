import java.util.*;
public abstract class Player{
	
	protected Pawn pawn;
	protected Rook rook;
	protected Knight knight;
	protected boolean color;
	protected Vector<int[]> vecpos;
/* ***NOTE***
	You can make the array of piece positions by
	using a 2d array and getPos() methods.

	For Instance:

	int[][] array = {this.rook.getPos(), this.knight.getPos(), this.queen.getPos(), etc};
	
*/
	public Player(boolean color){
		this.vecpos = new Vector<int[]>();
		this.color = color;
		this.rook = new Rook(this.color);
		this.knight = new Knight(this.color);
		this.pawn = new Pawn(this.color);
	}//end constructor
		
	public <J extends Player> boolean MoveCheck(J player, int[] pos, int[] next, boolean take){
		int[] arK = this.knight.getPos();
		int[] arR = this.rook.getPos();
		int[] arP = this.pawn.getPos();
		
		if(Arrays.equals(pos, arK)){
			
			if(!Arrays.equals(next, arR) && !Arrays.equals(next, arP) && this.knight.MoveChoose(next)){//If statement  checks if arrays are the same and if the inputted next move is valid
						
				if(collision(player,arK,next)){
					
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

			if(!Arrays.equals(next, arK) && !Arrays.equals(next, arR) && this.pawn.MoveChoose(next, take)){

				this.pawn.setPos(next);
				return true;

			}//end if
			else{

				return false;
			}//end else


		}//end else if

		return false;
	}//end MoveCheck
	
	public <J extends Player> boolean collision(J player, int[] pos, int[] next){

		boolean state = true;
		if(Arrays.equals(pos, this.rook.getPos())){
			



			if(this.rook.slope(this.knight.getpos()) == this.rook.slope(next)){
				if(this.rook.dist(this.knight.getPos()) < this.rook.dist(next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.rook.slope(this.pawn.getpos()) == this.rook.slope(next)){
				if(this.rook.dist(this.pawn.getPos()) < this.rook.dist(next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.rook.slope(player.knight.getpos()) == this.rook.slope(next)){
				if(this.rook.dist(player.knight.getPos()) < this.rook.dist(next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.rook.slope(player.rook.getpos()) == this.rook.slope(next)){
			
				if(this.rook.dist(player.rook.getPos()) < this.rook.dist(next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.rook.slope(player.pawn.getPos()) == this.rook.slope(next)){
				if(this.rook.dist(player.pawn.getPos()) < this.rook.dist(next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

		}//end if


		else if(Arrays.equals(pos, this.knight.getPos())){

			state = true;



		}//end if


		else if(Arrays.equals(pos, this.pawn.getPos())){



			if(this.pawn.slope(this.knight.getpos()) == this.pawn.slope(next)){
				if(this.pawn.dist(this.knight.getPos()) < this.pawn.dist(next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.pawn.slope(this.rook.getpos()) == this.pawn.slope(next)){
				if(this.pawn.dist(this.rook.getPos()) < this.pawn.dist(next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.pawn.slope(player.knight.getpos()) == this.pawn.slope(next)){
				if(this.pawn.dist(player.knight.getPos()) < this.pawn.dist(next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.pawn.slope(player.knight.getpos()) == this.pawn.slope(next)){
			
				if(this.pawn.dist(player.pawn.getPos()) < this.pawn.dist(next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.pawn.slope(player.pawn.getPos()) == this.pawn.slope(next)){
				if(this.pawn.dist(player.knight.getPos()) < this.pawn.dist(next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if


		}//end if
		

		return state;
	}//end Collision


}//end Player abstract class
