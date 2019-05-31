import java.util.*;


class Game{

	public Rook rook;
	public int[] arR;
	public static void main(String[] args){
		new Game();
	}//end main
	
	public Game(){
		this.rook = new Rook();
		this.rook.setColor(false);
		prePosfill(rook);//Function that sets initial position of piece call

		String ar[][] = {{" "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "},
		/*Blank Board Array*/{" "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "}};;
		
		boolean loop = true;
		int[] next = new int[2];		
		
		Scanner input = new Scanner(System.in);
		String userin;
		
		System.out.println("|-------------------------|");
		System.out.println("| Welcome to Piece Mover! |");
		System.out.println("|-------------------------|");
		System.out.println("| Press Enter to Continue |");
		System.out.println("|-------------------------|");
		System.out.printf("\n\n");
		userin = input.nextLine();			
		
		while(loop){
			
			posFill(ar);//Function that sets updated position of piece call
			print(ar);//Board print function

			System.out.println("|-------------------------|");
			System.out.println("| Enter the Coords of your|");			
			System.out.println("| next move               |");			
			System.out.println("|-------------------------|");			
			System.out.printf("\n\n");			
			System.out.printf(": ");
			try{
				userin = input.nextLine();			
				if(userin.equals("quit")){
					loop = false;
					break;
				}//end if
                		/*Statements end program when input is 'quit'*/
        			        
				if(userin.charAt(0) >= 'a' || userin.charAt(0) <= 'h' || userin.charAt(0) >= 'A' || userin.charAt(0) <= 'H'){
				/*If statement determines if inputed letter is valid for board and switch converts letter to integer*/

					switch(userin.charAt(0)){
						
						case 'a':
							next[0] = 0;
							break;

						case 'b':
							next[0] = 1;
							break;

						case 'c':
							next[0] = 2;
							break;

						case 'd':
							next[0] = 3;
							break;

						case 'e':
							next[0] = 4;
							break;

						case 'f':
							next[0] = 5;
							break;

						case 'g':
							next[0] = 6;
							break;

						case 'h':
							next[0] = 7;
							break;

						case 'A':
							next[0] = 0;
							break;

						case 'B':
							next[0] = 1;
							break;

						case 'C':
							next[0] = 2;
							break;

						case 'D':
							next[0] = 3;
							break;

						case 'E':
							next[0] = 4;
							break;

						case 'F':
							next[0] = 5;
							break;

						case 'G':
							next[0] = 6;
							break;

						case 'H':
							next[0] = 7;
							break;





					}//end switch
					next[1] = (Integer.parseInt("" + userin.charAt(1)) - 1);
				}//end if
				else{
					System.out.println("***Invalid Input***");
					continue;

				}//end else
				/*Setting of converted string to 'next' position array*/
			}//end try
			catch(NumberFormatException | StringIndexOutOfBoundsException ex){
				System.out.println("***Invalid Input***");
				continue;
			}//end catch

			if(this.rook.MoveChoose(next)){//If statement call of function that determines validity of inputed next position
				this.rook.setPos(next);
			}//end if
			else if(!this.rook.MoveChoose(next)){
				System.out.println("***Invalid Move***");
				System.out.printf("\n\n\n");

				
				continue;
			}//end else if

		}//end while loop
		
	}//end constructor
	
	public void print(String[][] ar){//Board print function body
		System.out.println(" ---------------------------------");
				System.out.printf("8| %s | %s | %s | %s | %s | %s | %s | %s |\n", ar[0][7], ar[1][7], ar[2][7], ar[3][7], ar[4][7], ar[5][7], ar[6][7], ar[7][7]);
				System.out.println(" |---|---|---|---|---|---|---|---|");
				System.out.printf("7| %s | %s | %s | %s | %s | %s | %s | %s |\n", ar[0][6], ar[1][6], ar[2][6], ar[3][6], ar[4][6], ar[5][6], ar[6][6], ar[7][6]);
				System.out.println(" |---|---|---|---|---|---|---|---|");
				System.out.printf("6| %s | %s | %s | %s | %s | %s | %s | %s |\n", ar[0][5], ar[1][5], ar[2][5], ar[3][5], ar[4][5], ar[5][5], ar[6][5], ar[7][5]);
				System.out.println(" |---|---|---|---|---|---|---|---|");
				System.out.printf("5| %s | %s | %s | %s | %s | %s | %s | %s |\n", ar[0][4], ar[1][4], ar[2][4], ar[3][4], ar[4][4], ar[5][4], ar[6][4], ar[7][4]);
				System.out.println(" |---|---|---|---|---|---|---|---|");
				System.out.printf("4| %s | %s | %s | %s | %s | %s | %s | %s |\n", ar[0][3], ar[1][3],ar[2][3], ar[3][3], ar[4][3], ar[5][3], ar[6][3], ar[7][3]);
				System.out.println(" |---|---|---|---|---|---|---|---|");
				System.out.printf("3| %s | %s | %s | %s | %s | %s | %s | %s |\n", ar[0][2], ar[1][2], ar[2][2], ar[3][2], ar[4][2], ar[5][2], ar[6][2], ar[7][2]);
				System.out.println(" |---|---|---|---|---|---|---|---|");
				System.out.printf("2| %s | %s | %s | %s | %s | %s | %s | %s |\n", ar[0][1], ar[1][1], ar[2][1], ar[3][1], ar[4][1], ar[5][1], ar[6][1], ar[7][1]);
				System.out.println(" |---|---|---|---|---|---|---|---|");
				System.out.printf("1| %s | %s | %s | %s | %s | %s | %s | %s |\n", ar[0][0], ar[1][0], ar[2][0], ar[3][0], ar[4][0], ar[5][0], ar[6][0], ar[7][0]);
				System.out.println(" ---------------------------------");
				System.out.println("   A   B   C   D   E   F   G   H  ");
				System.out.printf("\n\n");
				/*Board 2D array*/
	}//end print
	
	public void prePosfill(Rook rook){//Function body for function that sets intial position of piece and previous position variable
		
		int[] ar[][] = {{{0,0},{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0}},{{0,1},{1,1},{2,1},{3,1},{4,1},{5,1},{6,1},{7,1}},{{0,2},{1,2},{2,2},{3,2},{4,2},{5,2},{6,2},{7,2}}
		,{{0,3},{1,3},{2,3},{3,3},{4,3},{5,3},{6,3},{7,3}},{{0,4},{1,4},{2,4},{3,4},{4,4},{5,4},{6,4},{7,4}},{{0,5},{1,5},{2,5},{3,5},{4,5},{5,5},{6,5},{7,5}}
		,{{0,6},{1,6},{2,6},{3,6},{4,6},{5,6},{6,6},{7,6}},{{0,7},{1,7},{2,7},{3,7},{4,7},{5,7},{6,7},{7,7}}};
		/*Array of position arrays for every position on the board*/		
	
		this.rook.setPos(ar[0][7]);//Piece position setting
		this.arR = this.rook.getPos();//Previous position assignment	
	}//end prePosfill
	public void posFill(String[][] arr){/*Function body for function that determines whether piece has moved or not; 
							updates position variable and board array accordingly*/

		if(this.arR[0] != this.rook.getPosX() || this.arR[1] != this.rook.getPosY()){//If checks if position has changed
			arr[this.arR[0]][this.arR[1]] = " ";
			arr[this.rook.getPosX()][this.rook.getPosY()] = this.rook.getName();
			this.arR = this.rook.getPos();
			/*Updates board and previous variable if it has*/
		}//end if
		else{
			arr[this.rook.getPosX()][this.rook.getPosY()] = this.rook.getName();//Updates board when game starts and no change to previous has been made
		}//end else

	}//end posFill

}//end Game class
