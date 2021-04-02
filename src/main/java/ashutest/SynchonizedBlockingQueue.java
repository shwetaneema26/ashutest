package ashutest;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class SynchonizedBlockingQueue<E> {
    private Object notFull =  new Object();
    private Object notEmpty = new Object();
    private Queue<E> array ;
    private int size = 0;

    public SynchonizedBlockingQueue(int size)
    {
        array = new ArrayDeque<>(size);
        this.size = size;
    }
    public void put(E item)
    {
        synchronized (notFull) {
            while (array.size() == size) {
                try {
                    notFull.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            array.add(item);
            notEmpty.notifyAll();
        }

    }
    public  E take()
    {
        synchronized (notEmpty) {
            E item = null;
            while (array.size() == 0) {
                try {
                    notEmpty.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            item = array.remove();
            notFull.notifyAll();

            return item;
        }
    }
    public static void main(String args [])
    {
        SynchonizedBlockingQueue<Integer> queue = new SynchonizedBlockingQueue<>(10);
        final Runnable producer = ()-> {
            Random rd = new Random();
            while(true)
                queue.put(rd.nextInt());
        };
        final Runnable consumer = ()-> {
            while(true) {
                Integer item = queue.take();
                System.out.println(item);
            }
        };
        new Thread(producer).start();
        new Thread(consumer).start();


    }
    }
