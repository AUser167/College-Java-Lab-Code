class t0 extends Thread {
	public void run() {
		System.out.println("Started Thread t0");
		for (int i=0;i<300000;i++) {
			
		}
		System.out.println("Finished Thread t0");
	}
}

class t1 implements Runnable {
	public void run() {
		System.out.println("Started Thread t1");
		for (int i=0;i<10000;i++) {
			
		}
		System.out.println("Finished Thread t1");
	}
}

class t2 extends Thread {
	public void run() {
		System.out.println("Started Thread t2");
		for (int i=0;i<10000;i++) {
			
		}
		System.out.println("Finished Thread t2");
	}
}

class Multi_Threading {
	public static void main(String args[]) {
		t0 thread_0 = new t0();
		t1 obj = new t1();
		Thread thread_1 = new Thread(obj);
		t2 thread_2 = new t2();
		
		thread_0.start();
		thread_1.start();
		thread_2.start();
	}
}