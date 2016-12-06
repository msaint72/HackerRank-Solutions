package imp.easy;

import java.util.Scanner;

public class SherlockAndSquares {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int n1 = in.nextInt();
			int n2 = in.nextInt();
			int count = 0;
			// int nr=nearestRoot(n1);
			int nr = (int) Math.sqrt(n1);
			if (nr * nr == n1)
				count++;
			nr++;
			while (nr * nr <= n2) {
				count++;
				nr++;
			}
			System.out.println(count);
		}
	}

	public static int nearestRoot(int n) {
		int nr = 1;
		for (int i = 1; i <= n / 2; i++) {
			if (i * i < n)
				nr = i;
		}
		return nr;
	}
}
