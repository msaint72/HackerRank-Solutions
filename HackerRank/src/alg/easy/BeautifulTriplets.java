package alg.easy;

import java.util.Scanner;

public class BeautifulTriplets {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = in.nextInt();
		}

		int i = 0;
		int j = 1;
		int k = 2;
		int count = 0;
		while (i < n - 2) {
			if (A[j] - A[i] == d && A[k] - A[j] == d) {
				count++;
				i++;
				j++;
				k++;
			} else if (A[j] - A[i] > d) {
				i++;
			} else if (A[j] - A[i] < d) {
				j++;
			} else {// A[j] - A[i] == d
				if (A[k] - A[j] > d) {
					j++;
				} else k++;
			}
			if (j == k)
				k++;
//			if(j==n-2){
//				i++;
//			}
			if(k>=n){
				if(j<n-2){
					j++;
					k=j+1;
				} else {
					i++;
					j=i+1;
					k=j+1;
				}
			}
		}
		System.out.println(count);
	}
}
