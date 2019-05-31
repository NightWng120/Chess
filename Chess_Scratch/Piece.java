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
		this.position = pos.clone();
	}//end setPos 
	public int[] getPos(){

		return this.position.clone();
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
			
			slope = ((double)next[1] - (double)pos[1]) / ((double)next[0] - (double)pos[0]);
			
			if(slope == Double.POSITIVE_INFINITY || slope == Double.NEGATIVE_INFINITY) {
				
				slope = 100;
				
			}//end if
			
			
			return slope;

		}//end try
		catch(ArithmeticException ex){
			
			System.out.println("Number Error");
			return 0;
		}//end catch

		
		
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
