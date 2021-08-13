package Stack;

import java.util.*;
class MABM2{
public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();
	while(t-->0){
		int m=sc.nextInt();
		int n=sc.nextInt();
		int[][] a=new int[50][50];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				a[i][j]=sc.nextInt();
		GfG g=new GfG();
		
		System.out.println(g.maxArea(a,m,n));
	    }
        sc.close();
    }
}

class GfG{
    public int maxArea(int arr[][],int m,int n){
        
        	int area=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			int[] arr1=new int[arr.length];
			for(int j=0;j<arr.length;j++)
			{
				if(i!=0&&arr[i][j]!=0)
				{
					arr[i][j]=arr[i][j]+arr[i-1][j];
				}
				arr1[j]=arr[i][j];
			}
			area=Math.max(area, areahistogram(arr1));
		}
		return area;
    }
	
	public int areahistogram(int[] arr)
	{
		Stack<Integer> index=new Stack<>();
		int lb=0;
		int rb=0;
		int cindex=0;
		int area=Integer.MIN_VALUE;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			while(!index.isEmpty()&&arr[i]<arr[index.peek()])
			{
				rb=i;
				cindex=index.pop();
				if(index.isEmpty())
				{
					lb=-1;
				}
				else
				{
					lb=index.peek();
				}
				area=arr[cindex]*(rb-lb-1);
				max=Math.max(area, max);
			}
			index.push(i);
		}
		while(!index.isEmpty())
		{
			rb=arr.length;
			cindex=index.pop();
			if(index.isEmpty())
			{
				lb=-1;
			}
			else
			{
				lb=index.peek();
			}
			area=arr[cindex]*(rb-lb-1);
			max=Math.max(area, max);
		}
		return max;
	}
}
