import java.util.*;
public class heapsort {
    public static int count=0;
    public static int maxChild(int [] arry ,int parent ,int length)
    {
        int child=parent*2+1;
        count++;
        if(child<=length)
        {
          if(child<length)
          {
           if(arry[child]<arry[child+1])
           {
            child++;
            count++;
         }
    }
}
return child;
}
public static void  exchange(int [] arry ,int index1,int index2)
{
    int temp=arry[index1];
    count++;
    arry[index1]=arry[index2];
      count++;
    arry[index2]=temp;
      count++;
}
public static void heapify(int [] arry,int parent,int length)
{
 int child=maxChild(arry,parent,length);
 if (child<=length&&arry[parent]<arry[child])
 {
  exchange(arry ,parent,child);
  parent=child;
  count++;
  heapify( arry, parent, length);
}
}
public static void initialize_Heap(int [] arry)
{
    for (int i=arry.length/2;i>=0;i-- ) 
    {
      heapify(arry,i,arry.length-1);
      count++;
    }
}
public static void change_MaxNumber(int [] arry)
{
   for (int j=arry.length-1;j>0 ;j--) 
   {
    exchange(arry ,0,j);
    heapify(arry,0,j-1);
} 

}
public static void heapSort(int[] arry)
{
  initialize_Heap(arry);
  change_MaxNumber(arry);
}
public static void print_Arry(int [] arry)
{
   for (int i=0;i<arry.length ;i++ ) {
    System.out.print(arry[i]+"  ");
}    
System.out.println();
}
public static int [] initialize_Arry(int arryLength)
{
    int[] array = new int[arryLength];
    for(int i=0;i<array.length;i++) {
     array[i] = (int)(Math.random()*arryLength);
 }
 return array;
}
public static double runTime()
{
   long startTime = System.currentTimeMillis();
   long endTime = System.currentTimeMillis();
   return endTime-startTime;
}
public static int  getNumber(){
   Scanner sb = new Scanner(System.in);  
   System.out.print("Input Number:  ");  
   int  number = sb.nextInt();  
   return number;
}
public static void main(String[] args) {
    double sum=0;
    int arrayLength=getNumber();
    System.out.println("Heapsort   "+"Length of array:    "+arrayLength);
    for (int i=0;i<5 ;i++){
      count=0;
     long startTime = System.currentTimeMillis();
     int [] array=initialize_Arry(arrayLength);
     heapSort(array);
     long endTime = System.currentTimeMillis();
     double time= (double)endTime-startTime;
     System.out.println("Time:   "+time/1000+"s      ");
     sum+=time;
 }
 System.out.println("Count:  "+ count);
 System.out.println("AverageTime:   "+sum/5000);
}
}