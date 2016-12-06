package contest.weeokofcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Twins {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int count = 0;
		ArrayList<Integer> primes = getBasicPrimes(m);
		int previous_prime=0;
		for (int i = n; i <= m; i++) {
			int j = 0;
			boolean prime = true;
			while (j < primes.size() && prime) {
				int primeN=primes.get(j);
				if (i %  primeN == 0 && i!=primeN) {
					prime = false;
				}
				j++;
			}
			if(prime){
				if(i-previous_prime==2)
					count++;
				previous_prime=i;
			}
		}
		System.out.println(count);
	}

	private static ArrayList<Integer> getBasicPrimes(int m) {
		int sieve_length = (int) Math.sqrt(m) + 1;
		boolean[] sieve = new boolean[sieve_length + 1];
		Arrays.fill(sieve, true);
		sieve[0] = false;
		sieve[1] = false;
		for (int i = 2; i < sieve_length; i++) {
			if (sieve[i]) {
				int k = i + i;
				while (k <= sieve_length) {
					sieve[k] = false;
					k = k + i;
				}
			}
		}
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < sieve.length; i++) {
			if (sieve[i])
				primes.add(i);
		}
		return primes;
	}

	private static Set<Integer> getPrimes(int n, int m) {
		int sieve_length = (int) Math.sqrt(m) + 1;
		boolean[] sieve = new boolean[sieve_length + 1];
		Arrays.fill(sieve, true);
		sieve[0] = false;
		sieve[1] = false;
		for (int i = 2; i < sieve_length; i++) {
			if (sieve[i]) {
				int k = i + i;
				while (k <= sieve_length) {
					sieve[k] = false;
					k = k + i;
				}
			}
		}

		boolean[] partial_sieve = new boolean[m - n + 1];
		Arrays.fill(partial_sieve, true);
		Set<Integer> primes = new HashSet<Integer>();
		for (int i = 2; i < sieve.length; i++) {
			if (sieve[i]) {
				int start = n / i;
				start = start * i;
				while (start <= m) {
					if (start >= n)
						partial_sieve[start - n] = false;
					start += i;
				}
			}
		}

		for (int i = 0; i < partial_sieve.length; i++) {
			if (partial_sieve[i]) {
				primes.add(i + n);
			}
		}
		return primes;
	}
}
