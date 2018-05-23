//最大子序列 动态规划
public class LCS {
	public static void LCS_Length(int [] arry1,int [] arry2) {
		int arry1Length = arry1.length;
		int arry2Length = arry2.length;
		int [][] stationArray = new int[arry1Length][arry2Length];
		int [][]  derectionArray = new int [arry1Length][arry2Length];//1_cross,2_left,3_up
     //initialise
		for (int i = 0 ; i < arry1Length ; i++ ) {
			stationArray[i][0] = 0;
		}
		for ( int i = 0 ; i < arry2Length ; i++ ) {
			stationArray[0][i] = 0;
		}
		System.out.println();
		/*初始化状态和方向数组，
		1.对角线
		2.最大的左或者最大的上
		*/
		for ( int i = 1; i < arry1Length;i++ ) {
			for (int j =1 ; j < arry2Length ; j++ ) {
				if(arry1[i]==arry2[j]) {
				  stationArray[i][j]=stationArray[i-1][j-1]+1;
     			  derectionArray[i][j]=1;//cross
     		}
     		else if (stationArray[i-1][j] >= stationArray[i][j-1]) {
     			stationArray[i][j]=stationArray[i-1][j];
     			derectionArray[i][j]=3;//up
     		}
     		else {
     			stationArray[i][j]=stationArray[i][j-1];
     			derectionArray[i][j]=2;//left
     		}
     	}
     }
		System.out.println("stationArray");
		for ( int i = 0; i < arry1Length;i++ ) {
			for (int j =0 ; j < arry2Length ; j++ ) {
				System.out.print(stationArray[i][j] + "  ");
     	}
			System.out.println();
     }
		System.out.println("derectionArray: 1_对角线 ,2_左边,3_上边");
		for ( int i = 0; i < arry1Length-1;i++ ) {
			for (int j =0 ; j < arry2Length-1 ; j++ ) {
				System.out.print(derectionArray[i][j] + "  ");
     	}
			System.out.println();
     }
		System.out.println("result:");
		
     printLcs( derectionArray, arry1,arry1Length-1,arry2Length-1) ;

 }
 public static void printLcs(int [][] derectionArray,int [] arry1,int nextLength1,int nextLength2) {
 	if (nextLength1==0 && nextLength2 == 0)
 		return;
 	if (derectionArray[nextLength1][nextLength2]==1) {//cross
 		System.out.print(arry1[nextLength1] + "  ");
 	}
 	 else if (derectionArray[nextLength1][nextLength2]==2) {//left
 	 	printLcs(derectionArray,arry1,nextLength1,nextLength2-1);
 	 }
 	 else if (derectionArray[nextLength1][nextLength2]==3) {//up
 	 	printLcs(derectionArray,arry1,nextLength1-1,nextLength2);
 	 }
 	}

 	public static void main(String[] args) {
 		int [] arry1 = new int[]{1,0,0,1,0,1,0,1};
 		int [] arry2 = new int [] {0,1,0,1,1,0,1,1,0};
 		LCS_Length( arry1,arry2) ;
 	}

 }
