import java.lang.reflect.Array;
import java.util.*;  

public class subarrey {
	/*�㷨����4.1.5���������
	 * 1.��������ʱ�����ֵ�����Ǵ�ĳһ������ʼ
	 * ��ʼ�����Ժ�������,��¼���ֵ����ֵ
	 * 2.������ȫΪ�������ҳ���󼴿�
	 * 
	 * ���Ӷ� O��n��
	 * 
	 */
	public static int MaxSubArrey(int [] a)
	{
		int temp=0;//�м����
		int sum=0;//���浱ǰ�����ֵ
		for(int i=0;i<a.length;i++)//��������
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
    public static boolean JudgeAllNegative(int [] a)//�ж��ǲ���ȫ�Ǹ���
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
			Arrays.sort(a);//ȫ�Ǹ����Ļ�������������ֵ
			System.out.println(a[a.length-1]);
		}
		else
		{
		System.out.println(MaxSubArrey(a));
		}
		

	}

}
