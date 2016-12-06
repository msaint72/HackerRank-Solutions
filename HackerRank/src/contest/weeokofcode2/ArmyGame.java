package contest.weeokofcode2;

import java.util.Scanner;

public class ArmyGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if(n%2==1) n=n+1;
        if(m%2==1) m=m+1;

        System.out.println(n*m/4);
    }
   
}
