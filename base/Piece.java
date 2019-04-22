public abstract class Piece{

	
	protected int position[];
	protected boolean color;
	protected String name;	
	protected boolean status;
	public Piece(){
			
		this.position = new int[2];
		this.position[0] = 0;
		this.position[1] = 0;
		this.status = true;
	}//end constructor
	public int[] getPos(){

		return this.position;
		
	}//end getPos
	public void setPos(int[] position){
		this.position[0] = position[0];
		this.position[1] = position[1];
	}//end setPos
	public int getPosX(){
		return this.position[0];
	}//end getPosX
	public int getPosY(){

		return this.position[1];
	}//end getPosY
	public boolean getColor(){
		return this.color;
	}//end getColor
	public void setColor(boolean color){
		this.color = color;
	}//end setColor
	public void setStatus(boolean status){
		
		this.status = false;
	}//end setStatus
	public boolean getStatus(){

		return this.status;

	}//end getStatus
	public double slope(int next[]){
		
		double slope;
		try{
			slope = ((double)next[1] - (double)this.position[1])/((double)next[0] - (double)this.position[0]);
			
			return slope;
		}//end try
		catch(ArithmeticException ex){

			return 3;
		}//end catch

	}//end slope
	
	public double dist(int next[]){

		double dist;

		dist = Math.sqrt(((double)next[1] - (double)this.position[1])/((double)next[0] - (double)this.position[1]));

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



















