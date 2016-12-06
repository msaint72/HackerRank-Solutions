package bit.manipulation.easy;

import java.util.Scanner;

public class MaximizingXOR {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int max = 0;
		for (int i = n; i < m; i++) {
			for (int j = i + 1; j <= m; j++) {
				if (xor(i, j) > max)
					max = xor(i, j);
			}
		}
		System.out.println(max);
	}

	public static int xor(int a, int b) {
		int result = 0;
		int bit_index = 0;
		while (b >= 1 << bit_index) {
			// get bits
			int nth_bita = 1 << bit_index & a;
			int nth_bitb = 1 << bit_index & b;
			// xor
			int xor = nth_bita ^ nth_bitb;
			// set bit on result
			if (xor > 0)
				result = result | 1 << bit_index;
			bit_index += 1;
		}
		return result;
	}
}
