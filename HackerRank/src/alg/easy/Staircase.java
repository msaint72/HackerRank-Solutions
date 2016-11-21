package alg.easy;

import java.util.Arrays;
import java.util.Scanner;

public class Staircase {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] a = new int[N];

		char[] spaces = new char[N - 1];
		Arrays.fill(spaces, ' ');
		String sp_str = new String(spaces);
		String sharp_str = "#";
		for (int i = 0; i < N; i++) {
			System.out.println(sp_str + sharp_str);
			if (sp_str.length() > 0)
				sp_str = sp_str.substring(1);
			sharp_str = sharp_str + '#';
		}

	}

}
