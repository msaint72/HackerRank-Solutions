package b.hacking;

import java.math.BigInteger;
import java.util.Scanner;

public class ModifiedFibonacci {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t1=in.nextInt();
		int t2=in.nextInt();
		int n=in.nextInt();
		
		fibonacci(t1,t2,n);
	}

	private static void fibonacci(int first, int second, int n) {
		BigInteger result=new BigInteger(new Integer(0).toString());
		BigInteger t1=new BigInteger(new Integer(first).toString());
		BigInteger t2=new BigInteger(new Integer(second).toString());
		for(int i=3;i<=n;i++){
			result=t1.add(t2.pow(2));
			t1=t2;
			t2=result;
		}
		System.out.println(result);
		
	}
}
