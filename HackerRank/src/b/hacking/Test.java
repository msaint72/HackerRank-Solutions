package b.hacking;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b=10;
		int a;
		
		a=0^b;
		System.out.println(a);
		a=0^a;
		System.out.println(a);
		a=a^a;
		System.out.println(a);

	}

}
