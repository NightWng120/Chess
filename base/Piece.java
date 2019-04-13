class abstract Piece{

	
	protected int position[];
	protected boolean color;

	public Piece(){
			
		this.position[] = {0,0};
		

	}//end constructor
	public int getPos(){

		return this.position;
		
	}//end getPos
	public void setPos(int position[]){
		this.position[0] = position[0];
		this.position[1] = position[1];
	}//end setPos
	public boolean getColor(){
		return this.color;
	}//end getColor
	public void setColor(boolean color){
		this.color = color;
	}//end setColor
}//end Piece class
