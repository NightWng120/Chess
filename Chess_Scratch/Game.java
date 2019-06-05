import java.util.*;


class Game extends Player{
	


	private int[] arR;
	private int[] arK;
	private int[] arP;

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String userin;
		boolean loop = true;
		while(loop){
			System.out.println("What color do you want?: (White/Black)");
			userin = input.nextLine();
			if(userin.equals("white") || userin.equals("White")){
				new Game(true);
                
			}//end if
			else if(userin.equals("black") || userin.equals("Black")){
				new Game(false);
			}//end else if
			else if(userin.equals("quit")){
				loop = false;
			}//end else if
			else{
				System.out.println("***Invalid Input***");
				continue;
			}//end else

		}//end while loop
	}//end main
	
	public Game(boolean color){

		super(color);/*This function passes the argument of this constructor to the abstract class's constructor */
		
		prePosfill();//Function that sets initial position of piece call

		String ar[][] = {{" "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "},
		/*Blank Board Array*/{" "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "}};;
		
		boolean loop = true;
		int[] next = new int[2];
		int[] pos = new int[2];		
		
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
				/*If statement determines if inputted letter is valid for board and switch converts letter to integer*/
        
					switch(userin.charAt(0)){
						
						case 'a':
							pos[0]= 0;
							break;
        
						case 'b':
							pos[0] = 1;
							break;
        
						case 'c':
							pos[0] = 2;
							break;
        
						case 'd':
							pos[0] = 3;
							break;
        
						case 'e':
							pos[0] = 4;
							break;
        
						case 'f':
							pos[0] = 5;
							break;
        
						case 'g':
							pos[0] = 6;
							break;
        
						case 'h':
							pos[0] = 7;
							break;
        
						case 'A':
							pos[0] = 0;
							break;
        
						case 'B':
							pos[0] = 1;
							break;
        
						case 'C':
							pos[0] = 2;
							break;
        
						case 'D':
							pos[0] = 3;
							break;
        
						case 'E':
							pos[0] = 4;
							break;
        
						case 'F':
							pos[0] = 5;
							break;
        
						case 'G':
							pos[0] = 6;
							break;
        
						case 'H':
							pos[0] = 7;
							break;
        
        
        
        
        
					}//end switch
					pos[1] = (Integer.parseInt("" + userin.charAt(1)) - 1);
				}//end if
				else{
					System.out.println("***Invalid Input***");
					continue;
        
				}//end else
				if(userin.charAt(3) >= 'a' || userin.charAt(3) <= 'h' || userin.charAt(3) >= 'A' || userin.charAt(3) <= 'H'){
				/*If statement determines if inputed letter is valid for board and switch converts letter to integer*/
        
					switch(userin.charAt(3)){
						
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
					next[1] = (Integer.parseInt("" + userin.charAt(4)) - 1);

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
			if(MoveCheck(pos, next)){

				continue;
			}//end if	
			else{
				System.out.println("***Invalid Move***");
				System.out.printf("\n\n");
				continue;
			}//end else
			
				

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
	
	public void prePosfill(){//Function body for function that sets intial position of piece and previous position variable
		
		int[] ar[][] = {{{0,0},{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0}},{{0,1},{1,1},{2,1},{3,1},{4,1},{5,1},{6,1},{7,1}},{{0,2},{1,2},{2,2},{3,2},{4,2},{5,2},{6,2},{7,2}}
		,{{0,3},{1,3},{2,3},{3,3},{4,3},{5,3},{6,3},{7,3}},{{0,4},{1,4},{2,4},{3,4},{4,4},{5,4},{6,4},{7,4}},{{0,5},{1,5},{2,5},{3,5},{4,5},{5,5},{6,5},{7,5}}
		,{{0,6},{1,6},{2,6},{3,6},{4,6},{5,6},{6,6},{7,6}},{{0,7},{1,7},{2,7},{3,7},{4,7},{5,7},{6,7},{7,7}}};
		/*Array of position arrays for every position on the board*/		
			
		if(this.color){

			this.rook.setPos(ar[0][7]);//Piece position setting
			this.arR = this.rook.getPos();//Previous position assignment
			this.knight.setPos(ar[0][6]);
			this.arK = this.knight.getPos();
			this.pawn.setPos(ar[1][3]);
			this.arP = this.pawn.getPos();
		}//end if

		else if(!this.color){
			this.rook.setPos(ar[7][0]);
			this.arR = this.rook.getPos();
			this.knight.setPos(ar[7][1]);
			this.arK = this.knight.getPos();
			this.pawn.setPos(ar[6][4]);
			this.arP = this.pawn.getPos();

		}//end else if
	}//end prePosfill
	public void posFill(String[][] arr){/*Function body for function that determines whether piece has moved or not; 
							updates position variable and board array accordingly*/

		int[] arR = this.rook.getPos();
		int[] arK = this.knight.getPos();
		int[] arP = this.knight.getPos();
		



		if(!Arrays.equals(this.arR, arR)){//If checks if position has changed
			arr[this.arR[0]][this.arR[1]] = " ";
			arr[this.rook.getPosX()][this.rook.getPosY()] = this.rook.getName();
			this.arR = this.rook.getPos();
			/*Updates board and previous variable if it has*/
		}//end if
		else{
			arr[this.rook.getPosX()][this.rook.getPosY()] = this.rook.getName();//Updates board when game starts and no change to previous has been made
		}//end else




		if(!Arrays.equals(this.arK, arK)){//If checks if position has changed
			arr[this.arK[0]][this.arK[1]] = " ";
			arr[this.knight.getPosX()][this.knight.getPosY()] = this.knight.getName();
			this.arK = this.knight.getPos();
			/*Updates board and previous variable if it has*/
		}//end if
		else{
			arr[this.knight.getPosX()][this.knight.getPosY()] = this.knight.getName();//Updates board when game starts and no change to previous has been made
		}//end else



		if(!Arrays.equals(this.arP, arP)){//If checks if position has changed
			arr[this.arP[0]][this.arP[1]] = " ";
			arr[this.pawn.getPosX()][this.pawn.getPosY()] = this.pawn.getName();
			this.arP = this.pawn.getPos();
			/*Updates board and previous variable if it has*/
		}//end if
		else{
			arr[this.pawn.getPosX()][this.pawn.getPosY()] = this.pawn.getName();//Updates board when game starts and no change to previous has been made
		}//end else



	}//end posFill

}//end Game class
