package imp.easy;

import java.util.Scanner;

public class FlatLandSpaceStattion {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		boolean[] c = new boolean[n];
		for (int i = 0; i < m; i++) {
			int tmp = in.nextInt();
			c[tmp] = true;
		}
		int[] lcounts = new int[n];
		int[] rcounts = new int[n];
		int lc = 0, rc = 0;
		boolean lf = false;
		boolean rf = false;
		for (int i = 0; i < n; i++) {
			if (c[i]) {
				lc = 0;
				lf = true;
			} else {
				lc++;
			}
			if (lf)
				lcounts[i] = lc;
			else
				lcounts[i] = Integer.MAX_VALUE;

			if (c[n - 1 - i]) {
				rc = 0;
				rf = true;
			} else {
				rc++;
			}
			if (rf)
				rcounts[n - 1 - i] = rc;
			else
				rcounts[n - 1 - i] = Integer.MAX_VALUE;
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			int value = Math.min(lcounts[i], rcounts[i]);
			max = Math.max(value, max);
		}
		System.out.println(max);
	}
}
