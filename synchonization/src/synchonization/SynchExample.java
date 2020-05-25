package synchonization;

public class SynchExample {

	private volatile int count = 0;
	
	public synchronized void increment() {
		count ++;
	}

	public static void main(String[] args) {
		SynchExample app = new SynchExample();
		app.doWork();

	}

	public void doWork() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 100; i++) {
					increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 100; i++) {
					increment();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
System.out.println(e.getMessage());			
		}
		
		System.out.println("Count is: " + count);
		
	}

}
