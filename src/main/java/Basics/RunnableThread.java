package Basics;

public class RunnableThread {
    public static void main(String[] args) {

        System.out.println("..From main thread..");
        System.out.println("Main thread started");

        //First object
        NewThread t1 = new NewThread("Masud's Thread"); // child thread 1


        //Second Object
        NewThread t2 = new NewThread("Limon's Thread"); // child thread 2

        System.out.println("Main thread finished..."); // main thread died here..

        /* Since there are two NewThread objects, means both of the thread will run parallely;

         Such as:
         Running Thread[#24,Limon's Thread,5,main] - 5
         Running Thread[#23, Masud 's Thread,5,main] - 5 */

        /*
        The order in which threads run is non-deterministic and can be influenced by factors such as
        the operating system's thread scheduler, the number of available processor cores, and the
        workload of the system.
         */

    }
}

class NewThread implements Runnable {

    Thread t; //global thread for NewThread Class

    NewThread(String Name) {
        t = new Thread(this, Name); // initializing thread name by creating thread object
        t.start(); // thread will be started when the constructor will be called;
    }


    @Override
    public void run() {
        // this run method actually refers that what the thread will do
        // ( we have to write all the thread methods here which will be executed)
        //Then we have to start the thread
        System.out.println("From Runnable thread....");
        for (int i = 5; i > 0; i--) {
            System.out.println("Running " + t + " - " + i);
            try {
                Thread.sleep(100); // basically we use sleep method so that the thread can change context in between times
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println("Complete printing " + t.getName());

    }
}

/*

// context switches randomly


Whole output demo:

..From main thread..
Main thread started
Main thread finished...
From Runnable thread....
From Runnable thread....
Running Thread[#23,Masud's Thread,5,main] - 5
Running Thread[#24,Limon's Thread,5,main] - 5
Running Thread[#24,Limon's Thread,5,main] - 4
Running Thread[#23,Masud's Thread,5,main] - 4
Running Thread[#24,Limon's Thread,5,main] - 3
Running Thread[#23,Masud's Thread,5,main] - 3
Running Thread[#24,Limon's Thread,5,main] - 2
Running Thread[#23,Masud's Thread,5,main] - 2
Running Thread[#24,Limon's Thread,5,main] - 1
Running Thread[#23,Masud's Thread,5,main] - 1
Complete printing Masud's Thread
Complete printing Limon's Thread





// context switches randomly

 */


