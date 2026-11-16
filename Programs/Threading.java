class thread1 extends Thread {
	String name;
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				sleep(1000);
			}
			catch (Exception e) {
				
			}
			
			if (i == 4) {
				Thread.currentThread().stop();
			}
			else if (i == 2) {
				Thread.yield();
			}
			System.out.println(name + ": " + i);
		}
	}
}

class Threading {
	public static void main(String args[]) {
		thread1 t1 = new thread1();
		thread1 t2 = new thread1();
		
		t1.name = "Thread 1";
		t2.name = "Thread 2";
		
		t1.setPriority(1);
		t2.setPriority(10);
		
		t1.start();
		t2.start();
	}
}