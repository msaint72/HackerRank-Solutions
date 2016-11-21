package strings.easy;

import java.util.Scanner;

public class FunnyString {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		String[] S=new String[T];
		for(int i=0;i<T;i++){
			S[i]=in.next();
		}
		for(int i=0;i<T;i++){
			String str=S[i];
			boolean funny=true;
			for(int j=1;j<str.length();j++){
				int r_index=str.length()-1-j;
				int r_index2=r_index+1;
				if(Math.abs(str.charAt(j)-str.charAt(j-1))!=Math.abs(str.charAt(r_index)-str.charAt(r_index2))){
					funny=false;
					break;
				}
			}
			if(funny){
				System.out.println("Funny");
			} else {
				System.out.println("Not Funny");				
			}
		}
		

	}

}
