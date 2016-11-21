package cci.easy;

import java.util.Hashtable;
import java.util.Scanner;

public class HashTablesRansomNote {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		String magazine[] = new String[m];
		Hashtable<String, Integer> hash1=new Hashtable<String,Integer>();
		for (int magazine_i = 0; magazine_i < m; magazine_i++) {
			magazine[magazine_i] = in.next();
			hash1.put(magazine[magazine_i], hash1.getOrDefault(magazine[magazine_i], 0)+1);
		}
		String ransom[] = new String[n];
		for (int ransom_i = 0; ransom_i < n; ransom_i++) {
			ransom[ransom_i] = in.next();
			if(hash1.containsKey(ransom[ransom_i])){
				int count=hash1.get(ransom[ransom_i]);
				if(count>1){
					hash1.put(ransom[ransom_i], count-1);
				} else {
					hash1.remove(ransom[ransom_i]);
				}
			} else {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");

	}
}
