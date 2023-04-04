package Synchronization;

public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized int getCount() {
        return count;
    }
}

 class MyThread implements Runnable {
    private Counter counter;

    Thread t;

    public MyThread(Counter counter) {
        this.counter = counter;
        t=new Thread();
        t.start();
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
            counter.decrement();
        }
    }
}

 class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        try {
            t1.t.join();
            t2.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getCount()); // Output should be 0
    }
}
