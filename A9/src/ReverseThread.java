public class ReverseThread implements Runnable {
	//Declares a thread and a thread amount
	Thread reverseThread;
	static int threadNumber = 50;
	
	//creates the threads and runs them
	void createThreads() {
		for (int thread = 50; thread > 0; thread--) { 
			reverseThread = new Thread(new ReverseThread());
			try {	
				Thread.sleep(200);	
			}
			catch (Exception e) {
				System.out.println("Exception Thrown");
			}	
			reverseThread.start();
		}
	}
	//displays the threads along with their thread number
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello from Thread " + threadNumber + "!");
		threadNumber--;
	}
}