package b.hacking;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class StringConstruction {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int a0 = 0; a0 < n; a0++) {
			String s = in.next();
			int cost=stringCost(s);
			System.out.println(cost);
		}
	}

	private static int stringCost(String s) {
		LinkedHashSet<Character> p=new LinkedHashSet<Character>();
		String result=new String();
		int cost=0;
		for(int i=0;i<s.length();i++){
			if(!p.contains(s.charAt(i))){
				cost++;
			}
			p.add(s.charAt(i));
		}
		return cost;
	}

}
