import java.util.Scanner;

class Player1 extends Player{

	private int[] arQ;
	private int[] arK;
	private int[] arkW;
	private int[] arkB;
	private int[] arbB;
	private int[] arbW;
	private int[] arrB;
	private int[] arrW;
	private int[] arp1;
	private int[] arp2;
	private int[] arp3;
	private int[] arp4;
	private int[] arp5;
	private int[] arp6;
	private int[] arp7;
	private int[] arp8;

	public Player1(boolean color){
		
		super(color);
		this.arQ = new int[2];
		this.arK = new int[2];
		this.arkW = new int[2];
		this.arkB = new int[2];
		this.arbB = new int[2];
		this.arbW = new int[2];
		this.arrB = new int[2];
		this.arrW = new int[2];
		this.arp1 = new int[2];
		this.arp2 = new int[2];
		this.arp3 = new int[2];
		this.arp4 = new int[2];
		this.arp5 = new int[2];
		this.arp6 = new int[2];
		this.arp7 = new int[2];
		this.arp8 = new int[2];
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
					input.nextInt();
					
					temp[1] = input.nextInt();
					System.out.printf("\n\n");
					System.out.printf(": ");
					next[0] = input.nextInt();
					next[1] = input.nextInt();
					if(movePiece(player2, temp, next)) {
						loop = false;
						loop2 = false;
						
					}//end if
					else if(!movePiece(player2, temp, next)) {
						
						System.out.println("****That is not a valid move*****");
						System.out.printf("\n\n");
						continue;
						
					}//end else if
				
				
			}//end while loop
			
		}//end while loop
		return false;
	}//end menuPlayer\
	public void posFill(String ar[][], Player2 player2 ) {
	int i;
		
		if(arK[0] != this.king.getPosX() && arK[1] != this.king.getPosY()) {
			
			
			ar[arK[0]][arK[1]] = " ";
		}//end if
		else if(arK[0] == this.king.getPosX() && arK[1] == this.king.getPosY()) {
		
			ar[this.king.getPosX()][this.king.getPosY()] = this.king.getName(); 
		}//end else if
		/*----------------------------------------------------------------------*/
		
		if(arQ[0] != this.queen.getPosX() && arQ[1] != this.queen.getPosY()) {
			
			
			ar[arQ[0]][arQ[1]] = " ";
		}//end if
		else if(arQ[0] == this.queen.getPosX() && arQ[1] == this.queen.getPosY()) {
		
			ar[this.queen.getPosX()][this.queen.getPosY()] = this.queen.getName(); 
		}//end else if
		/*----------------------------------------------------------------------*/
		
		if(arrB[0] != this.rookB.getPosX() && arrB[1] != this.rookB.getPosY()) {
			
			
			ar[arrB[0]][arrB[1]] = " ";
		}//end if
		else if(arrB[0] == this.rookB.getPosX() && arrB[1] == this.rookB.getPosY()) {
		
			ar[this.rookB.getPosX()][this.rookB.getPosY()] = this.rookB.getName(); 
		}//end else if
		/*----------------------------------------------------------------------*/
		
		if(arrW[0] != this.rookW.getPosX() && arrW[1] != this.rookW.getPosY()) {
			
			
			ar[arrW[0]][arrW[1]] = " ";
		}//end if
		else if(arrW[0] == this.rookW.getPosX() && arrW[1] == this.rookW.getPosY()) {
		
			ar[this.rookW.getPosX()][this.rookW.getPosY()] = this.rookW.getName(); 
		}//end else if
		/*----------------------------------------------------------------------*/
		
		if(arbB[0] != this.bishopB.getPosX() && arbB[1] != this.bishopB.getPosY()) {
			
			
			ar[arbB[0]][arbB[1]] = " ";
		}//end if
		else if(arbB[0] == this.bishopB.getPosX() && arbB[1] == this.bishopB.getPosY()) {
		
			ar[this.bishopB.getPosX()][this.bishopB.getPosY()] = this.bishopB.getName(); 
		}//end else if
		/*----------------------------------------------------------------------*/
		
		if(arbW[0] != this.bishopW.getPosX() && arbW[1] != this.bishopW.getPosY()) {
			
			
			ar[arbW[0]][arbW[1]] = " ";
		}//end if
		else if(arbW[0] == this.bishopW.getPosX() && arbW[1] == this.bishopW.getPosY()) {
		
			ar[this.bishopW.getPosX()][this.bishopW.getPosY()] = this.bishopW.getName(); 
		}//end else if
		/*----------------------------------------------------------------------*/
		
		if(arkW[0] != this.knightW.getPosX() && arkW[1] != this.knightW.getPosY()) {
			
			
			ar[arkW[0]][arkW[1]] = " ";
		}//end if
		else if(arkW[0] == this.knightW.getPosX() && arkW[1] == this.knightW.getPosY()) {
		
			ar[this.knightW.getPosX()][this.knightW.getPosY()] = this.knightW.getName(); 
		}//end else if
		/*----------------------------------------------------------------------*/
		
		if(arkB[0] != this.knightB.getPosX() && arkB[1] != this.knightB.getPosY()) {
			
			
			ar[arkB[0]][arkB[1]] = " ";
		}//end if
		else if(arkB[0] == this.knightB.getPosX() && arkB[1] == this.knightB.getPosY()) {
		
			ar[this.knightB.getPosX()][this.knightB.getPosY()] = this.knightB.getName(); 
		}//end else if
		/*----------------------------------------------------------------------*/
		
		if(arp1[0] != this.vecPawn.get(0).getPosX() && arp1[1] != this.vecPawn.get(0).getPosY()) {
			
			
			ar[arp1[0]][arp1[1]] = " ";
		}//end if
		else if(arp1[0] == this.vecPawn.get(0).getPosX() && arp1[1] == this.vecPawn.get(0).getPosY()) {
		
			ar[this.vecPawn.get(0).getPosX()][this.vecPawn.get(0).getPosY()] = this.vecPawn.get(0).getName(); 
		}//end else if
		/*----------------------------------------------------------------------*/
		
		if(arp2[0] != this.vecPawn.get(1).getPosX() && arp2[1] != this.vecPawn.get(1).getPosY()) {
			
			
			ar[arp2[0]][arp2[1]] = " ";
		}//end if
		else if(arp2[0] == this.vecPawn.get(1).getPosX() && arp2[1] == this.vecPawn.get(1).getPosY()) {
		
			ar[this.vecPawn.get(1).getPosX()][this.vecPawn.get(1).getPosY()] = this.vecPawn.get(1).getName(); 
		}//end else if
		/*----------------------------------------------------------------------*/		
		if(arp3[0] != this.vecPawn.get(2).getPosX() && arp3[1] != this.vecPawn.get(2).getPosY()) {
			
			
			ar[arp3[0]][arp3[1]] = " ";
		}//end if
		else if(arp3[0] == this.vecPawn.get(2).getPosX() && arp3[1] == this.vecPawn.get(2).getPosY()) {
		
			ar[this.vecPawn.get(2).getPosX()][this.vecPawn.get(2).getPosY()] = this.vecPawn.get(2).getName(); 
		}//end else if
		/*----------------------------------------------------------------------*/		
		if(arp4[0] != this.vecPawn.get(3).getPosX() && arp4[1] != this.vecPawn.get(3).getPosY()) {
			
			
			ar[arp4[0]][arp4[1]] = " ";
		}//end if
		else if(arp4[0] == this.vecPawn.get(3).getPosX() && arp4[1] == this.vecPawn.get(3).getPosY()) {
		
			ar[this.vecPawn.get(3).getPosX()][this.vecPawn.get(3).getPosY()] = this.vecPawn.get(3).getName(); 
		}//end else if
		/*----------------------------------------------------------------------*/		
		if(arp5[0] != this.vecPawn.get(4).getPosX() && arp5[1] != this.vecPawn.get(4).getPosY()) {
			
			
			ar[arp5[0]][arp5[1]] = " ";
		}//end if
		else if(arp5[0] == this.vecPawn.get(4).getPosX() && arp5[1] == this.vecPawn.get(4).getPosY()) {
		
			ar[this.vecPawn.get(4).getPosX()][this.vecPawn.get(4).getPosY()] = this.vecPawn.get(4).getName(); 
		}//end else if
		/*----------------------------------------------------------------------*/		
		if(arp6[0] != this.vecPawn.get(5).getPosX() && arp6[1] != this.vecPawn.get(5).getPosY()) {
			
			
			ar[arp6[0]][arp6[1]] = " ";
		}//end if
		else if(arp6[0] == this.vecPawn.get(5).getPosX() && arp6[1] == this.vecPawn.get(5).getPosY()) {
		
			ar[this.vecPawn.get(5).getPosX()][this.vecPawn.get(5).getPosY()] = this.vecPawn.get(5).getName(); 
		}//end else if
		/*----------------------------------------------------------------------*/		
		if(arp7[0] != this.vecPawn.get(6).getPosX() && arp7[1] != this.vecPawn.get(6).getPosY()) {
			
			
			ar[arp7[0]][arp7[1]] = " ";
		}//end if
		else if(arp7[0] == this.vecPawn.get(6).getPosX() && arp7[1] == this.vecPawn.get(6).getPosY()) {
		
			ar[this.vecPawn.get(6).getPosX()][this.vecPawn.get(6).getPosY()] = this.vecPawn.get(6).getName(); 
		}//end else if
		/*----------------------------------------------------------------------*/		
		if(arp8[0] != this.vecPawn.get(7).getPosX() && arp8[1] != this.vecPawn.get(7).getPosY()) {
			
			
			ar[arp8[0]][arp8[1]] = " ";
		}//end if
		else if(arp8[0] == this.vecPawn.get(7).getPosX() && arp8[1] == this.vecPawn.get(7).getPosY()) {
		
			ar[this.vecPawn.get(7).getPosX()][this.vecPawn.get(7).getPosY()] = this.vecPawn.get(7).getName(); 
		}//end else if
		/*----------------------------------------------------------------------*/
		
		 this.arQ[0] = this.queen.getPosX();
		 this.arQ[1] = this.queen.getPosX();

		 this.arK[0] = this.king.getPosX();
		 this.arK[1] = this.king.getPosY();

		 this.arkW[0] = this.knightW.getPosX();
		 this.arkW[1] = this.knightW.getPosY();

		 this.arkB[0] = this.knightB.getPosX();
		 this.arkB[1] = this.knightB.getPosY();

		 this.arbB[0] = this.bishopB.getPosX();
		 this.arbB[1] = this.bishopB.getPosY();

		 this.arbW[0] = this.bishopW.getPosX();
		 this.arbW[1] = this.bishopW.getPosY();

		 this.arrB[0] = this.rookB.getPosX();
		 this.arrB[1] = this.rookB.getPosY();

		 this.arrW[0] = this.rookW.getPosX();
		 this.arrW[1] = this.rookW.getPosY();

		 this.arp1[0] = this.vecPawn.get(0).getPosX();
		 this.arp1[1] = this.vecPawn.get(0).getPosY();

		 this.arp2[0] = this.vecPawn.get(1).getPosX();
		 this.arp2[1] = this.vecPawn.get(1).getPosY();

		 this.arp3[0] = this.vecPawn.get(2).getPosX();
		 this.arp3[1] = this.vecPawn.get(2).getPosY();

		 this.arp4[0] = this.vecPawn.get(3).getPosX();
		 this.arp4[1] = this.vecPawn.get(3).getPosY();
		 

		 this.arp5[0] = this.vecPawn.get(4).getPosX();
		 this.arp5[1] = this.vecPawn.get(4).getPosY();

		 this.arp6[0] = this.vecPawn.get(5).getPosX();
		 this.arp6[1] = this.vecPawn.get(5).getPosY();

		 this.arp7[0] = this.vecPawn.get(6).getPosX();
		 this.arp7[1] = this.vecPawn.get(6).getPosY();

		 this.arp8[0] = this.vecPawn.get(7).getPosX();
		 this.arp8[1] = this.vecPawn.get(7).getPosY();
			
		
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
		this.arrW[0] = 0;
		this.arrW[1] = 7;
		this.knightB.setPos(ar[7][1]);
		this.arkB[0] = 1;
		this.arkB[1] = 7;
		this.bishopW.setPos(ar[7][2]);
		this.arbW[0] = 2;
		this.arbW[1] = 7;
		if(!this.color) {
			
			this.queen.setPos(ar[7][3]);
			this.arQ[0] = 3;
			this.arQ[1] = 7;
			this.king.setPos(ar[7][4]);
			this.arK[0] = 4;
			this.arK[1] = 7;
		}//end if
		else {
			this.king.setPos(ar[7][3]);
			this.arK[0] = 3;
			this.arK[1] = 7;
			this.queen.setPos(ar[7][4]);
			this.arQ[0] = 4;
			this.arQ[1] = 7;
		}//end else
		this.bishopB.setPos(ar[7][5]);
		this.arbB[0] = 5;
		this.arbB[1] = 7;
		this.knightW.setPos(ar[7][6]);
		this.arkW[0] = 6;
		this.arkB[1] = 7;
		this.rookB.setPos(ar[7][7]);
		this.arrB[0] = 7;
		this.arrB[1] = 7;
		for(i = 0; i < 8; i++) {
			
			this.vecPawn.get(i).setPos(ar[6][i]);
			
		}//end for loop
		this.arp1[0] = 0;
		this.arp1[1] = 6;
		
		this.arp2[0] = 1;
		this.arp2[1] = 6;
		
		this.arp3[0] = 2;
		this.arp3[1] = 6;
		
		this.arp4[0] = 3;
		this.arp4[1] = 6;
		
		this.arp5[0] = 4;
		this.arp5[1] = 6;
		
		
		this.arp6[0] = 5;
		this.arp6[1] = 6;
		
		this.arp7[0] = 6;
		this.arp7[1] = 6;
		
		this.arp8[0] = 7;
		this.arp8[1] = 6;
	}//end PrePosFill

}//end Player1 class
