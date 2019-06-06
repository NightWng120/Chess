import java.util.*;

class Game{	


	public static void main(String[] args){

		new Game();


	}//end main

	public Game(){
		Player1 player1;
		Player2 player2;
		Scanner input = new Scanner(System.in);
		String userin;
		boolean p1 = true, p2 = true, loop = true;
		while(loop){
			
        		System.out.println("What Player are you?: (1/2)");
        		userin = input.nextLine();
        		if(userin.equals("1")){
					
					System.out.println("What color do you want to be?: (White/Black)");
					userin = input.nextLine();
					
					if(userin.equals("white") || userin.equals("White")){
	                	player1 = new Player1(true);
						player2 = new Player2(false);
						while(p1 && p2){
							p1 = player1.move(player2);
							p2 = player2.move(player1);
						}//end while loop
	        		}//end if
	        		else if(userin.equals("black") || userin.equals("Black")){
	                	player1 = new Player1(false);
						player2 = new Player2(true);
						while(p1 && p2){
							
							p2 = player2.move(player1);
							p1 = player1.move(player2);
	
						}//end while loop
	        		}//end else if
	        		else if(userin.equals("quit")){
	                		loop = false;
	        		}//end else if
	        		else{
	                		System.out.println("***Invalid Input***");
	                		continue;
	        		}//end else

        		}//end if
        		else if(userin.equals("2")){
					
        			System.out.println("What color do you want to be?: (White/Black)");
					userin = input.nextLine();

					if(userin.equals("white") || userin.equals("White")){
	                	player2 = new Player2(true);
						player1 = new Player1(false);
						while(p1 && p2){
							p2 = player2.move(player1);
							p1 = player1.move(player2);
						}//end while loop
	        		}//end if
	        		else if(userin.equals("black") || userin.equals("Black")){
	                			player2 = new Player2(false);
						player1 = new Player1(true);
						while(p1 && p2){
							p1 = player1.move(player2);
							p2 = player2.move(player1);
						}//end while loop
	        		}//end else if
	        		else if(userin.equals("quit")){
	                		loop = false;
	        		}//end else if
	        		else{
	                		System.out.println("***Invalid Input***");
	                		continue;
	        		}//end else

        		}//end else if
        		else if(userin.equals("quit")){

        			loop = false;
        		}//end else if
			
		}//end while loop
	}//end constructor

}//end Game class
