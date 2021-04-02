    import java.util.Arrays;
    import java.util.List;
    import java.util.concurrent.ArrayBlockingQueue;
    import java.util.concurrent.BlockingQueue;
    import java.lang.String;


    public class ProducerConsumerTest {

        String s =  new String() ;
        private final BlockingQueue<String> bqueue;

        ProducerConsumerTest(BlockingQueue<String> bqueue){
           this.bqueue =  bqueue;
        }


       static public class Producer implements Runnable{

            BlockingQueue bqueue;
            Producer(BlockingQueue<String> bqueue){
                this.bqueue = bqueue;

            }
            public void run(){

                while(!Thread.currentThread().isInterrupted()){


                    generateMessage();


                }

            }

            void generateMessage(){

                List<String> strList = Arrays.asList("Ram","shyam","mohan");
                for (String s:
                     strList) {
    try {
        bqueue.put(s);


    }

    catch (InterruptedException ex){
        Thread.currentThread().interrupt();
    }
    System.out.println("Interrupted");
                }



            }

        }

        public static class Consumer implements Runnable{

            BlockingQueue bqueue;
            Consumer(BlockingQueue<String> bqueue){
                this.bqueue = bqueue;

            }
            public void run() {


                while (true) {


                    consumeMessage();

                }}
                void consumeMessage(){

                    try {
                        while(true)
                            System.out.println(bqueue.take());
                        }catch (InterruptedException ex){
                            Thread.currentThread().interrupt();
                        }

                    }
            }




        public static void main(String []args) throws InterruptedException{

            BlockingQueue<String> bqueue = new ArrayBlockingQueue<>(10);
            ProducerConsumerTest t = new ProducerConsumerTest(bqueue);
            Thread t1 = new Thread(new ProducerConsumerTest.Consumer(bqueue));
            Thread t2 = new Thread(new ProducerConsumerTest.Consumer(bqueue));
            Thread t3 = new Thread(new ProducerConsumerTest.Consumer(bqueue));

            t1.start();
            t2.start();
            t3.start();

            Thread t4 = new Thread(new ProducerConsumerTest.Producer(bqueue));
            t4.start();

            t1.join();
            t2.join();
            t3.join();

            Thread.sleep(1000);
            t4.interrupt();
            System.out.println("producer interrupted");


        }


    }
