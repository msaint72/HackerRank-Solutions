package contest.weeokofcode2;

import java.util.Scanner;

public class HardHomework {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=3;i<1000;i++)
		maxTriple(i);
	}

	private static void maxTriple(int n) {
		double[] sin = new double[n];
		for (int i = 1; i < n; i++) {
			sin[i] = Math.sin(i);
		}
		double result = 0.000000000;
		for (int i = 1; i < n; i++) {
			for (int j = 1; i + j <= 10000; j++) {
				int z = n - i - j;
				if (z > 0) {
					double sum = Math.round((sin[i] + sin[j] + sin[z]) * 1000000000.0) / 1000000000.0;
					result = Math.max(result, sum);

				}
			}
		}
		result = Math.round(result * 1000000000.0) / 1000000000.0;
		System.out.println(result);
	}
}
