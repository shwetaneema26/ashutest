
package ashutest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyArrayBlockingQueue<E> {

     Object[] items;
    int takeIndex;
    int putIndex;
    int count;
    Lock lock;
    Condition full;
    Condition empty;


    MyArrayBlockingQueue(int capacity){

        items = new Object[capacity];
        takeIndex = 0;
        putIndex = 0;
        count = 0;
        lock = new ReentrantLock(true);
        full = lock.newCondition();
        empty = lock.newCondition();



    }

    public void put(E e) throws InterruptedException{

        try{
            lock.lock();

            if(count!=0 && count==items.length)
                full.await();

            items[putIndex] = e;
            count++;
        if(++putIndex == items.length) putIndex = 0;

            empty.signal();


        }
        finally {
            lock.unlock();
        }

    }

    public E take() throws InterruptedException
    {

        try{
            lock.lock();
            if(count==0)
                empty.await();

            E e = (E)items[takeIndex];
            if(++takeIndex == items.length)
                takeIndex = 0;
            count--;
            full.signal();
            return e;

        }finally {
            lock.unlock();
        }


    }



    public static void main(String[] args) throws InterruptedException{

        MyArrayBlockingQueue bqueue = new MyArrayBlockingQueue(10);
        bqueue.put("shweta");
        bqueue.put("shweta1");
        bqueue.put("shweta2");
        bqueue.put("shweta3");
        bqueue.put("shweta4");
        System.out.println(bqueue.take());
        bqueue.put("shweta5");
        bqueue.put("shweta6");
        bqueue.put("shweta7");
        System.out.println(bqueue.take());
        bqueue.put("shweta8");
        bqueue.put("shweta9");
        bqueue.put("shweta10");
        bqueue.put("shweta10");
        System.out.println(bqueue.take());




        System.out.println(bqueue.take());
        System.out.println(bqueue.take());




    }

}


