class Airport {
	boolean[] seats = new boolean[100];
	
	Airport() {
		super();
		for (int i = 0; i < 100; i++) {
			seats[i] = false;
		}
	}
	
	synchronized public void book(int seat_number) {
		Thread t = Thread.currentThread();
		if (seat_number < 0 && seat_number > 99) {
			System.out.println("Invalid range");
			return;
		}
		
		if (seats[seat_number]) {
			System.out.println("Already booked");
		}
		else {
			seats[seat_number] = true;
			System.out.println(t.getName() + ": Seat Number " + seat_number + ": booked");
		}
	}
}

class Thread1 extends Thread {
	Airport a1;
    int seat_number;

    Thread1(Airport a1, int seat_number) {
        this.a1 = a1;
        this.seat_number = seat_number;
    }

    public void run() {
        a1.book(seat_number);
    }
}

class SynchronizedThread {
	public static void main(String args[]) {
		Airport airport = new Airport();

        Thread1 t1 = new Thread1(airport, 0);
        Thread1 t2 = new Thread1(airport, 0);

        t1.setName("T1");
        t2.setName("T2");

        t1.start();
        t2.start();
	}
}