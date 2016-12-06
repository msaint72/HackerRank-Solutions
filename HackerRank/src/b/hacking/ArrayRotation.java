package b.hacking;

import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        a=rotateArray(a,k);
        for(int item:a){
        	System.out.print(item +" ");
        }
    }

	private static int[] rotateArray(int[] a, int k) {
		int N=a.length;
		int[] newArray =new int[N];
		for(int i=0;i<N;i++){
			int newIndex;
			if(k>i){
				newIndex=N-(k-i);
			} else {
				newIndex=i-k;
			}
			newArray[newIndex]=a[i];
		}
		return newArray;
	}
}
