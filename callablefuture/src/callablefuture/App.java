package callablefuture;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();

		Future<Integer> future = executor.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Random random = new Random();
				int duration = random.nextInt(4000);

				System.out.println("Starting...");
				Thread.sleep(duration);

				System.out.println("Completed in duration - " + duration);

				return duration;
			}
		});
		executor.shutdown();
		
		try {
			System.out.println("Execution duration is - " + future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
