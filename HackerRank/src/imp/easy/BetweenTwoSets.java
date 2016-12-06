package imp.easy;

import java.util.Scanner;

public class BetweenTwoSets {
	/*****************************************************
	 * lcm(a,b)=a*b/gcd(a,b)
	 *
	 * static int gcd(int a, int b){ if(b==0) return a; return gcd(b,a%b); }
	 ******************************************************/

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int[] b = new int[m];
		for (int b_i = 0; b_i < m; b_i++) {
			b[b_i] = in.nextInt();
		}
		int lcm = lcm(a);
		int gcd = gcd(b);
		int count = 0;
		int lcm_multiples = lcm;
		while (lcm_multiples <= gcd) {
			if (gcd % lcm_multiples == 0)
				// System.out.print(lcm+" ");
				count++;
			lcm_multiples += lcm;
		}
		System.out.println(count);
	}

	static int lcm(int[] a) {
		int result = a[0];
		if (a.length == 1)
			return result;
		for (int i = 1; i < a.length; i++) {
			int number = a[i];
			result = result * number / gcd(result, number);
		}
		return result;
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	static int gcd(int[] b) {
		int result = b[0];
		if (b.length == 1)
			return result;
		for (int i = 1; i < b.length; i++) {
			int number = b[i];
			result = gcd(result, number);
		}
		return result;
	}
}
