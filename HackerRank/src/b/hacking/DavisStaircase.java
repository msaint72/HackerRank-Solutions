package b.hacking;

import java.util.HashMap;
import java.util.Scanner;

public class DavisStaircase {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] A = new int[s];
		for (int i = 0; i < s; i++) {
			A[i] = in.nextInt();
		}
		
		//a(n)=a(n-1)+a(n-2)+a(n-3)
		int max=0;
		for(int i=0;i<s;i++){
			if(A[i]>max) max=A[i];
		}
		int[] totals=new int[max+1];
		totals[0]=1;
		if(max>2) totals[1]=1;
		if(max>3) totals[2]=2;
		int lastCalculated=2;
		for (int i = 0; i < s; i++) {
			if(A[i]>lastCalculated){
				calculateTo(totals,lastCalculated,A[i]);
				lastCalculated=A[i];
			}
			System.out.println(totals[A[i]]);
		}

	}

	private static void calculateTo(int[] totals,int lastCalculated, int next) {
		for(int i=lastCalculated+1;i<=next;i++){
			totals[i]=totals[i-1]+totals[i-2]+totals[i-3];
		}
		
	}

	public static void mainRecursion(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] A = new int[s];
		for (int i = 0; i < s; i++) {
			A[i] = in.nextInt();
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < s; i++) {
			int result;
			if (map.containsKey(A[i]))
				result = map.get(A[i]);
			else
				result = stepCount(A[i], 0, 0);
			map.put(A[i], result);
			System.out.println(result);
		}

	}

	private static int stepCount(int height, int step, int current) {
		if (current - step >= height)
			return 0;
		if (current > height)
			return 0;
		if (current == height)
			return 1;
		int count = 0;
		count += stepCount(height, 1, current + 1);
		count += stepCount(height, 2, current + 2);
		count += stepCount(height, 3, current + 3);

		return count;
	}

}
