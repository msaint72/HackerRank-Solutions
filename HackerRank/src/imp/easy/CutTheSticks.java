package imp.easy;

import java.util.Arrays;
import java.util.Scanner;

public class CutTheSticks {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		int size = arr.length;
		int index = 0;
		while (size > 0) {
			System.out.println(size);
			int count = 0;
			while (index + count < N && arr[index] == arr[index + count]) {
				count++;
			}
			size -= count;
			index += count;
			count = 0;
		}
	}
}
