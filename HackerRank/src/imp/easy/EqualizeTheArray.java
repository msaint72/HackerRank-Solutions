package imp.easy;

import java.util.Scanner;
import java.util.Stack;

public class EqualizeTheArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] a = new int[N];
		int[] counts = new int[101];
		for (int i = 0; i < N; i++) {
			a[i] = in.nextInt();
			counts[a[i]]++;
		}
		int max=0;
		for (int i = 1; i < 101; i++) {
			if(counts[i]>max)
				max=counts[i];
		}
		System.out.println(N-max);
	}

}
