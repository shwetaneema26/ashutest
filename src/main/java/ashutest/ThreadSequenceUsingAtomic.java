package ashutest;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSequenceUsingAtomic {

     private final AtomicInteger count = new AtomicInteger(1);
     private final Object lock = new Object();


     public static void main(String args[]){

         ThreadSequenceUsingAtomic sequence = new ThreadSequenceUsingAtomic();
          Thread t1 = new Thread(sequence.new MyThread(0,3));
         Thread t2 = new Thread(sequence.new MyThread(1,3));
         Thread t3 = new Thread(sequence.new MyThread(2,3));

         t1.start();
         t2.start();
         t3.start();

     }

     class MyThread implements Runnable{

         private int threadId;
         private int noOfThreads;

         MyThread(int id, int noOfThreads){

             threadId = id;
             this.noOfThreads = noOfThreads;

         }
         @Override
         public void run(){

             while(count.get()<=200){

                synchronized(lock) {

                     if (count.get()%noOfThreads== threadId) {
                         System.out.println(count.getAndIncrement());
                         lock.notifyAll();
                     } else {
                         try {
                             lock.wait();
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                }



                 }

             }

         }
     }



