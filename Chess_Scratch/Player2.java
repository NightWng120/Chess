import java.util.*;


class Player2 extends Player{
	


	private int[] arR;
	private int[] arK;
	private int[] arP;
	private int[] arKi;

	public <J extends Player> Player2(boolean color){

		super(color);/*This function passes the argument of this constructor to the abstract class's constructor */
		
		prePosfill();//Function that sets initial position of piece call
		if(!color) {
			this.vecpos.add(this.rook.getPos());
			this.vecpos.add(this.knight.getPos());
			this.vecpos.add(this.pawn.getPos());
			this.vecpos.add(this.king.getPos());
			
			
			
		}//end if
		
		
	}//end constructor


	public boolean move(Player1 player1){
		
		String[][] ar = {{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},
		/*Blank Board Array*/{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "}};
		
		boolean loop = true;
		int[] next = new int[2];
		int[] pos = new int[2];
		int j;
		int x = 0;/*Variable for determining if the loop has already been ran because of
				a move that was inputted incorrectly*/

		boolean take;//Boolean that is true or false when a piece is or isn't taken		
		String check = this.king.mate(player1.vecfilt);
		String color = "NULLL"; //Stores color of player as a string
		
		if(this.color){

			color = "White";
		}//end if
		else if(!this.color){

			color = "Black";
		}//end if

		Scanner input = new Scanner(System.in);
		String userin;
		
		System.out.println("|-------------------------|");
		System.out.println("|        Player 2         |");
		System.out.println("|-------------------------|");
		System.out.println("| Press Enter to Continue |");
		System.out.println("|-------------------------|");
		System.out.printf("\n\n");
		userin = input.nextLine();			
		
		while(loop){
			take = false;
			
			 
			posFill(ar, player1);//Function that sets updated position of piece call
			
			if(x == 0) {//If loop hasn't been ran before add positions to position vector
				this.vecpos.add(this.rook.getPos());
				this.vecpos.add(this.knight.getPos());
				this.vecpos.add(this.pawn.getPos());
				
			}//end if
			
			print(ar);//Board print function
			if(check.equals("c")) {
				System.out.println("|-------------------------|");
				System.out.println("|  Your King is in Check  |");
				
				
			}//end if
			System.out.println("|-------------------------|");
			System.out.println("|   Player 2 - " + color + "      |");
			System.out.println("|-------------------------|");
			System.out.println("| Enter the Coords of your|");			
			System.out.println("| next move               |");			
			System.out.println("|-------------------------|");			
			System.out.printf("\n\n");			
			System.out.printf(": ");
			try{
				userin = input.nextLine();			
				if(userin.equals("quit")){
					return false;
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
			}//end try
			catch(NumberFormatException | StringIndexOutOfBoundsException ex){
				System.out.println("***Invalid Input***");
				continue;
			}//end catch
			
			
			for(j = 0; j < player1.vecpos.size(); j++){//For loop runs for size of player1 position vector

				if(Arrays.equals(next, player1.vecpos.get(j))){//If statement is true when jth player1 vector position is equal to inputted position


					take = true;
					j = player1.vecpos.size();

				}//end if
			}//end for loop	

			
			if(MoveCheck(player1, pos, next, take)){
				
				if(check.equals("c")) {
					
					player1.redFilt(this, false);
					check = this.king.mate(player1.vecfilt);
					if(check.contentEquals("c")) {
						
						
						continue;
						
					}//end if
					
					else {
						
						take(next, player1);
						this.vecpos.clear();
						this.vecpos.add(this.rook.getPos());
						this.vecpos.add(this.knight.getPos());
						this.vecpos.add(this.pawn.getPos());
						this.vecpos.add(this.king.getPos());
						player1.vecpos.clear();
						this.vecfilt.clear();
						this.vecfilt = redFilt(player1, false);
						x = 0;
						
						return true;
						
						
					}//end else
				}//end if
				
				else if(check.equals("s")) {
					
					System.out.println("|--------Stalemate--------|");
					loop = false;
				}//end else if
				
				else if(check.equals("m")) {
					
					System.out.println("|-------------------------|");
					System.out.println("|        Checkmate        |");
					System.out.println("|-------------------------|");
					System.out.println("|      Player 2 Wins!     |");
					System.out.println("|-------------------------|");
					loop = false;
				}//end else if
				
				else {

					take(next, player1);
					this.vecpos.clear();
					this.vecpos.add(this.rook.getPos());
					this.vecpos.add(this.knight.getPos());
					this.vecpos.add(this.pawn.getPos());
					this.vecpos.add(this.king.getPos());
					player1.vecpos.clear();
					this.vecfilt.clear();
					this.vecfilt = redFilt(player1, false);
					x = 0;
					
					return true;
				}//end else
			}//end if	
			
			
			
			
			else{
				
				System.out.println("***Invalid Move***");
				System.out.printf("\n\n");
				x++;
				continue;
			}//end else
			
				

		}//end while loop

		return false;


	}//end move	
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
	
	public void prePosfill(){//Function body for function that sets initial position of piece and previous position variable
		
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
			this.king.setPos(ar[0][3]);
			this.arKi = this.king.getPos();
		}//end if
	
		else if(!this.color){
			this.rook.setPos(ar[7][0]);
			this.arR = this.rook.getPos();
			this.knight.setPos(ar[7][1]);
			this.arK = this.knight.getPos();
			this.pawn.setPos(ar[6][4]);
			this.arP = this.pawn.getPos();
			this.king.setPos(ar[7][4]);
			this.arKi = this.king.getPos();
	
		}//end else if
	}//end prePosfill
	public void take(int[] next, Player1 player1){
		/*Function determines what opposing piece the selected piece is taking
	 	 *when the inputed next position is the same as the position as an
	 	 *opposing piece. It then sets the position of the opposing piece 
	 	 *to a space outside of the board*/

		if(Arrays.equals(next, player1.rook.getPos())){
			int r[] = {7,9};
			player1.rook.setPos(r);
		}//end if
		else if(Arrays.equals(next, player1.knight.getPos())){
			int k[] = {6,9};
			player1.knight.setPos(k);

		}//end else if
		else if(Arrays.equals(next, player1.pawn.getPos())){
			int p[] = {5, 9};
			player1.pawn.setPos(p);
		}//end else if
		else if(Arrays.equals(next, player1.king.getPos())){
			int p[] = {4, 9};
			player1.king.setPos(p);
		}//end else if
		

	}//end take
	public void posFill(String[][] arr, Player1 player1){/*Function body for function that determines whether piece has moved or not; 
							updates position variable and board array accordingly*/

		int[] arR = this.rook.getPos();
		int[] arK = this.knight.getPos();
		int[] arP = this.knight.getPos();
		int[] arKi = this.king.getPos();



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
		
		if(!Arrays.equals(this.arKi, arKi)){//If checks if position has changed
			arr[this.arKi[0]][this.arKi[1]] = " ";
			arr[this.king.getPosX()][this.king.getPosY()] = this.king.getName();
			this.arKi = this.king.getPos();
			/*Updates board and previous variable if it has*/
		}//end if
		
		else{
			arr[this.king.getPosX()][this.king.getPosY()] = this.king.getName();//Updates board when game starts and no change to previous has been made
		}//end else



		arr[player1.rook.getPosX()][player1.rook.getPosY()] = player1.rook.getName();
		arr[player1.knight.getPosX()][player1.knight.getPosY()] = player1.knight.getName();
		arr[player1.pawn.getPosX()][player1.pawn.getPosY()] = player1.pawn.getName();
		arr[player1.king.getPosX()][player1.king.getPosY()] = player1.king.getName();
	}//end posFill

}//end Player1 class
