package contest.weeokofcode2;

import java.util.Arrays;
import java.util.Scanner;

public class TastesLikeWinning {
	public static class CombIndex{
		int index=0;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int max = new Long(((long) Math.pow(2, m) - 1L) % 1000000007L).intValue();
		int combination = findCombination(max, n);
		int factorial = factorial(n);
		int all;
		long tmp = 1;
		int tmp2 = max;
		for (int i = 0; i < n; i++) {
			tmp = tmp * tmp2;
			tmp = tmp % 1000000007;
			tmp2--;
		}
		all = new Long(tmp).intValue();
		if (n == 2) {
			long value = max * (max - 1) % 1000000007;
			System.out.println(value);
			return;
		}
		int total = 0;
		int number = max;
		int[] arr = new int[max];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = number;
			number--;
		}
		int[][] combinations = new int[combination][n];
		findCombinations(arr, max, n, combinations);

		for (int i = 0; i < combinations.length; i++) {
			int[] nimsum = new int[n];
			for (int j = 0; j < combinations[0].length; j++) {
				setNimSum(nimsum, combinations[i][j]);
			}
			if (checkNimSum(nimsum)) {
				total = (total + factorial) % 1000000007;
			}
		}
		System.out.println(total);

	}

	private static void findCombinations(int[] arr, int max, int n, int[][] combinations) {
		int[] tempData=new int[n];
		combinationUtil(arr, combinations, tempData,0, max - 1, 0, n, new CombIndex());

	}

	private static void combinationUtil(int[] arr, int[][] combinations, int[] tempData,int start, int end, int index, int n,
			CombIndex combindex) {
		if (index == n) {
			for (int i = 0; i < n; i++){
				//System.out.print(tempData[i]);
				combinations[combindex.index][i]=tempData[i];
			}
			//System.out.println();
			combindex.index++;
			return;
		}
		for (int i = start; i <= end && end - i + 1 >= n - index; i++) {
			tempData[index] = arr[i];
			combinationUtil(arr, combinations, tempData,i + 1, end, index + 1, n, combindex);
		}

	}

	private static int findCombination(int max, int n) {
		// max!/(n!(max-n)!
		int bigger = Math.max(n, max - n);
		int smaller = Math.min(n, max - n);
		long result = 1;
		for (int i = max; i > bigger; i--) {
			result = result * i;
		}
		for (int i = smaller; i > 1; i--)
			result = result / i;
		return new Long(result).intValue();
	}

	private static int factorial(int n) {
		long result = 1;
		for (int i = 2; i <= n; i++)
			result = result * i % 1000000007;
		return new Long(result).intValue();
	}

	private static boolean checkNimSum(int[] nimsum) {
		for (int i = 0; i < nimsum.length; i++)
			if (nimsum[i] == 1)
				return true;
		return false;
	}

	public static void setNimSum(int[] nimsum, int value) {
		int digit = 0;
		while (value > 0) {
			nimsum[digit] = (nimsum[digit] + value & 1) % 2;
			digit++;
			value = value >> 1;
		}
	}
}
