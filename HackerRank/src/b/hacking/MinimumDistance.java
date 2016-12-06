package b.hacking;

import java.util.HashMap;
import java.util.Scanner;

public class MinimumDistance {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		int result = Integer.MAX_VALUE;
		boolean found=false;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int A_i = 0; A_i < n; A_i++) {
			A[A_i] = in.nextInt();
			if (map.containsKey(A[A_i])) {
				int index = map.get(A[A_i]);
				if (A_i - index < result) {
					result = A_i - index;
					found=true;
				}
			} else {
				map.put(A[A_i], A_i);
			}
		}
		System.out.println(found?result:"-1");
	}

}
