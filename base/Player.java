import java.util.*;


public abstract class Player{



	protected Queen queen;
	protected King king;
	protected Bishop bishopW;
	protected Bishop bishopB;
	protected Rook rookW;
	protected Rook rookB;
	protected Knight knightB;
	protected Knight knightW;
	protected Vector<Pawn> vecPawn;
	protected boolean color;
	protected int points;

	public Player(boolean color){
		
		int i;
		
		this.color = color;
		this.points = 0;
		this.queen.setColor(color);
		this.king.setColor(color);
		this.bishopW.setColor(color);
		this.bishopB.setColor(color);
		this.rookW.setColor(color);
		this.rookB.setColor(color);
		this.knightB.setColor(color);
		this.knightW.setColor(color);

		for(i = 0; i < 8; i++){

			this.vecPawn.add(new Pawn);

		}//end for loop



	}//end constructor
	
	public void movePiece(int[] pos, int[] next){


		


	}//end movePiece

}//end Player class
