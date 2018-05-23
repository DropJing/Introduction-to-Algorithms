
//矩阵的最优乘法 动态规划
public class ALG_15_2_1 {
	public static void MAXTRX_CHANIN_ORDER(int[] p)
	{
		int n=p.length;
		int[][] s=new int[n][n];
		int j=0,i=0;
		double q=0;
		double[][] m=new double[n][n] ;
		for (int l = 2; l < n ; l++) {//确定长度
			
			for ( i = 0; i <n-l+1 ; i++) {//确定起始位置	
				 j=i+l-1;
				 System.out.println(l+" "+i+" "+j+" ");
				 m[i][j]=Double.POSITIVE_INFINITY;
				 for (int k = i; k<j; k++) {//i和j之间的每一个节点都遍历
					 System.out.println(l+" "+i+" "+j+" "+k);
					 System.out.println();
					  q=m[i][k]+m[k+1][j]+p[i]*p[k]*p[j];
					
					 if(q<m[i][j])
					 {
						 m[i][j]=q;
						 s[i][j]=k;//存划分节点
					 }
				}	
			}
		}
		System.out.println(2+" "+6+" "+s[2][5]); 
		PRINT_OPTIMAL_PARENS( s, 0, 6);
	}
	 public static void PRINT_OPTIMAL_PARENS(int [][] s, int i ,int j) {
	    if (i==j)
	    {
	    	System.out.print("（A" + i + " ");
	    }  
	    else { 
	        PRINT_OPTIMAL_PARENS(s, i, s[i][j]); 
	        PRINT_OPTIMAL_PARENS(s, s[i][j]+1, j) ; 
	        System.out.print("）"); 
	    } 
	        
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A=new int[] {5,10,3,12,5,50,6};
		MAXTRX_CHANIN_ORDER(A);
		
	}

}
