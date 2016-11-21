package imp.easy;

import java.util.HashMap;
import java.util.Scanner;

public class NonDivisibleSubset {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
		}
		HashMap<Integer, Integer> remainders=new HashMap<Integer,Integer>();
		for(int i=0;i<n;i++){
			int remainder=a[i]%k;
			remainders.put(remainder, remainders.getOrDefault(remainder, 0)+1);
		}
		int result=Math.min(remainders.getOrDefault(0, 0),1);
		int i=1;
		for(;2*i<k;i++){
			int max=Math.max(remainders.getOrDefault(i, 0), remainders.getOrDefault(k-i, 0));
			result+=max;
		}
		if(k%2==0) result++;
		System.out.println(result);
	}

}
