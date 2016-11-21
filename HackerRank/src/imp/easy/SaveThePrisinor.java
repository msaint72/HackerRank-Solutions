package imp.easy;

import java.util.Scanner;

public class SaveThePrisinor {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		for(int i=1;i<T+1;i++){
			int N=in.nextInt();
			int M=in.nextInt();
			int S=in.nextInt();
			
			int poisoned;
			int total=S+(M%N)-1;
	
			if(total==N || total==0)
				poisoned=N;
			else
				poisoned=total%N;
			System.out.println(poisoned);
		}

	}

}
