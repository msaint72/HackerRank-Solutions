package imp.easy;

import java.util.Scanner;

public class UtopianTree {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int n = in.nextInt();
			long result = 1;
			for (int j = 1; j <= n; j++) {
				if (j % 2 == 1) {
					result *= 2;
				} else {
					result += 1;
				}
			}
			System.out.println(result);
		}
	}
}
