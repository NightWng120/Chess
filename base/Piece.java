public abstract class Piece{

	
	protected int position[];
	protected boolean color;
	protected String name;	

	public Piece(){
			
		this.position = new int[2];
		this.position[0] = 0;
		this.position[1] = 0;
	}//end constructor
	public int[] getPos(){

		return this.position;
		
	}//end getPos
	public void setPos(int[] position){
		this.position[0] = position[0];
		this.position[1] = position[1];
	}//end setPos
	public boolean getColor(){
		return this.color;
	}//end getColor
	public void setColor(boolean color){
		this.color = color;
	}//end setColor
	public double slope(int ar[], int next[]){
		
		double slope;
		slope = ((double)next[1] - (double)ar[1])/((double)next[0] - (double)ar[0]);
		
		return slope;

	}//end slope
	
	public double dist(int ar[], int next[]){

		double dist;

		dist = Math.sqrt(((double)next[1] - (double)ar[1])/((double)next[0] - (double)ar[1]));

		return dist;


	}//end dist
	public boolean bound(int num, int x, int bound){


		if(bound < 0){
			if((num - x) > bound){
				return true;
			}//end if 
			else{
				return false;
			}//end else

		}//end if
		else if(bound > 0){
			if((num + x) < bound){
				return true;
			}//end if
			else{
				return false;
			}//end else

		}//end if
		return false;
	}//end bound
	public String getName(){

		return this.name;

	}//end getName
}//end Piece class



















