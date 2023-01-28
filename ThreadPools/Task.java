package ThreadPools;

/**
 * A wrapper for a runnable and a future
 */
public class Task {
	private final Runnable runnable;
	private final Future future;


	public Task(Runnable runnable, Future future) {
		this.runnable = runnable;
		this.future = future;
	}

	public Runnable getRunnable() {
		return runnable;
	}

	public Future getFuture() {
		return future;
	}
}
