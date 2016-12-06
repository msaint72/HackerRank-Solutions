package b.hacking;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class CountProgressions {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = in.nextInt();
		}
		arithmeticProgressionsBF(A);

	}

	private static void arithmeticProgressions(int[] a) {
		long total = 1 + a.length;
		int n = a.length;
		// if (n > 1)
		// total += komb(n, 2) % 1000000009;
		// subtract 1 if length=2 or all set is in progressin
//		if (n == 2) {
//			total = total - 1;
//		} else {
//			int tmpD = a[1] - a[0];
//			int tmpI = 2;
//			while (tmpI < n && a[tmpI] - a[tmpI - 1] == tmpD) {
//				tmpI++;
//			}
//			if (tmpI == n)
//				total = total - 1;
//		}
		// count
		for (int i = 0; i < n; i++) {
			HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer, Integer>>();// diff
			for (int j = i + 1; j < n; j++) {
				total = (total + 1) % 1000000009;
				int diff = a[i] - a[j];
				// check if this is in waiting list
				if (map.containsKey(a[j])) {
					int newWait = a[j] - diff;
					HashMap diff_value = map.get(a[j]);
					if (diff_value.containsKey(diff)) {
						int sum = (int) diff_value.get(diff);
						total = (total + sum) % 1000000009;
						if (diff != 0) {
							diff_value.remove(diff);
							if (map.containsKey(newWait)) {
								HashMap<Integer, Integer> tmpH = map.get(newWait);
								tmpH.put(diff, tmpH.getOrDefault(diff, 0) + sum);
							} else {
								HashMap<Integer, Integer> tmpH = new HashMap<Integer, Integer>();
								tmpH.put(diff, sum);
								map.put(newWait, tmpH);
							}
						}
					}
				}
				int waiting_val = a[j] - diff;
				if (map.containsKey(waiting_val)) {
					HashMap<Integer, Integer> tmpHM = map.get(waiting_val);
					tmpHM.put(diff, tmpHM.getOrDefault(diff, 0) + 1);
				} else {
					HashMap<Integer, Integer> tmpHM = new HashMap<Integer, Integer>();
					tmpHM.put(diff, 1);
					map.put(waiting_val, tmpHM);
				}

			}
		}
		System.out.println(total);

	}
	
	private static void arithmeticProgressionsBF(int[] a) {
		long total=1+a.length;
		int n=a.length;
		//if(n>1) total+=komb(n,2)%1000000009;
		if (n == 2) {
			total = total - 1;
		} else {
			int tmpD = a[1] - a[0];
			int tmpI = 2;
			while (tmpI < n && a[tmpI] - a[tmpI - 1] == tmpD) {
				tmpI++;
			}
			if (tmpI == n)
				total = total - 1;
		}
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				total=(total+1)%1000000009;
				int diff=a[i]-a[j];
				for(int k=j+1;k<n;k++){
					if(a[j]-a[k]==diff){
						total=(total+1)%1000000009;
					}
				}
			}
		}
		System.out.println(total);
		
	}

	private static long komb(int n, int m) {
		BigInteger result = BigInteger.valueOf(1);
		for (int i = 0; i < n; i++)
			result = result.multiply(BigInteger.valueOf(n - i));
		result = result.divide(BigInteger.valueOf(2));
		for (int i = 0; i < (n - 2); i++)
			result = result.divide(BigInteger.valueOf(n - 2 - i));
		return result.longValue();
	}

}
