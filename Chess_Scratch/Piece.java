import java.util.*;

public abstract class Piece{

	protected boolean color; //This is the color of the piece where 'true' is white and 'false' is black
	protected int[] position; //This is the position of the piece on the chess board
	protected String name;
	
	public Piece(){
		position = new int[2];
		position[0] = 0;
		position[1] = 0;

	}//end constructor

	public abstract boolean MoveChoose(int[] next);
		
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
	public double dist(int[] pos, int[] next){

		double dist = Math.sqrt(((next[1] - pos[1]) * (next[1] - pos[1])) + ((next[0] - pos[0]) * (next[0] - pos[0])));
		
		return dist;


	}//end dist

	public Vector<int[]> redSpot(){

		int[] ar[][] = {{{0,0},{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0}},{{0,1},{1,1},{2,1},{3,1},{4,1},{5,1},{6,1},{7,1}},{{0,2},{1,2},{2,2},{3,2},{4,2},{5,2},{6,2},{7,2}}
		,{{0,3},{1,3},{2,3},{3,3},{4,3},{5,3},{6,3},{7,3}},{{0,4},{1,4},{2,4},{3,4},{4,4},{5,4},{6,4},{7,4}},{{0,5},{1,5},{2,5},{3,5},{4,5},{5,5},{6,5},{7,5}}
		,{{0,6},{1,6},{2,6},{3,6},{4,6},{5,6},{6,6},{7,6}},{{0,7},{1,7},{2,7},{3,7},{4,7},{5,7},{6,7},{7,7}}};
		
		Vector<int[]> vecred = new Vector<int[]>();
		int j, i;
		
		for(i = 0; i < 8; i++){

			for(j = 0; j < 8; j++){
				
				if(MoveChoose(ar[i][j])){
					
					vecred.add(ar[i][j]);
				
				}//end if


			}//end for loop
			

		}//end for loop
		
		return vecred;

	}//end redSpot

	

}//end Piece abstract class
