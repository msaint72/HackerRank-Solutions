package alg.easy;

import java.util.Scanner;

public class PlusMinus {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int[] a=new int[N];
		for(int i=0;i<N;i++){
			a[i]=in.nextInt();
		}
		int countN=0;
		int countP=0;
		int count0=0;
		for(int i=0;i<N;i++){
			if(a[i]<0) countN++;
			if(a[i]>0) countP++;
			if(a[i]==0) count0++;
			
		}
		System.out.println((float)countP/N);
		System.out.println((float)countN/N);
		System.out.println((float)count0/N);
	}

}
