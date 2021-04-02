import java.util.concurrent.atomic.AtomicInteger;

    public class PrintStreamUsingThread {


        private AtomicInteger count = new AtomicInteger(0);
        private Object lock = new Object();


        public static void main(String args[]){

            PrintStreamUsingThread sequence = new PrintStreamUsingThread();
            Thread t1 = new Thread(sequence.new MyThread(0,3));
            Thread t2 = new Thread(sequence.new MyThread(1,3));
            Thread t3 = new Thread(sequence.new MyThread(2,3));

            t1.start();
            t2.start();
            t3.start();
           // t3.start();

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

                int i =1;
                while(i<=10) {
                    synchronized (lock) {
                        if (count.get() % noOfThreads == threadId) {
                            count.getAndIncrement();
                            System.out.println(threadId + 1);
                            i++;
                            lock.notifyAll();
                        }
else{
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } }
                    }

                }

                }

            }




