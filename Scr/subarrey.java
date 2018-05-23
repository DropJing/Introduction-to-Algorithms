import java.lang.reflect.Array;
import java.util.*;  

public class subarrey {
	/*算法导论4.1.5最大子数组
	 * 1.当有正数时，最大值必须是从某一正数开始
	 * 开始后在以后数组中,记录出现的最大值
	 * 2.当数组全为负数，找出最大即可
	 * 
	 * 复杂度 O（n）
	 * 
	 */
	public static int MaxSubArrey(int [] a)
	{
		int temp=0;//中间变量
		int sum=0;//储存当前的最大值
		for(int i=0;i<a.length;i++)//遍历数组
		{
			temp+=a[i];
			if(temp>0)
			{
				if(temp>sum)
				{
					sum=temp;
				}
				
			}
			else 
			{
				temp=0;
				
			}
           			
		}
		return sum;
	}
    public static boolean JudgeAllNegative(int [] a)//判断是不是全是负数
    {
    	boolean flag=true;
    	for(int i=0;i<a.length;i++)
    	{
            if(a[i]>0)
            {
            	flag=false;
            }
    	}
    	return flag;
    }
	public static void main(String[] args) {
		int [] a= {-1,-2,-4,-5};
		if(JudgeAllNegative(a))
		{
			Arrays.sort(a);//全是负数的话，排序，输出最大值
			System.out.println(a[a.length-1]);
		}
		else
		{
		System.out.println(MaxSubArrey(a));
		}
		

	}

}
