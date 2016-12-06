package b.hacking;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
	 public static int numberNeeded(String first, String second) {
	      HashMap<Character, Integer> map=new HashMap<Character,Integer>();
	      // all characters of first to a map
	      for(int i=0;i<first.length();i++){
	    	  map.put(first.charAt(i), map.getOrDefault(first.charAt(i), 0)+1);
	      }
	      int n1=first.length();
	      int n2=second.length();
	      int common=0;
	      for(int i=0;i<second.length();i++){
	    	  char current=second.charAt(i);
	    	  if(map.containsKey(current)){
	    		  common+=1;
	    		  int value=map.get(current);
	    		  if(value>1){
	    			  map.replace(current, value,value-1);
	    		  } else
	    		  {
	    			  map.remove(current);
	    		  }
	    	  }
	      }
	      return (n1-common)+(n2-common);
	      
	    }
	  
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String a = in.next();
	        String b = in.next();
	        System.out.println(numberNeeded(a, b));
	    }

}
