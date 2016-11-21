package imp.easy;

import java.util.Scanner;

public class AngryProfessor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int N = in.nextInt();
			int K = in.nextInt();
			int total = 0;
			for (int j = 0; j < N; j++) {
				int ai = in.nextInt();
				if(ai<=0) 
					total++;
			}
			if(total>=K){
				System.out.println("NO");
			} else{
				System.out.println("YES");
			}
		}

	}

}
