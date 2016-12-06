package b.hacking;

import java.util.Scanner;

public class MiniMaxSum {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int a = in.nextInt();
	        int b = in.nextInt();
	        int c = in.nextInt();
	        int d = in.nextInt();
	        int e = in.nextInt();
	        int min=Math.min(a, Math.min(b,Math.min(c,Math.min(d,e))));
	        int max=Math.max(a, Math.max(b,Math.max(c,Math.max(d,e))));
	        long sum=(long)a+(long)b+(long)c+(long)d+(long)e;
	        System.out.print((sum-max)+ " "+(sum-min));
	    }
}
