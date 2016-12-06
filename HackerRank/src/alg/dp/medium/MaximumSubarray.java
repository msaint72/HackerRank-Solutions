package alg.dp.medium;

import java.util.Scanner;

public class MaximumSubarray {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			int N = in.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = in.nextInt();
			}
			int max_curr = 0;
			int max = Integer.MIN_VALUE;
			int uncont_max = 0;
			if (arr[0] < 0)
				uncont_max = arr[0];
			for (int i = 0; i < arr.length; i++) {
				max_curr = Math.max(arr[i], max_curr + arr[i]);
				max = Math.max(max, max_curr);
				if (arr[i] > 0) {
					if (uncont_max < 0)
						uncont_max = 0;
					uncont_max += arr[i];
				} else if (arr[i] > uncont_max)
					uncont_max = arr[i];
			}
			System.out.println(max + " " + uncont_max);
		}
	}
}
