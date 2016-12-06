package b.hacking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;

public class HotelTags {
	public class Word {
		String word;
		int total_count;
		TreeMap<Hotel,Integer> hotelCounts;
		public Word(String s){
			word=s;
			total_count=0;
			hotelCounts=new TreeMap<Hotel,Integer>();
		}
	}
	public class Hotel {
		int id;
		String review;
		String[] words;

		public Hotel(int id, String review, String words) {
			this.id = id;
			this.review = review;
			this.words = words.split("\\s+");
		}
		public void countWords(ArrayList<Word> wordList,ArrayList<String> tags){
			for(String w:words){
				if(tags.contains(w)){
					//wordList.ge
				}
			}
		}

	}

	public static void main(String[] args) {
		HotelTags solution = new HotelTags();
		Scanner scanner = new Scanner(System.in);
		// get words
		String input;
		input = scanner.nextLine();
		String[] tmpwords = input.split("\\s+");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<Word> words=new ArrayList<Word>();
		ArrayList<String> taglist=new ArrayList<String>();
		for (int i = 0; i < tmpwords.length; i++) {
			Word w=solution.new Word(tmpwords[i].toLowerCase());
			words.add(w);
			taglist.add(tmpwords[i].toLowerCase());
			}
		// get number of hotels
		int M = scanner.nextInt();
		String reviews[] = new String[M];
		int[] IDs = new int[M];
		// get Hotel ids and reviews
		for (int i = 0; i < M; i++) {
			IDs[i] = scanner.nextInt();
			reviews[i] = scanner.nextLine();
			//count words in review
		}

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
