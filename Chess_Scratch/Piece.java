public abstract class Piece{

	protected boolean color; //This is the color of the piece where 'true' is white and 'false' is black
	protected int[] position; //This is the position of the piece on the chess board
	protected String name;
	
	public Piece(){
		position = new int[2];
		position[0] = 0;
		position[1] = 0;

	}//end constructor		
	public void setPos(int[] pos){
		this.position = pos;
	}//end setPos 
	public int[] getPos(){

		return this.position;
	}//end getPos
	public int getPosX(){
		return this.position[0];
	}//end getPosX
	public int getPosY(){
		return this.position[1];
	}//end getPosY
	public void setColor(boolean colour){
		color = colour;
	}//end setColor

	public boolean getColor(){
		return color;
	}//end getColor
	public String getName(){
		return this.name;

	}//end getName

	
	//This method determines and returns the slope of the current position and next move
	public double slope(int[] pos, int[] next){
		try{
			double slope;
			
			slope = (pos[1] - next[1]) / (pos[0] - next[0]);
			return slope;

		}//end try
		catch(ArithmeticException ex){
			return 100;
		}//end catch

		/*Using try catch because a vertical slope throws an ArtithmeticException, and we can use this to
			show that a certain slope is vertical with the catch statement*/	

	}//end slope

	//The bound method determines whether or not the piece is on the board
	public boolean bound(int[] arr){
		if(arr[0] > 7 || arr[0] < 0 || arr[1] > 7 || arr[1] < 0){
			return false;
		}//end if
		else{
			return true;
		}//end else
	}//end bound
}//end Piece abstract class
