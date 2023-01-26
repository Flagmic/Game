package package3;
import java.util.Scanner;
public class Class3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		boolean a=true;

//		zad1 a)
		for (int i=0;i>n+1;i++)
		{
			System.out.println(i*i*2);
		}

//		zad2 b)
		for (int i=2;i<=n;i++)
		{
			for(int j=i-1;j>=2;j--)
			{
				if(i%j==0)
				{
					a=false;
					break;
				}
			}
			if(a==true)
				System.out.println(i);
			a = true;
		}
		
//		zad3 c)
		for(int i=2;i<n;i++){
			for(int j=2;j<=i;j++){
				if(n%j==0 && i%j==0)
				a=false;
			}
			if(a==true)
			System.out.println(i);
		a = true;
		}
		
//		zad4 d)
		int d=1;
		int d1=0;
		int d2=1;
		System.out.println(0);
		for(int i=1;i<n;i++){
		System.out.println(d);
		d=d1+d2;
		d1=d2;
		d2=d;
		}
		scan.close();
}
}
