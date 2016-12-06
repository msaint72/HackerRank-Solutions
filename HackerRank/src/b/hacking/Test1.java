package b.hacking;

import java.util.Scanner;

public class Test1 {
	  public static boolean checkX_function(int Ax, int [] b){
	        for(int i=0; i<b.length; i++){
	            if(b[i]%Ax!=0){
	                return false;
	            }
	        }
	        return true;
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt(); // n: length of array A
	        int m = in.nextInt(); // m: length of array B
	        int[] a = new int[n];
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	        }
	        int[] b = new int[m];
	        for(int b_i=0; b_i < m; b_i++){
	            b[b_i] = in.nextInt();
	        }

	        boolean checkX = false;
	        int count=0;
	        for(int i=0; i<n; i++){            
	            for(int j=i; j<n; j++){
	                int Ax = 0;
	                Ax = a[i]*a[j];
	                //check if Ax is satisfied for all elements in B
	                checkX = checkX_function(Ax, b);
	                if (checkX == true){
	                    count++;
	                }
	            }
	        }
	        System.out.println(count);
	    }
}
