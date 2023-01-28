package ThreadPools;

public class Future {
	private boolean finished = false;

	public synchronized void get() throws InterruptedException {
		while(!finished) wait();
	}

	public synchronized void finish() {
		finished = true;
		notifyAll();
	}
}
