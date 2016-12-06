package contest.weeokofcode2;

import java.util.Scanner;

/*
6
7 12 14 16 20 22
16 2 4
 */
public class MusicOnTheStreet {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		int m = in.nextInt();
		int hmin = in.nextInt();
		int hmax = in.nextInt();
		int start = 0;
		int total = 0;
		for (int i = 0; i < n - 1; i++) {
			int dist = a[i + 1] - a[i];
			if (dist > hmax) {
				if (start == 0) {
					if (m - total <= 2 * hmax) {
						System.out.println(a[0] - (m - total - hmax));
						return;
					}
				} else {
					if (m - total < hmin && a[start + 1] - a[start] >= hmin) {
						System.out.println((a[start + 1] - hmin));
						return;
					} else if (m - total <= 2 * hmax && a[start] - a[start - 1] >= (m - total - hmax)) {
						System.out.println(a[start] - (m - total - hmax));
						return;
					}
				}
			}
			if (dist < hmin) {
				if (start == 0) {
					if (m - total <= hmax) {
						System.out.println(a[0] - (m - total - hmax));
						return;
					}
				} else {
					if (m - total <= hmax && a[start] - a[start - 1] >= (m - total - hmax)) {
						System.out.println(a[start] - (m - total - hmax));
						return;
					}
				}
			}
			if (dist > hmax || dist < hmin) {
				start = i + 1;
				total = 0;
				continue;
			} else {
				total += dist;
			}
			if (total >= m) {
				System.out.println(start);
				return;
			}
			if (m - total <= hmax) {
				if (start == 0) {
					System.out.println(a[0] - (m - total));
					return;
				}
			}
		}
		if (start == 0) {
			int tmp = m - total;
			if (tmp <= hmax) {
				System.out.print(a[0] - tmp);
			} else if (tmp >= hmin * 2 && tmp <= 2 * hmax) {
				System.out.print(a[0] - tmp / 2);
			}
		} else {
			int tmp = m - total;
			// System.out.println(tmp+"-"+hmax);
			if (tmp <= hmax) {
				System.out.print(a[start]);
			} else if (tmp < hmax + hmin) {
				System.out.println("Error:1");
			} else if (tmp >= hmin + hmax && tmp <= 2 * hmax) {
				System.out.print(a[start] - (m - total - hmax));
			}
		}

	}
}