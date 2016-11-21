package imp.easy;

import java.util.Scanner;

public class StrangeCounter {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		long t=in.nextLong();
		long initial=3;
		
		long power=0;
		long tmp=1;
		long reset=0;
		while(tmp<=t){
			reset=(long)tmp;
			tmp=tmp+3* (long)Math.pow(2, power++);
		}
		power--;
		long value= 3*(long)Math.pow(2, power);
		long result=value-(t-reset);
		System.out.println(result);
	}
}
