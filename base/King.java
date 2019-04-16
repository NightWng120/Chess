class King extends Piece{

	public King(){

		this.name = "K";

	}//end constructor
	
	public void moveUpX(boolean move){
		
		if(move && bound(this.position[0], 1,  8) && bound(this.position[1], 1,  8)){
			this.position[0] += 1;
			this.position[1] += 1;
		}//end if
		else if(!move && bound(this.position[0], -1, -1) && bound(this.position[1], 1, 8)){
			this.position[0] -= 1;
			this.position[1] += 1;

		}//end else
		
	}//end moveUpX
	public void moveY(boolean move){

		if(move && bound(this.position[1], 1, 8)){
			this.position[1] += 1;
		}//end if
		else if(!move && bound(this.position[1], -1, -1)){
			this.position[1] -= 1;

		}//end else

	}//end moveY
	
	public void moveX(boolean move){

		if(move && bound(this.position[0], 1, 8)){
			this.position[0] += 1;
		}//end if
		else if(!move && bound(this.position[0], -1, -1)){
			this.position[0] -= 1;
		}//end else
	}//moveX
	public void moveDownX(boolean move){

		if(move && bound(this.position[0],1,8) && bound(this.position[1], -1, -1)){
			this.position[0] += 1;
			this.position[1] -= 1;
		}//end if
		else if(!move && bound(this.position[0], -1, -1) && bound(this.position[1], 1, 8)){
			this.position[0] -= 1;
			this.position[1] += 1;
		}//end else

	}//end moveDownX





}//end King class