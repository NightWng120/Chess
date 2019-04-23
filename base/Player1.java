import java.util.Scanner;

class Player1 extends Player{


	public Player1(boolean color){
		
		super(color);
		PrePosFill();
	}//end constructor
		
	public boolean menuPlayer(Player2 player2){
		String ar[][] = {{" "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "},
				{" "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "}};;
		Scanner input = new Scanner(System.in);
		int next[] = new int[2];
		int temp[] = new int[2];
		boolean loop = true;
		boolean loop2 = true;
		while(loop) {
			posFill(ar, player2);
	
			System.out.println(" ---------------------------------");
			System.out.printf("7| %s | %s | %s | %s | %s | %s | %s | %s |\n", ar[0][7], ar[1][7], ar[2][7], ar[3][7], ar[4][7], ar[5][7], ar[6][7], ar[7][7]);
			System.out.println(" |---|---|---|---|---|---|---|---|");
			System.out.printf("6| %s | %s | %s | %s | %s | %s | %s | %s |\n", ar[0][6], ar[1][6], ar[2][6], ar[3][6], ar[4][6], ar[5][6], ar[6][6], ar[7][6]);
			System.out.println(" |---|---|---|---|---|---|---|---|");
			System.out.printf("5| %s | %s | %s | %s | %s | %s | %s | %s |\n", ar[0][5], ar[1][5], ar[2][5], ar[3][5], ar[4][5], ar[5][5], ar[6][5], ar[7][5]);
			System.out.println(" |---|---|---|---|---|---|---|---|");
			System.out.printf("4| %s | %s | %s | %s | %s | %s | %s | %s |\n", ar[0][4], ar[1][4], ar[2][4], ar[3][4], ar[4][4], ar[5][4], ar[6][4], ar[7][4]);
			System.out.println(" |---|---|---|---|---|---|---|---|");
			System.out.printf("3| %s | %s | %s | %s | %s | %s | %s | %s |\n", ar[0][3], ar[1][3],ar[2][3], ar[3][3], ar[4][3], ar[5][3], ar[6][3], ar[7][3]);
			System.out.println(" |---|---|---|---|---|---|---|---|");
			System.out.printf("2| %s | %s | %s | %s | %s | %s | %s | %s |\n", ar[0][2], ar[1][2], ar[2][2], ar[3][2], ar[4][2], ar[5][2], ar[6][2], ar[7][2]);
			System.out.println(" |---|---|---|---|---|---|---|---|");
			System.out.printf("1| %s | %s | %s | %s | %s | %s | %s | %s |\n", ar[0][1], ar[1][1], ar[2][1], ar[3][1], ar[4][1], ar[5][1], ar[6][1], ar[7][1]);
			System.out.println(" |---|---|---|---|---|---|---|---|");
			System.out.printf("0| %s | %s | %s | %s | %s | %s | %s | %s |\n", ar[0][0], ar[1][0], ar[2][0], ar[3][0], ar[4][0], ar[5][0], ar[6][0], ar[7][0]);
			System.out.println(" ---------------------------------");
			System.out.println("   0   1   2   3   4   5   6   7  ");
			System.out.printf("\n\n");
			while(loop2) {
				
				
					System.out.println("|-------------------------|");
					System.out.println("|     Player 1's turn     |");
					System.out.println("|-------------------------|");
					System.out.println("| Choose which piece you  |");
					System.out.println("| would like to move and  |");
					System.out.println("| the position you would  |");
					System.out.println("| like to move it to      |");
					System.out.println("|-------------------------|");
					System.out.println("| - First enter piece pos |");
					System.out.println("| with coords seperated by|");
					System.out.println("| space                   |");
					System.out.println("|- Then do the same for   |");
					System.out.println("| space you would like to |");
					System.out.println("| move to                 |");
					System.out.println("|-------------------------|");
					System.out.println("|        Example          |");
					System.out.println("|-------------------------|");
					System.out.println("| : 4 2                   |");
					System.out.println("| : 5 6                   |");
					System.out.println("|-------------------------|");
					System.out.printf("\n\n");
					System.out.printf(": ");
					temp[0] = input.nextInt();
					temp[1] = input.nextInt();
					System.out.printf("\n\n");
					System.out.printf(": ");
					next[0] = input.nextInt();
					next[1] = input.nextInt();
					if(movePiece(player2, temp, next)) {
						
						loop2 = false;
						
					}//end if
					else if(!movePiece(player2, temp, next)) {
						
						System.out.println("****That is not a valid move*****");
						System.out.printf("\n\n");
						continue;
						
					}//end else if
				
				
			}//end while loop
			
		}//end while loop
		input.close();
		return false;
	}//end menuPlayer\
	public void posFill(String ar[][], Player2 player2 ) {
		int i;
		ar[this.king.getPosX()][this.king.getPosY()] = this.king.getName(); 
		ar[this.queen.getPosX()][this.queen.getPosY()] = this.queen.getName();
		ar[this.knightW.getPosX()][this.knightW.getPosY()] = this.knightW.getName();		
		ar[this.knightB.getPosX()][this.knightB.getPosY()] = this.knightB.getName();		
		ar[this.bishopW.getPosX()][this.bishopW.getPosY()] = this.bishopW.getName();		
		ar[this.bishopB.getPosX()][this.bishopB.getPosY()] = this.bishopB.getName();	
		ar[this.rookW.getPosX()][this.rookW.getPosY()] = this.rookW.getName();
		ar[this.rookB.getPosX()][this.rookB.getPosY()] = this.rookB.getName();
		
		for(i = 0; i < 8; i ++) {
			
			ar[this.vecPawn.get(i).getPosX()][this.vecPawn.get(i).getPosY()] = this.vecPawn.get(i).getName();
			
		}//end for loop
		/*-------------------------------------------------------------------------------------*/
		ar[player2.king.getPosX()][player2.king.getPosY()] = player2.king.getName(); 
		ar[player2.queen.getPosX()][player2.queen.getPosY()] = player2.queen.getName();
		ar[player2.knightW.getPosX()][player2.knightW.getPosY()] = player2.knightW.getName();		
		ar[player2.knightB.getPosX()][player2.knightB.getPosY()] = player2.knightB.getName();		
		ar[player2.bishopW.getPosX()][player2.bishopW.getPosY()] = player2.bishopW.getName();		
		ar[player2.bishopB.getPosX()][player2.bishopB.getPosY()] = player2.bishopB.getName();	
		ar[player2.rookW.getPosX()][player2.rookW.getPosY()] = player2.rookW.getName();
		ar[player2.rookB.getPosX()][player2.rookB.getPosY()] = player2.rookB.getName();
		
		for(i = 0; i < 8; i ++) {
			
			ar[player2.vecPawn.get(i).getPosX()][player2.vecPawn.get(i).getPosY()] = player2.vecPawn.get(i).getName();
			
		}//end for loop
	}//end posFill
	public void PrePosFill() {
		int i;
		int[] ar[][] = {{{0,0},{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0}},{{0,1},{1,1},{2,1},{3,1},{4,1},{5,1},{6,1},{7,1}},{{0,2},{1,2},{2,2},{3,2},{4,2},{5,2},{6,2},{7,2}}
		,{{0,3},{1,3},{2,3},{3,3},{4,3},{5,3},{6,3},{7,3}},{{0,4},{1,4},{2,4},{3,4},{4,4},{5,4},{6,4},{7,4}},{{0,5},{1,5},{2,5},{3,5},{4,5},{5,5},{6,5},{7,5}}
		,{{0,6},{1,6},{2,6},{3,6},{4,6},{5,6},{6,6},{7,6}},{{0,7},{1,7},{2,7},{3,7},{4,7},{5,7},{6,7},{7,7}}};
		
		this.rookW.setPos(ar[7][0]);
		this.knightB.setPos(ar[7][1]);
		this.bishopW.setPos(ar[7][2]);
		if(!this.color) {
			
			this.queen.setPos(ar[7][3]);
			this.king.setPos(ar[7][4]);
		}//end if
		else {
			this.king.setPos(ar[7][3]);
			this.queen.setPos(ar[7][4]);
		}//end else
		this.bishopB.setPos(ar[7][5]);
		this.knightW.setPos(ar[7][6]);
		this.rookB.setPos(ar[7][7]);
		for(i = 0; i < 8; i++) {
			
			this.vecPawn.get(i).setPos(ar[6][i]);
			
		}//end for loop
	}//end PrePosFill

}//end Player1 class
