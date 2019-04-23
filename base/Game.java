import java.util.*;



class Game{






	public static void main(String[] args){


		new Game();
	}//end main

	public Game(){

		menuGame();
	}//end constructor

	public menuGame(){

		Random random = new Random();
		int rand;
		Scanner input = new Scanner(System.in);
		String userin;
		boolean loop = true;
		boolean loop2 = true;
		boolean p1, p2;
		
		while(loop){

			rand = random.nextInt(2);
			System.out.println("|-------------------------|");
			System.out.println("|   Welcome to GameBro's  |");
			System.out.println("|          Chess!         |");
			System.out.println("|-------------------------|");
			System.out.println("| Which Player are you?   |");
			System.out.println("|-------------------------|");
			System.out.println("| 1) Player 1             |");
			System.out.println("| 2) Player 2             |");
			System.out.println("|-------------------------|");
			System.out.printf("\n\n");
			System.out.printf(": ");
			userin = input.nextLine();
			if(userin.equals("1"){
				System.out.println("|-------------------------|");
				System.out.println("| What color would you    |");
				System.out.println("| like to be?             |");
				System.out.println("|-------------------------|");
				System.out.println("| 1) White                |");
				System.out.println("| 2) Black                |");
				System.out.println("| 3) Random               |");
				System.out.println("|-------------------------|");
				System.out.printf("\n\n");
				System.out.printf(": ");
				userin = input.nextLine();
				if(userin.equals("1")){

					System.out.println("Your color is White");
					System.out.printf("\n\n");
					player1.setColor(true);
					player2.setColor(false);
					while(loop2){
						p1 = player1.menuPlayer(player2);
						p2 = player2.menuPlayer(player1);
						if(p1){
							
							System.out.println("Player 1 Wins!!");
						}//end if

					}//end whlie loop
					continue;
				}//end if
				else if(userin.equals("2")){

					System.out.println("Your color is Black");
					System.out.printf("\n\n");
					player1.setColor(false);
					player2.setColor(true);
					continue;
				}//end else if
				else if(userin.equals("3")){

					if(rand){
						
						System.out.println("Your color is White");
						System.out.printf("\n\n");
						player1.setColor(true);
						player2.setColor(false);
					}//end if
					else if(!rand){

						System.out.println("Your color is black");
						System.out.printf("\n\n");	
						player1.setColor(false);
						player2.setColr(true); 
					}//end else if
					
				}//end else if
			}//end if


		}//end while loop
	}//end menuGame












}//end Game class
