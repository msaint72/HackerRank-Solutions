package b.hacking;

import java.util.Scanner;

public class DigitMinMaxScores {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long A = in.nextLong();
		long B = in.nextLong();

		long total = 0;
		for (long i = A; i <= B; i++) {
			total = total + minMax(i);
		}
		System.out.println(total);
	}

	private static long minMax(long n) {
		String s=Long.toString(n);
		int prev=0;
		int next=0;
		long count=0;
		for(int i=0;i<s.length();i++){
			int digit=Character.getNumericValue(s.charAt(i));
			if(i!=0 && i!=s.length()-1){
				next=Character.getNumericValue(s.charAt(i+1));
				if((digit<prev && digit<next) || (digit>prev && digit>next)){
					count++;
				}
			}
			prev=digit;
		}
		return count;
	}

}
