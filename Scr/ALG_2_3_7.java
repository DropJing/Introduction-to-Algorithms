import javax.print.attribute.standard.PrinterLocation;

import java.lang.module.FindException;
import java.util.*;
public class ALG_2_3_7 {
        public  void sort(int[] array) {
             int[] auxArray = new int[array.length];
             mergeSort(array, auxArray, 0, array.length - 1);
        }

        /**
        * 基于分治思想，执行归并排序
        * @param low 待排序数组下标下界
        * @param high 待排序数组下标上界
        */
        private void mergeSort(int[] array, int[] auxArray, int low, int high) {
             int dividedIndex = 0; // 分治位置索引变量
             if (low < high) {
                  dividedIndex = (low + high) / 2; // 计算分治位置(采用简单的二分思想)
                  mergeSort(array, auxArray, low, dividedIndex); // 左侧递归归并排序
                  mergeSort(array, auxArray, dividedIndex + 1, high); // 右侧递归归并排序
                  merge(array, auxArray, low, dividedIndex, high); // 合并分治结果
             }
        }

        private void merge(int[] array, int[] auxArray, int low, int dividedIndex, int high) {
             int i = low; // 指向左半分区数组的指针
             int j = dividedIndex + 1; // 指向右半分区数组的指针
             int auxPtr = 0; // 指向辅助区数组的指针
             // 合并两个有序数组：array[low..dividedIndex]与array[dividedIndex+1..high]。
             while (i <= dividedIndex && j <= high) { // 将两个有序的数组合并，排序到辅助数组auxArray中
                  if (array[i] > array[j]) { // 左侧数组array[low..dividedIndex]中的array[i]大于右侧数组array[dividedIndex+1..high]中的array[j]
                       auxArray[auxPtr++] = array[j++];
                  } else {
                       auxArray[auxPtr++] = array[i++];
                  }
             }
             // 如果array[low..dividedIndex].length>array[dividedIndex+1..high].length，经过上面合并
             // array[low..dividedIndex]没有合并完，则直接将array[low..dividedIndex]中没有合并的元素复制到辅助数组auxArray中去
             while (i <= dividedIndex) {
                  auxArray[auxPtr++] = array[i++];
             }
             // 如果array[low..dividedIndex].length<array[dividedIndex+1..high].length，经过上面合并
             // array[dividedIndex+1..high]没有合并完，则直接将array[dividedIndex+1..high]中没有合并的元素复制到辅助数组auxArray中去
             while (j <= high) {
                  auxArray[auxPtr++] = array[j++];
             }
             // 最后把辅助数组auxArray的元素复制到原来的数组中去，归并排序结束
             for (auxPtr = 0, i = low; i <= high; i++, auxPtr++) {
                  array[i] = auxArray[auxPtr];
             }
        }
    public static void findX(int [] a,int  x)
    {
    	int n=a.length;
    	int i=0,
        j=n-1;
    	int b=0;
       while (i<j)
     {
    	int k=a[i]+a[j];
    	if (k==x) 
    		{
    		b=1;
    		break;
    		
    		}
    	else if (k<x) i++;
    	else j--;
    }
    if (b==0) 
    	System.out.println("n");
    else 
    	System.out.println("y");

    }
	public static void main(String[] args) {
	int[] a={1,5,4,6,7};
	ALG_2_3_7 b= new ALG_2_3_7();
	b.sort(a);
	System.out.println(Arrays.toString(a));
	findX(a, 6);
	
	}

}
