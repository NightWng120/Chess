import java.util.*;
import java.io.*;


class Game{






	public static void main(String[] args){


		new Game();
	}//end main

	public Game(){
		
		menuGame();
	}//end constructor

	public void menuGame(){

		Random random = new Random();
		int rand;
		
		Scanner input = new Scanner(System.in);
		String userin;
		boolean loop = true;
		boolean loop2 = true;
		boolean p1, p2;
		
		try{
			File file = new File("Fire works.txt");	
			Scanner infile = new Scanner(file);	
			int i;
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
				if(userin.equals("1")){
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
						Player1 player1 = new Player1(true);
						Player2 player2 = new Player2(false);
						while(loop2){
							p1 = player1.menuPlayer(player2);
							p2 = player2.menuPlayer(player1);
							if(p1){
								for(i = 0; i < 28; i++){								
									
									if(i == 17){
										System.out.println("Player 1 Wins!!");
										infile.nextLine();
									}//end if
									System.out.println(infile.nextLine());
                
								}//end for loop
								loop2 = false;
							}//end if
							else if(p2){
                
								for(i = 0; i < 28; i++){
                
									if(i == 17){
                
										System.out.println("Player 2 Wins!!");
										infile.nextLine();
									}//end if
									System.out.println(infile.nextLine());
								}//end for loop
								loop2 = false;
							}//end else if
                
						}//end while loop
						continue;
					}//end if
					else if(userin.equals("2")){
                
						System.out.println("Your color is Black");
						System.out.printf("\n\n");
						Player1 player1= new Player1(false);
						Player2 player2= new Player2(true);
						while(loop2){
							
							p2 = player2.menuPlayer(player1);
							p1 = player1.menuPlayer(player2);
							if(p1){
								for(i = 0; i < 28; i++){								
									
									if(i == 17){
										System.out.println("Player 1 Wins!!");
										infile.nextLine();
									}//end if
									System.out.println(infile.nextLine());
                
								}//end for loop
								loop2 = false;
							}//end if
							else if(p2){
                
								for(i = 0; i < 28; i++){
                
									if(i == 17){
                
										System.out.println("Player 2 Wins!!");
										infile.nextLine();
									}//end if
									System.out.println(infile.nextLine());
								}//end for loop
								loop2 = false;
							}//end else if
								
						}//end while loop
						continue;
					}//end else if
					else if(userin.equals("3")){
                
						if(rand == 1){
							
							System.out.println("Your color is White");
							System.out.printf("\n\n");
							Player1 player1 = new Player1(true);
							Player2 player2 = new Player2(false);
							
							while(loop2){
								p1 = player1.menuPlayer(player2);
								p2 = player2.menuPlayer(player1);
								if(p1){
									for(i = 0; i < 28; i++){								
										
										if(i == 17){
											System.out.println("Player 1 Wins!!");
											infile.nextLine();
										}//end if
										System.out.println(infile.nextLine());
	                
									}//end for loop
									loop2 = false;
								}//end if
								else if(p2){
	                
									for(i = 0; i < 28; i++){
	                
										if(i == 17){
	                
											System.out.println("Player 2 Wins!!");
											infile.nextLine();
										}//end if
										System.out.println(infile.nextLine());
									}//end for loop
									loop2 = false;
								}//end else if
	                
							}//end while loop
						}//end if
						else if(rand == 0){
                
							System.out.println("Your color is black");
							System.out.printf("\n\n");	
							
							Player2 player2 = new Player2(true); 
							Player1 player1 = new Player1(false);
							
							while(loop2){
								p1 = player1.menuPlayer(player2);
								p2 = player2.menuPlayer(player1);
								if(p1){
									for(i = 0; i < 28; i++){								
										
										if(i == 17){
											System.out.println("Player 1 Wins!!");
											infile.nextLine();
										}//end if
										System.out.println(infile.nextLine());
	                
									}//end for loop
									loop2 = false;
								}//end if
								else if(p2){
	                
									for(i = 0; i < 28; i++){
	                
										if(i == 17){
	                
											System.out.println("Player 2 Wins!!");
											infile.nextLine();
										}//end if
										System.out.println(infile.nextLine());
									}//end for loop
									loop2 = false;
								}//end else if
	                
							}//end while loop
						}//end else if
						continue;
					}//end else if
				}//end if
                
                
			}//end while loop
			input.close();
			infile.close();
		}//end try
		catch(FileNotFoundException ex){

			System.out.println("Friendly Error to tell you that the file has not been found");
			System.out.println("\n\n");
		}//end catch
	}//end menuGame












}//end Game class
