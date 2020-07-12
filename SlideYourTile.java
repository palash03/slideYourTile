import java.util.*;

public class SlideYourTile
{
	public static void Display(int [][]x)
	{
		int flag = 0;
		for(int i=0;i<x.length;i++)
		{
			for(int j=0;j<x[i].length;j++)
			{
				if(x[i][j] == 2048)
					flag = 1;
				System.out.print(x[i][j] + "     ");
			}
			System.out.println();
		}
		System.out.println();
		int c = 0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(x[i][j] != 0)
					c++;
			}
		}
		if(c == 9)
		{
			System.out.println("You could not make it to 2048! Good luck next time");
		}
		if(flag == 1)
			System.out.println("Success!! You win");
	}
	
	public static void Initialize(int [][] x)
	{
		for(int i=0;i<x.length;i++)
		{
			for(int j=0;j<x[i].length;j++)
			{
				x[i][j] = 0;
			}
		}
	}
	
	public static void MoveUp(int [][]x, int m, int n)
	{
		int c = 0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(x[j][i] == x[j+1][i] || x[j][i] == 0)
				{
					x[j][i] += x[j+1][i];
					x[j+1][i] = 0;
				}
			}
		}
	}
	
	public static void MoveDown(int [][]x, int m, int n)
	{
		int c = 0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(x[j][i] == x[j+1][i] || x[j+1][i] == 0)
				{
					x[j+1][i] += x[j][i];
					x[j][i] = 0;
				}
			}
		}
	}
	
	public static void MoveRight(int [][]x, int m, int n)
	{
		int c = 0;
		for(int i=0;i<3;i++)
		{
			for(int j=2;j>0;j--)
			{
				if(x[i][j] == x[i][j-1] || x[i][j] == 0)
				{
					x[i][j] += x[i][j-1];
					x[i][j-1] = 0;
				}
			}
		}
	}
	
	public static void MoveLeft(int [][]x, int m, int n)
	{
		int c = 0;
		for(int i=0;i<3;i++)
		{
			for(int j=2;j>0;j--)
			{
				if(x[i][j] == x[i][j-1] || x[i][j-1] == 0)
				{
					x[i][j-1] += x[i][j];
					x[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) 
	{
		int x[][] = new int[3][3];
		Random rand = new Random();
		//int num = (int)rand.nextInt(4)+1;
		//System.out.print(num);
		Scanner myObj = new Scanner(System.in);
		Initialize(x);
		while(true)
		{
			int m = (int)rand.nextInt(3);
			int n = (int)rand.nextInt(3);
			int num = (int)rand.nextInt(4)+1;
			if(num % 2 != 0)
				continue;
			if(x[m][n] == 0)
			{
				x[m][n] = num;
				Display(x);
			}
			else
			{
				continue;
			}
			String ch = myObj.nextLine();
			switch(ch)
			{
				case "w":
				{
					MoveUp(x,m,n);
					break;
				}
				case "a":
				{
					MoveLeft(x,m,n);
					break;
				}
				case "d":
				{
					MoveRight(x,m,n);
					break;
				}
				case "s":
				{
					MoveDown(x,m,n);
					break;
				}
			}
		}
	}
}
