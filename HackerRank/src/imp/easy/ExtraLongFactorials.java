package imp.easy;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		BigInteger number = new BigInteger(new Integer(N).toString());
		BigInteger result = new BigInteger("1");
		for (int i = 2; i <= N; i++) {
			BigInteger next = new BigInteger(new Integer(i).toString());
			result = result.multiply(next);
		}
		System.out.println(result);
	}
}
