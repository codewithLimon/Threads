package Basics;

 /* in this program we will keep out main thread alive until the child thread
 finishes his work */

public class RunnableThread2 {
    public static void main(String[] args) {

        System.out.println("..From main thread..");
        System.out.println("Main thread started");

        //First object
        NewThread2 t1 = new NewThread2("Masud's Thread"); // child thread 1


        //Second Object
        NewThread2 t2 = new NewThread2("Limon's Thread"); // child thread 2

        System.out.println("Thread1 is alive ? "+t1.t.isAlive());
        System.out.println("Thread2 is alive ? "+t2.t.isAlive());


        try{
            //Bug//

            System.out.println("waiting");
            t1.t.join();
            t2.t.join(); // means main thread will wait untill the first thread finishes his work

            //Bug//

        }catch (InterruptedException ie){
            ie.printStackTrace();
        }

        System.out.println("Thread1 is alive ? "+t1.t.isAlive());
        System.out.println("Thread2 is alive ? "+t2.t.isAlive());

        System.out.println("Main thread finished..."); // main thread died here..



    }
}

class NewThread2 implements Runnable {

    Thread t; //global thread for NewThread Class
    String name;
    NewThread2(String Name) {
        t = new Thread(this, Name); // initializing thread name by creating thread object
        t.start(); // thread will be started when the constructor will be called;
        this.name=Name;
    }


    @Override
    public void run() {
        // this run method actually refers that what the thread will do
        // ( we have to write all the thread methods here which will be executed)
        //Then we have to start the thread

        System.out.println("From "+name+"'s Runnable thread ");
        for (int i = 0; i <5; i++) {
            System.out.println("Running " + t.getName() + " - " + i);
//            try {
//                Thread.sleep(400);
//            } catch (InterruptedException ie) {
//                ie.printStackTrace();
//            }
        }
        System.out.println("Complete printing " + t.getName());

    }
}




