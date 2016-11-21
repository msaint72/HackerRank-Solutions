package imp.easy;

import java.util.Scanner;

public class AppleAndOrange {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int t = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int m = in.nextInt();
		int n = in.nextInt();
		int[] a_arr = new int[m];
		int[] b_arr = new int[n];
		for (int i = 0; i < m; i++) {
			a_arr[i] = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			b_arr[i] = in.nextInt();
		}
		int count_apples=0;
		for (int i = 0; i < m; i++) {
			if(a_arr[i]+a>=s && a_arr[i]+a<=t )
				count_apples++;
		}
		int count_oranges=0;
		for (int i = 0; i < n; i++) {
			if(b_arr[i]+b>=s && b_arr[i]+b<=t )
				count_oranges++;
		}
		System.out.println(count_apples);
		System.out.println(count_oranges);
	}

}
