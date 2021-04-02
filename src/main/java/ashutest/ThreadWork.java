public class ThreadWork {

    private int limit = 10;
    private volatile int count = 0;
    private Object lock = new Object();


    public static void main(String args[]) throws InterruptedException{

        ThreadWork sequence = new ThreadWork();
        Thread t1 = new Thread(sequence.new MyThread(0));
        Thread t2 = new Thread(sequence.new MyThread(1));
        Thread t3 = new Thread(sequence.new MyThread(2));
        // Thread t3 = new Thread(sequence.new MyThread(3));

        t1.start();
        t2.start();

        t3.start();

        t1.join();
        t2.join();t3.join();
        System.out.println("main exiting");

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
            if(count%3==threadId) {


                System.out.println(threadId+1);

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




