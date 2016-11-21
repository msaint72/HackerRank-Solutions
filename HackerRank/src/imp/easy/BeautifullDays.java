package imp.easy;

import java.util.Scanner;

public class BeautifullDays {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int i=in.nextInt();
		int j=in.nextInt();
		int k=in.nextInt();
		
		int count_beautiful=0;
		for(int idx=i;idx<=j;idx++){
			String k_str=new Integer(idx).toString();
			char[] reversed=new char[k_str.length()];
			for(int x=0;x<k_str.length();x++){
				reversed[x]=k_str.charAt(k_str.length()-1-x);
			}
			int reverse_number=new Integer(new String(reversed)).intValue();
			if((int)Math.abs(idx-reverse_number)%k==0){
				count_beautiful++;
			}
		}
		System.out.println(count_beautiful);

	}

}
