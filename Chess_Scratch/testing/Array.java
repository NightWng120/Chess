import java.util.*;

class Array{

	public static void main(String[] args){

		int[] array[][] = new int[8][8][2];
		int i;
		int j;
		array[0][0] = (new int[]{0,0});
		for(i = 0; i < 8; i++){
			for(j = 0; j < 8; j++){
				array[i][j] = new int[]{j,i};
			}//end for loop
					

		}//end for loop	
		System.out.println(Arrays.deepToString(array));
		
	




	}//end main

}//end Array
