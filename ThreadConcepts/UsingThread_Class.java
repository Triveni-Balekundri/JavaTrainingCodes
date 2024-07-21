package multi_threadingConcepts;

//This class is responsible for extending thread class and then executing threads
public class UsingThread_Class extends Thread {

	// Have used run() to run the thread

	public void run() {

		// loop to count till 5

		for (int i = 1; i <= 5; i++)

		{

			System.out.println(i);

			// try-catch block to catch exception related to when: a thread is waiting,
			// sleeping, or otherwise occupied

			try {

				// Causes the currently executing thread to sleep

				Thread.sleep(1000);

			}

			catch (InterruptedException e)

			{

				System.out.println("Error,thread interrupted");

			}

		}

		System.out.println(

				"Thread " + Thread.currentThread()

						+ " is running");

	}
}
