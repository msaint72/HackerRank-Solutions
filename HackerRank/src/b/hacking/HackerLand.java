package b.hacking;

import java.util.Arrays;
import java.util.Scanner;

public class HackerLand {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int[] x = new int[n];
	        for(int x_i=0; x_i < n; x_i++){
	            x[x_i] = in.nextInt();
	        }
	        Arrays.parallelSort(x);
	        int count=0;
	        int range_s=0;
	        int range_e=0;
	        for(int i=0;i<n;i++){
	        	if(range_e==0 || !(x[i]<= range_e && x[i]>=range_s)){
	        		count++;
	        		int putT=i;
	        		while(putT<n-1 && x[putT+1]<=x[i]+k){
	        			putT++;
	        		}
	        		range_s=x[i];
	        		range_e=x[putT]+k;
	        	}
	        }
	        System.out.println(count);
	    }
}
