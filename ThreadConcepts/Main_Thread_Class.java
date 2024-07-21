package multi_threadingConcepts;

public class Main_Thread_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// creation of thread 1

		UsingThread_Class mt = new UsingThread_Class();

		// executing the first thread

		mt.start();

		// creation of thread 1

		UsingThread_Class mt2 = new UsingThread_Class();

		// executing the first thread

		mt2.start();

	}

}
