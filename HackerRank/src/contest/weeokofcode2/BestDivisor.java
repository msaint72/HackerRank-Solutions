package contest.weeokofcode2;

import java.util.Scanner;

public class BestDivisor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int divisor = 2;
		int best = 1;
		int largestSum = 1;
		while (divisor <= n / 2) {
			if (n % divisor == 0) {
				int tmpSum = sum(divisor);
				if (tmpSum > largestSum) {
					largestSum = tmpSum;
					best = divisor;
				}
			}
			divisor++;
		}
		if (sum(n) > largestSum)
			best = n;
		System.out.println(best);
	}

	public static int sum(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number = number / 10;
		}
		return sum;
	}
}
