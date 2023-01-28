package ThreadPools;

import java.util.concurrent.LinkedBlockingQueue;

public class Threadpool {
	LinkedBlockingQueue<Task> queue;
	boolean running = true;
	Thread[] workers;

	public Threadpool(int numWorkers) throws InterruptedException {
		if(numWorkers > 0){
			workers = new Thread[numWorkers];
			queue = new LinkedBlockingQueue<>();

			Runnable worker = () -> {
				while(true){
					try {
						Task t = queue.take();
						t.getRunnable().run();
						t.getFuture().finish();
					} catch (InterruptedException e) {
						return;
					}
				}
			};

			for(int i=0; i<numWorkers; i++){
				workers[i] = new Thread(worker);
				workers[i].start();
			}

		} else {
			throw new IllegalArgumentException();
		}
	}

	public Future submit(Runnable job) throws ShutDownException {
		if(running) {
			Future smth = new Future();
			try {
				queue.put(new Task(job, smth));
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			return smth;
		}else{
			throw new ShutDownException();
		}
	}

	public void shutdownNow() {
		running = false;
		for(int i=0; i< workers.length; i++) workers[i].interrupt();
	}
}
