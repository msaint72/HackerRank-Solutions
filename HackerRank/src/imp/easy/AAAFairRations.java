package imp.easy;

import java.util.Scanner;

public class AAAFairRations {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int B[] = new int[N];
		for (int B_i = 0; B_i < N; B_i++) {
			B[B_i] = in.nextInt();
		}
		int odd_count = 0;
		for (int i = 0; i < N; i++) {
			if (isOdd(B[i])) {
				odd_count++;
			}
		}
		if (isOdd(odd_count)) {
			System.out.println("NO");
			return;
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (isOdd(B[i])) {
				B[i]++;
				B[i + 1]++;
				count += 2;
			}
		}
		System.out.println(count);
	}

	public static boolean isOdd(int n) {
		if (n % 2 == 0)
			return false;
		return true;
	}

	public static boolean isEven(int n) {
		if (n % 2 != 0)
			return false;
		return true;
	}
}
