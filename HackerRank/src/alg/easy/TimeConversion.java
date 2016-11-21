package alg.easy;

import java.util.Scanner;

public class TimeConversion {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();

		int hour = Integer.valueOf(input.substring(0, 2));
		String hour_str;
		if (input.endsWith("PM")) {
			if (hour < 12) {
				hour += 12;
			}

		} else {
			if (hour == 12)
				hour = 0;
		}
		if(hour>9)
			hour_str=new String(""+hour);
		else
			hour_str=new String("0"+hour);
		System.out.println(hour_str+input.substring(2, input.length()-2));
	}

}
