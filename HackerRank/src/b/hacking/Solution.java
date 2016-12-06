package b.hacking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public class Hotel {
		int id;
		String review;
		String[] words;

		public Hotel(int id, String review, String words) {
			this.id = id;
			this.review = review;
			this.words = words.split("\\s+");
		}

	}

	public static void main(String[] args) {
		// Solution solution=new Solution();
		// solution.;

		// String input;
		// int numberOfSquares = 0;
		// int numberOfRectangles = 0;
		// int numberOfPolygons = 0;
		// boolean newinput = true;
		// // while (newinput) {
		// for (int j = 0; j < 5; j++) {
		// Scanner scanner = new Scanner(System.in);
		// input = scanner.nextLine();
		// if (input.length() > 0) {
		// String[] sides = input.split("\\s+");
		// int side1 = Integer.parseInt(sides[0]);
		// int side2 = Integer.parseInt(sides[1]);
		// int side3 = Integer.parseInt(sides[2]);
		// int side4 = Integer.parseInt(sides[3]);
		// if (side1 == side2 && side1 == side3 && side1 == side4 && side1 > 0)
		// {
		// numberOfSquares++;
		// } else if (side1 == side3 && side2 == side4 && side1 > 0 && side2 >
		// 0) {
		// numberOfRectangles++;
		// } else {
		// numberOfPolygons++;
		// }
		// } else {
		// newinput = false;
		// }
		// }
		// System.out.println(numberOfSquares + " " + numberOfRectangles + " " +
		// numberOfPolygons);

		// 2
		Solution solution = new Solution();
		String[] words;
		Scanner scanner = new Scanner(System.in);
		// get words
		String input;
		input = scanner.nextLine();
		words = input.split("\\s+");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i].toLowerCase(), 0);
		}
		// get number of hotels
		int M = scanner.nextInt();
		String reviews[] = new String[M];
		int[] IDs = new int[M];
		// get Hotel ids and reviews
		for (int i = 0; i < M; i++) {
			IDs[i] = scanner.nextInt();
			reviews[i] = scanner.nextLine();
		}

		// 3
		// Scanner scanner = new Scanner(System.in);
		// String input;
		// input=scanner.nextLine();
		// String[] numbers = input.split("\\s+");
		//
		// int prev=0;
		// for(int i=0;i<numbers.length;i++){
		// if(i==0){
		// prev=Integer.parseInt(numbers[0]);
		// System.out.print(numbers[0]);
		// } else {
		// int currNumber=Integer.parseInt(numbers[i]);
		// int diff=currNumber-prev;
		// if(diff>127 ||diff<-127){
		// System.out.print(" -128");
		// }
		// System.out.print(" "+diff);
		// prev=currNumber;
		// }
		//
		// }

		// 4
		// Scanner scanner = new Scanner(System.in);
		// int N=scanner.nextInt();
		// int M=scanner.nextInt();
		// int[] arr=new int[M];
		// for(int i=0;i<M;i++){
		// arr[i]=scanner.nextInt();
		// }
		// checkSumExsists(arr,N);
		//
	}

	private static void checkSumExsists(int[] A, int N) {
		HashSet<Integer> numbers = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			numbers.add(A[i]);
		}
		for (int i = 0; i < A.length; i++) {
			if (numbers.contains(N - A[i])) {
				System.out.println("1");
				return;
			}

		}

	}

}
