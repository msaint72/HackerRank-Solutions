package contest.weeokofcode2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SatisfactoryPairs {
	private static class Pair {
		int a;
		int b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public String toString() {
			return "(" + a + "-" + b + ")";
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Pair) {
				Pair compareTo = (Pair) o;
				return (this.a == compareTo.a && this.b == compareTo.b)
						|| (this.a == compareTo.b && this.b == compareTo.a);
			}
			return false;
		}

		@Override
		public int hashCode() {
			int result = 37;
			result = result * 37 + a;
			result = result * 37 + b;
			return result;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Set<Pair> pairs = new HashSet<Pair>();
		for (int a = 1; a <= n / 2; a++) {
			for (int b = a + 1; a + b <= n; b++) {
				int x = 1;
				while (a * x < n) {
					int y = (n - a * x) / b;
					if (a * x + y * b == n && a != b) {
						pairs.add(new Pair(a, b));
					}
					x++;
				}
			}
		}
		// for (Object pair : pairs.toArray()) {
		// System.out.println((Pair) pair);
		// }
		System.out.println(pairs.size());
	}

}
