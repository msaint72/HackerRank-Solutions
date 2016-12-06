package imp.easy;

import java.util.Scanner;

public class DesignerPDFViewer {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 26;
        int h[] = new int[n];
        for(int h_i=0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int max_height=0;
        for(int i=0;i<word.length();i++){
            if(h[word.charAt(i)-'a']>max_height)
                max_height=h[word.charAt(i)-'a'];
        }
        System.out.print(max_height*word.length());
    }
}
