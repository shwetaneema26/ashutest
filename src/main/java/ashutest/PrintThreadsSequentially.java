package ashutest;
public class PrintThreadsSequentially {

    static int number = 1;
    static final int PRINT_NUMBERS_UPTO = 20;
    static Object lock = new Object();

    static class SequentialThread extends Thread {
        int remainder = 0;
        int noOfThreads = 0;

        public SequentialThread(String name, int remainder, int noOfThreads) {
            super(name);
            this.remainder = remainder;
            this.noOfThreads = noOfThreads;
        }

        @Override
        public void run() {
            while (number < PRINT_NUMBERS_UPTO) {
                synchronized (lock) {
                    while (number % noOfThreads != remainder) { // wait for numbers other than remainder
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(getName() + " value " + number);
                    number++;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        SequentialThread first = new SequentialThread("Fourth Thread", 0, 4);
        SequentialThread second = new SequentialThread("First Thread", 1, 4);
        SequentialThread third = new SequentialThread("Second Thread", 2, 4);
        SequentialThread fourth = new SequentialThread("Third Thread", 3, 4);
        first.start();
        second.start();
        third.start();
        fourth.start();
    }
}