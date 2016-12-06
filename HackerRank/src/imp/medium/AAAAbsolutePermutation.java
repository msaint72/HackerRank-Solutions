package imp.medium;

import java.util.Scanner;

public class AAAAbsolutePermutation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int k = in.nextInt();
			if (k != 0 && (n < 2 * k || n % k != 0)) {
				System.out.print("-1");
			} else if (k == 0) {
				for (int i = 1; i <= n; i++)
					System.out.print(i + " ");
			} else {
				for (int i = 1; i < n; i += 2 * k) {
					for (int j = 0; j < k; j++) {
						System.out.print((i + k + j) + " ");
					}
					for (int j = 0; j < k; j++) {
						System.out.print((i + j) + " ");
					}
				}
			}
			System.out.println();
		}
	}
}
