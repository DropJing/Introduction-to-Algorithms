import javax.print.attribute.standard.PrinterLocation;

import java.lang.module.FindException;
import java.util.*;
public class ALG_2_3_7 {
        public  void sort(int[] array) {
             int[] auxArray = new int[array.length];
             mergeSort(array, auxArray, 0, array.length - 1);
        }

        /**
        * ���ڷ���˼�룬ִ�й鲢����
        * @param low �����������±��½�
        * @param high �����������±��Ͻ�
        */
        private void mergeSort(int[] array, int[] auxArray, int low, int high) {
             int dividedIndex = 0; // ����λ����������
             if (low < high) {
                  dividedIndex = (low + high) / 2; // �������λ��(���ü򵥵Ķ���˼��)
                  mergeSort(array, auxArray, low, dividedIndex); // ���ݹ�鲢����
                  mergeSort(array, auxArray, dividedIndex + 1, high); // �Ҳ�ݹ�鲢����
                  merge(array, auxArray, low, dividedIndex, high); // �ϲ����ν��
             }
        }

        private void merge(int[] array, int[] auxArray, int low, int dividedIndex, int high) {
             int i = low; // ָ�������������ָ��
             int j = dividedIndex + 1; // ָ���Ұ���������ָ��
             int auxPtr = 0; // ָ�����������ָ��
             // �ϲ������������飺array[low..dividedIndex]��array[dividedIndex+1..high]��
             while (i <= dividedIndex && j <= high) { // ���������������ϲ������򵽸�������auxArray��
                  if (array[i] > array[j]) { // �������array[low..dividedIndex]�е�array[i]�����Ҳ�����array[dividedIndex+1..high]�е�array[j]
                       auxArray[auxPtr++] = array[j++];
                  } else {
                       auxArray[auxPtr++] = array[i++];
                  }
             }
             // ���array[low..dividedIndex].length>array[dividedIndex+1..high].length����������ϲ�
             // array[low..dividedIndex]û�кϲ��꣬��ֱ�ӽ�array[low..dividedIndex]��û�кϲ���Ԫ�ظ��Ƶ���������auxArray��ȥ
             while (i <= dividedIndex) {
                  auxArray[auxPtr++] = array[i++];
             }
             // ���array[low..dividedIndex].length<array[dividedIndex+1..high].length����������ϲ�
             // array[dividedIndex+1..high]û�кϲ��꣬��ֱ�ӽ�array[dividedIndex+1..high]��û�кϲ���Ԫ�ظ��Ƶ���������auxArray��ȥ
             while (j <= high) {
                  auxArray[auxPtr++] = array[j++];
             }
             // ���Ѹ�������auxArray��Ԫ�ظ��Ƶ�ԭ����������ȥ���鲢�������
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
