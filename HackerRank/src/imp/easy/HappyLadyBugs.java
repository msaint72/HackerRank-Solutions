package imp.easy;

import java.util.Arrays;
import java.util.Scanner;

public class HappyLadyBugs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// number of games
		int g = in.nextInt();
		// for each game
		for (int i = 0; i < g; i++) {
			// number of cells on the board
			int n = in.nextInt();
			// get the board cells
			String b = in.next();
			int[] evens = new int[26];
			boolean empty = false;
			boolean inOrder = true;
			char prev = '0';
			int countSame = 0;
			for (int j = 0; j < b.length(); j++) {
				char c = b.charAt(j);
				if (c >= 'A' && c <= 'Z')
					evens[c - 65] += 1;
				else
					empty = true;
				if (prev != '0' && prev != c) {
					if (countSame == 1)
						inOrder = false;
					countSame = 1;
				} else
					countSame++;
				prev = c;
			}
			if (empty || n == 1) {
				boolean oddExists = false;
				for (int k = 0; k < 26; k++) {
					if (evens[k] == 1)
						oddExists = true;
				}
				if (oddExists)
					System.out.println("NO");
				else
					System.out.println("YES");
			} else {
				if (!inOrder || (countSame==1))
					System.out.println("NO");
				else
					System.out.println("YES");

			}

		}
	}

}
