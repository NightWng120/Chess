import java.util.*;

class Test2{



	public static void main(String[] args){

		new Test2();

	}//end main
	public Test2(){
		
		
		int x = 12;
		int y = 0;
		boolean j;
		Test3 test = new Test3();
		int[] ar = test.getPos();
		System.out.println(ar[0]+ ar[1]);
		j = DivdeZero(x,y);
		System.out.println(j);

	}//end constructor
	public boolean DivdeZero(int x, int y){

		int quo = 0;
	
		try{
			quo = x/y;
				
			return false;
		}//end try

		catch(ArithmeticException ex){
			return true;
			
		}//end catch

	}//end DivideZero



}//end class
