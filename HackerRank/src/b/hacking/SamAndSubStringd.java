package b.hacking;

import java.util.Scanner;

public class SamAndSubStringd {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String input=in.next();
		printSubTotal(input);

	}

	private static void printSubTotal(String input) {
		int N=input.length();
		long digit=1;
		long total=0;
		long factor=1;
		for(int i=1;i<=N;i++){
			int number=getNumber(input.charAt(N-i));
			total=(total+(long)(N-i+1)*factor*(long)number)%1000000007L;
			digit=(digit*10)%1000000007L;
			factor=(factor+digit)%1000000007L;
		}
		System.out.println(total);
		
	}

	private static int getNumber(char c) {
		return Character.getNumericValue(c);
	}

}
