import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSequence {

     private  int threadToRun = 1;
     private AtomicInteger count = new AtomicInteger(0);
     private Object lock = new Object();
     private int numThreads = 3;


     public static void main(String args[]){

         ThreadSequence sequence = new ThreadSequence();
          Thread t1 = new Thread(sequence.new MyThread(1));
         Thread t2 = new Thread(sequence.new MyThread(2));
         Thread t3 = new Thread(sequence.new MyThread(0));

         t1.start();
         t2.start();
         t3.start();

     }

     class MyThread implements Runnable{

         private int threadId;

         MyThread(int id){

             threadId = id;

         }
         @Override
         public void run(){
             synchronized(lock) {
             while(count.get() <= 2000){

                     while (count.get() % numThreads != threadId) {

                         try {
                             lock.wait();
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }

                     }

                     System.out.println(threadId + " " + count.getAndIncrement());
                     lock.notifyAll();
                 }



                 }

             }

         }
     }



