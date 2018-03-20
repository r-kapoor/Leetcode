package java1;

 class Thread1 implements Runnable {
	
	private Thread t;
	private String threadName;
	
	Thread1(String tname) {
		this.threadName = tname;
	}

	@Override
	public void run() {
		while(true) System.out.println(threadName);		
	}
	
	public void start() {
		if(t==null) {
			t = new Thread(this,threadName);
			t.start();
		}
	}
	
}
public class Thread2 {
	public static void main(String args[]) {
		Thread1 t1 = new Thread1("A");
		Thread1 t2 = new Thread1("B");
		
		t2.start();
		t1.start();
		
	}
}