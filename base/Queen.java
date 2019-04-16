class Queen extends Piece{

	public Queen(){
		
		this.name = "Q";	
	
	}//end constructor
	

	public void moveChoose(int[] next){

		float slope = slope(this.position, next);
		float dist = dist(this.position, next);


	}//end moveChoose


	public void moveUpX(boolean move, int dist){

		if(move && bound(this.position[0], dist, 8) && bound(this.position[1], dist,  8)){
			this.position[0] += dist;
			this.position[1] += dist; 
		}//end if	
		
		else if(!move && bound(this.position[0], -dist, -1) && bound(this.position[1], dist,  8)) {
			this.position[0] -= dist;
			this.position[1] += dist;
		}//end else	
	}//end moveUpX		

	public void moveY(boolean move, int dist){
		
		if(move && bound(this.position[1], dist, 8)){
			this.position[1] += dist;

		}//end if
		else if(!move && bound(this.position[1], -dist, -1)){
			this.position[1] -= dist;
		}//end if


	}//end moveY
	public void moveX(boolean move, int dist){

		if(move && bound(this.position[0], dist, 8)){
			this.position[0] += dist;
		}//end if
		else if(!move && bound(this.position[0], -dist, -1)){
			this.position[0] -= dist;
		}//end else if

	}//end moveX
	public void moveDownX(boolean move, int dist){


		if(move && bound(this.position[0], 1, 8) && bound(this.position[1], -dist, -1)){
			this.position[0] += dist;
			this.position[1] -= dist;
		}//end if
		else if(!move && bound(this.position[0], -dist, -1) && bound(this.position[1], dist, 8)){

			this.position[0] -= dist;
			this.position[1] += dist;
		}//end else if


	}//end moveDownX

}//end Queen class












