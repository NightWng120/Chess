import java.util.*;


public abstract class Player{



	protected Queen queen;
	protected King king;
	protected Bishop bishopW;
	protected Bishop bishopB;
	protected Rook rookW;
	protected Rook rookB;
	protected Knight knightB;
	protected Knight knightW;
	protected Vector<Pawn> vecPawn;
	protected boolean color;
	protected int points;

	public Player(boolean color){
		
		int i;
		
		this.color = color;
		this.points = 0;
		this.queen.setColor(color);
		this.king.setColor(color);
		this.bishopW.setColor(color);
		this.bishopB.setColor(color);
		this.rookW.setColor(color);
		this.rookB.setColor(color);
		this.knightB.setColor(color);
		this.knightW.setColor(color);

		for(i = 0; i < 8; i++){

			this.vecPawn.add(new Pawn());
			this.vecPawn.lastElement().setColor(color);
		}//end for loop



	}//end constructor
	
	public boolean movePiece(int[] pos, int[] next){


		
		int[] arQ = this.queen.getPos();
		int[] arK = this.king.getPos();
		int[] arkW = this.knightW.getPos();
		int[] arkB = this.knightB.getPos();
		int[] arbB = this.bishopB.getPos();
		int[] arbW = this.bishopW.getPos();
		int[] arrB = this.rookB.getPos();
		int[] arrW = this.rookW.getPos();
		int[] arp1 = this.vecPawn.get(0).getPos();
		int[] arp2 = this.vecPawn.get(1).getPos();
		int[] arp3 = this.vecPawn.get(2).getPos();
		int[] arp4 = this.vecPawn.get(3).getPos();
		int[] arp5 = this.vecPawn.get(4).getPos();
		int[] arp6 = this.vecPawn.get(5).getPos();
		int[] arp7 = this.vecPawn.get(6).getPos();
		int[] arp8 = this.vecPawn.get(7).getPos();
		int i;	
			
			

	
			
		if(pos[0] > 7 || pos[1] > 7 || next[0] > 7 || next[1] > 7 || pos[0] < 0 || pos[1] < 0 || next[0] < 0 || next[1] < 0){

			return false;

		}//end if
		
		else{
        
			if(pos[0] == arQ[0] && pos[1] == arQ[1]){



			}//end if
			if(pos[0] == arK[0] && pos[1] == arK[1]){



			}//end if
			if(pos[0] == arkB[0] && pos[1] == arkB[1]){



			}//end if
			if(pos[0] == arkW[0] && pos[1] == arkW[1]){



			}//end if
			if(pos[0] == arbW[0] && pos[1] == arbW[1]){



			}//end if
			if(pos[0] == arbB[0] && pos[1] == arbB[1]){



			}//end if
			if(pos[0] == arrW[0] && pos[1] == arrW[1]){



			}//end if
			if(pos[0] == arrB[0] && pos[1] == arrB[1]){



			}//end if
			if(pos[0] == arp1[0] && pos[1] == arp1[1]){



			}//end if
			if(pos[0] == arp2[0] && pos[1] == arp2[1]){



			}//end if
			if(pos[0] == arp3[0] && pos[1] == arp3[1]){



			}//end if
			if(pos[0] == arp4[0] && pos[1] == arp4[1]){



			}//end if
			if(pos[0] == arp5[0] && pos[1] == arp5[1]){



			}//end if
			if(pos[0] == arp6[0] && pos[1] == arp6[1]){



			}//end if
			if(pos[0] == arp7[0] && pos[1] == arp7[1]){



			}//end if
			if(pos[0] == arp8[0] && pos[1] == arp8[1]){

			
			}//end if
			
        
		}//end else
		return false;
	}//end movePiece

	public static <T> boolean valid(<? extends T> obj, int[] next, double slope, double dist){

		int[] pos = obj.getPos();
	
		if(
			if(obj.slope(next) == knightB.slope(pos)){
				
					

			}//end if 
			else if(obj.slope(next) == slope && obj.dist(next) < dist){

				return true;
			}//end else if
			else if(obj.slope(next) == slope && obj.dist(next) > dist

		

	}//end valid

}//end Player class




























