package Basics;

import java.io.IOException;


//Using Thread Object
public class MainThread {
    public static void main(String[] args) {
        Thread t=Thread.currentThread(); // refers to current thread;

        System.out.println("Current thread: "+t); // Current thread: Thread[#1,main,5,main]

        t.setName("Limon's Main Thread");
        System.out.println("Current thread after changing name: "+t); //Current thread after changing name: Thread[#1,Limon's Main Thread,5,main]

        int i=10;
        while(i-->0){
            System.out.println("Current thread: "+t+"  --  "+i);
            try{
                Thread.sleep(200); // setting a delay of 200ms to the thread running
            }catch (InterruptedException e){
                System.out.println();
            }
        }
    }
}
