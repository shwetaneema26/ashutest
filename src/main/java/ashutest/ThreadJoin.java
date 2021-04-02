import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadJoin {

    private int limit = 10;
    private volatile int count = 1;
    private Object lock = new Object();
    private static ConcurrentHashMap<String,Integer> concurrentHashMap;

    public static void main(String args[]) throws InterruptedException{

        concurrentHashMap =  new ConcurrentHashMap();

        ThreadJoin sequence = new ThreadJoin();
        Thread t1 = new Thread(sequence.new MyThread(1));
        Thread t2 = new Thread(sequence.new MyThread(2));
        Thread t3 = new Thread(sequence.new MyThread(3));
        // Thread t3 = new Thread(sequence.new MyThread(3));

        t1.start();
        t2.start();

        t3.start();

        t1.join();
        t2.join();
        t3.join();


    }

    class MyThread implements Runnable {

        private int threadId;
        //private String str;

        MyThread(int id) {

            threadId = id;
           // str = s1;

        }

        @Override
        public void run(){

            int i =1;
            while (i<=10) {

                synchronized (lock) {
            if(count%4==threadId) {


                System.out.println(threadId);
                if(++count==4) count=1;
i++;
                lock.notifyAll();

            }
else{
    try{
        lock.wait();
    }
    catch(InterruptedException ex){

    }
            }


                }

            }
        }
    }

}




