package java1;

public class test {
	static int equal(int x,int y) {
		while(x!=y) {
			if(x>y) x=x-y;
			if(x<y) y=y-x;
		}
		System.out.println(x);
		return 0;
	}
	
	public static void main(String args[]) {
		//equal(2437,875);
		B b = new B();
		C c = new C();
		
	}
}

 class A {
	public void print() {
		System.out.println("A");
	}
	
}

class B extends A {
	public void print() {
		System.out.println("C");
	}
}

class C extends A {
	public void print() {
		System.out.println("B");
	}
}

