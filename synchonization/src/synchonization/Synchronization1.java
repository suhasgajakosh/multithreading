package synchonization;

import java.util.Scanner;

class ThreadClass extends Thread {
	
	private volatile 
	
	
	boolean running = true;

	@Override
	public void run() {
		while (running) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
	public void shutdown() {
		running = false;
	}
	
	
}


public class Synchronization1 {

	public static void main(String[] args) {
		ThreadClass t1 = new ThreadClass();
		t1.start();
		
		System.out.println("Presss any key to shutdown the thread");
		try(Scanner scanner = new Scanner(System.in);) {
			scanner.nextLine();
			t1.shutdown();
		} catch (Exception e) {
			System.out.println("Exception occured");
		}
		
		

	}

}
