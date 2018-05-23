
public class LongestUpArray {

	public static int findIdex(int [] maxArray , int maxLength , int arrElement )  {
		int left_index = 0;
		  for (int i = 1; i < maxLength-1 ; i++ ) {
		    	 if ( maxArray[i-1] <= arrElement && maxArray[i] >= arrElement) {
		    	 	left_index = i;
		    	 }
		  }
		if(maxArray[0] >= arrElement) {
    		left_index = 0;
    	}
		else if (maxArray[maxLength-1] <= arrElement) {
    		left_index = maxLength ;
    	}
		return left_index;
	}
  public static void printLongestUpArray(int currentLength , int [] array , int [] IndexArray ) {
	  for (int i = array.length-1; i >= 0 && currentLength >= 0 ; i--) {
		  if( currentLength ==  IndexArray [i]  ) {
			  System.out.print(array[i]+"  ");
			  currentLength--;
		  }
	}
  }

	public static void main(String[] args) {
		int [] array = new int [] { 6, 1, 8, 3, 10, 11, 12, 13,  4, 5 };
		int [] maxArray = new int [array.length];//存储当前的最大序列
		int [] IndexArray = new int [array.length];// 存储党在数组在序列中的下标，允许覆盖
	    maxArray[0] = array[0];
	    int maxLength = 1;
	    for (int i = 1; i < array.length; i++) {
	    	int left_index = findIdex(maxArray , maxLength , array[i]);
	    	maxArray[left_index] = array[i];
	    	IndexArray[i] = left_index;
	    	left_index++;
	    	if(left_index > maxLength)
	    	{
	    		maxLength = left_index;
	    	}			
		}
	    //"下标数组，用来记录数组中元素能在最大递增数组中的位置"
	    
	    System.out.print("记录数组中元素能在最大递增数组中的位置");
	    System.out.println();
	    for (int i = 0; i < IndexArray.length; i++) {
	    	 System.out.print(IndexArray[i]+"  ");
		}
	    System.out.println();
	    for (int i = 0; i < IndexArray.length; i++) {
	    	 System.out.print(maxArray[i]+"  ");
		}
	    System.out.println();
	   printLongestUpArray(maxLength-1, array, IndexArray);
	}
}
