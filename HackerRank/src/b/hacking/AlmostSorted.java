package b.hacking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AlmostSorted {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\eren\\Desktop\\mahmut\\wokspace\\CrackingCodingInterview\\resources\\19.txt");
		Scanner in;
		try {
			in = new Scanner(file);
			int n = in.nextInt();
			int[] A = new int[n+1];

			for (int i = 1; i < n+1; i++) {
				A[i] = in.nextInt();
			}
			almostSorted(A);
	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void almostSorted(int[] a) {
		int N=a.length;
		int index = 2;
		int brokeCount = 0;
		int[] brokes=new int[N];
		if(isSorted(a)){
			System.out.println("yes");
			return;
		}
		while (index < a.length) {
			if(a[index]<a[index-1]){
				brokes[index]=brokeCount+1;
				brokeCount++;
			}
			index++;
		}
		//reverse
		if(brokeCount>2){
			index=1;
			while(brokes[index]==0) index++;
			int start=index-1;
			while(brokes[index]>0) index++;
			if(brokes[index-1]<brokeCount){
				System.out.println("no");
				return;
			}
			int end=index-1;
			reverse(a,start,end);
			if(isSorted(a)){
				System.out.println("yes");
				System.out.println("reverse "+start+" "+end);
				return;
			}
			
			else {
				System.out.println("no");
				return;				
				
			}
		}
		//swap
		if(brokeCount==1){
			index=1;
			while(brokes[index]==0) index++;
			if(index<1){
				System.out.println("no");
				return;				
			}
			swap(a, index, index-1);
			if(isSorted(a)){
				System.out.println("yes");
				System.out.println("swap "+(index-1)+" "+index);
				return;
			}
			else {
				System.out.println("no");
				return;				
				
			}
		}
		if(brokeCount==2){
			index=0;
			while(brokes[index]==0) index++;
			int start=index-1;
			index=index+1;
			while(brokes[index]==0) index++;
			int end=index;
			swap(a,start,end);
			if(isSorted(a)){
				System.out.println("yes");
				System.out.println("swap "+start+" "+end);
				return;
				
			}
			else {
				System.out.println("no");
				return;				
				
			}
		}
	}

	private static void reverse(int[] a, int start, int end) {
		int[] reverse=new int[end+1];
		for(int i=start;i<=end;i++){
			reverse[end-i+start]=a[i];
		}
		for(int i=start;i<=end;i++){
			a[i]=reverse[i];
		}
	}

	private static void swap(int[] a, int start, int end) {
		int tmp=a[start];
		a[start]=a[end];
		a[end]=tmp;
		
	}

	private static boolean isSorted(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i - 1])
				return false;
		}
		return true;
	}

}
