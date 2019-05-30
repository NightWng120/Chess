import java.util.*;

class Test{


	public static void main(String[] args){
		int[] number = new int[2];
		Scanner input = new Scanner(System.in);	
		String userin;
		boolean loop = true;
		while(loop){
			System.out.println("Enter 2 space seperated digits");
			try{
				userin = input.nextLine();
				number[0] = Integer.parseInt("" + userin.charAt(0));
				number[1] = Integer.parseInt("" + userin.charAt(2));
				System.out.println("Your Numbers Are " + number[0] + " " + "And " + number[1]);
				userin = input.nextLine();
				if(userin == "stop"){
					loop = false;
				}//end if	
			}//end try
			catch(NumberFormatException | StringIndexOutOfBoundsException ex){

				System.out.println("***INVALID INPUT***");
				continue;
			}//end catch
				
		}//end while loop

	}//end main


}//end class
