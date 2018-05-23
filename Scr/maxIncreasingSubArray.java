
public class maxIncreasingSubArray {
  public static int myBinary(int [] maxArray , int maxLength , int arrElement )  {
		int left = 0;
		int right = maxLength-1;
		int mid = ( left + right )/2;
		while( left<=right )  
	    {  
	        if( arrElement>maxArray[mid] )   left = mid+1;  
	        else if( arrElement<maxArray[mid] ) right = mid-1;  
	        else return mid;  
	        mid = (left+right)/2;  
	    }  
		return left;
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
		int [] maxArray = new int [array.length];//�洢��ǰ���������
		int [] IndexArray = new int [array.length];// �洢���������������е��±꣬������
	    maxArray[0] = array[0];
	    int maxLength = 1;
	    for (int i = 1; i < array.length; i++) {
	    	int left_index = myBinary(maxArray , maxLength , array[i]);
	    	maxArray[left_index] = array[i];
	    	IndexArray[i] = left_index;
	    	left_index++;
	    	if(left_index > maxLength)
	    	{
	    		maxLength = left_index;
	    	}			
		}
	    //"�±����飬������¼������Ԫ�����������������е�λ��"
	    System.out.println("��¼������Ԫ�����������������е�λ��");
	    for (int i = 0; i < IndexArray.length; i++) {
	    	 System.out.print(IndexArray[i]+"  ");
		}
	    System.out.println();
	    
	   printLongestUpArray(maxLength-1, array, IndexArray);
	}

}
/*
#include<iostream>  
using namespace std;  
  
int binarySrh( int *s, int len, int x )  
{  
    int left = 0,right = len-1, mid = (left+right)/2;  
    while( left<=right )  
    {  
        if( x>s[mid] )   left = mid+1;  
        else if( x<s[mid] ) right = mid-1;  
        else return mid;  
        mid = (left+right)/2;  
    }  
    cout << left << ' ';  
    return left;  
}  
  
int main()  
{  
    int n = 10;//ԭʼ���鳤��  
    int a[10] = { 6, 1, 8, 3, 10, 11, 12, 13,  4, 5 };  
    int maxL[10] = { 0 };//maxL[i]��¼����Ϊi�����е���Сβ��  
    int mem[10] = { 0 };//mem[i]��ʾ��a[i]��β���������  
	maxL[0] = a[0];  
    int len = 1;//length  
      
    for( int i=1; i<n; i++ )  
    {  
        int j = binarySrh( maxL, len, a[i] );  
        maxL[j] = a[i];  
        mem[i] = j;  
        if( ++j>len )  
            len = j;  
    }  
    cout << "max length: " << len << endl;  
    cout << "longest subsequence: ";  
    int currMaxLen = len-1;  
    for(  i=0; i<n; i++ )  
        cout << mem[i] << " ";  
    cout << endl;  
    for(  i=9; i>=0&&currMaxLen>=0; i-- ) {  
        if( mem[i]==currMaxLen ) {  
            cout << a[i] << " "; //�������������  
            currMaxLen--;  
        }  
    }  
    cout << endl;  
    return 0;   
}  */