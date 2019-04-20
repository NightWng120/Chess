class King extends Piece{

	public King(boolean name){
		if(name){

			this.name = "K";
		}//end if
		else if(!name){

			this.name = "k";
		}//end else if
	}//end constructor
	
	public boolean moveChoose(int[] next){


		if(slope(next) == 0 || slope(next) == 3){
			
			
		}//end if
	}//end moveChoose

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
