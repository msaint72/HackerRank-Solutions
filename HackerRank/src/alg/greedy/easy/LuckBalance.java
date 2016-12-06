package alg.greedy.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LuckBalance {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int luck_balance = 0;
		ArrayList<Integer> important_contests = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			int amount = in.nextInt();
			int importance = in.nextInt();
			luck_balance += amount;
			if (importance == 1) {
				important_contests.add(amount);
			}
		}
		Collections.sort(important_contests);
		for (int i = 0; i < important_contests.size() - K; i++) {
			luck_balance = luck_balance - 2 * important_contests.get(i);
		}
		System.out.println(luck_balance);
	}
}
