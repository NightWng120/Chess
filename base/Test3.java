import java.util.*;

class Test3{


	private int[] position;
	public static void main(String[] args){
		new Test3();

	}//end main
	public Test3(){
		
		position = new int[2];
		position[0] = 1;
		position[1] = 4;
			
		System.out.println(this.position[0] + this.position[1]);
	}//end Test3
	public int[] getPos(){
		
		return this.position;
	}//end getPos


}//end Test3 class
