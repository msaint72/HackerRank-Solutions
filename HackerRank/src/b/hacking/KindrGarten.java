package b.hacking;

import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.INTERNAL;

public class KindrGarten {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] x = new int[n + 1];
		for (int x_i = 1; x_i < n + 1; x_i++) {
			x[x_i] = in.nextInt();
		}
		int[] counts = new int[n + 1];
		ArrayList<Integer> plus = new ArrayList<Integer>();
		if (n - x[1] > 0)
			plus.add(n - x[1]);
		for (int i = 2; i < n + 1; i++) {
			for (int k = plus.size() - 1; k >= 0; k--) {
				int val = plus.get(k);
				if (val > 0)
					counts[i]++;
				val--;
				if (val >= 0)
					plus.set(k, val);
			}
			if (x[i] > 0)
				plus.add(n - x[i]);
			for (int k = plus.size() - 1; k >= 0; k--) {
				if (plus.get(k) == 0)
					plus.remove(k);
			}
		}
		int idx = 1;
		while (!plus.isEmpty()) {
			for (int k = 0; k < plus.size(); k++) {
				int val = plus.get(k);
				if (val > 0)
					counts[idx]++;
				val--;
				if (val >= 0)
					plus.set(k, val);
			}
			idx = idx + 1;
			for (int k = plus.size() - 1; k >= 0; k--) {
				if (plus.get(k) == 0)
					plus.remove(k);
			}
		}
		int max = 0;
		idx = 1;
		for (int i = 1; i < n + 1; i++) {
			if (counts[i] > max) {
				max = counts[i];
				idx = i;
			}
		}
		System.out.println(idx);
	}

	// brute force: score: 3.27
	public static void main2(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] x = new int[n + 1];
		for (int x_i = 1; x_i < n + 1; x_i++) {
			x[x_i] = in.nextInt();
		}
		int[] counts = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			int j = i;
			int wait = 0;
			do {
				if (wait >= x[j])
					counts[i]++;
				wait++;
				j = j + 1;
				if (j == n + 1)
					j = 1;
			} while (j != i);
		}
		int max = 0;
		int idx = 0;
		for (int i = 1; i < n + 1; i++) {
			if (counts[i] > max) {
				max = counts[i];
				idx = i;
			}
		}
		System.out.println(idx);
	}

}
