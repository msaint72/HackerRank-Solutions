package b.hacking;

import java.util.Scanner;

public class HikingSelfies {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int x=in.nextInt();
		printInfo(n,x);
	}

	private static void printInfo(int n, int x) {
		long required=(long)Math.pow(2, n)-1;
		if(required>x){
			System.out.println(required-x);
		} else {
			System.out.println(x-required);			
		}
		
	}

}
