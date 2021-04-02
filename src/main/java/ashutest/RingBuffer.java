package ashutest;

import java.util.Scanner;

class RingBuffer
{
    //// YOUR CODE HERE ////
    private int[] buf;
    private int front ;
    private int rear;
    private int bufLen;
    private int capacity;

    public RingBuffer(int capacity)
    {
        front = rear = 0;
        bufLen = 0;
        buf = new int[capacity];
        this.capacity = capacity;
    }

    // returns next available value, or 0 if empty
    int read()
    {
        if (!isEmpty() )
        {
            bufLen--;
            front = (front + 1) % capacity;
            int val = buf[front];
            //System.out.println("Reading the value" +  val);
            return val;

        }
        else
        {
            //System.out.println("Buffer is empty");
            return 0;
        }
    }

    public boolean isEmpty()
    {
        return bufLen == 0;
    }

    // puts the value to the ring buffer
    // drops the value if the ring buffer is full
    void write(int val)
    {
        if (!isFull() )
        {
            bufLen++;
            rear = (rear + 1) % capacity;
            buf[rear] = val;
            //System.out.println("Inserted the value" +  val);

        }
        /*else
            System.out.println("Dropping the value" +  val);*/
    }
    public boolean isFull()
    {
        return bufLen == capacity;
    }
}

class RingBufferTest {
    public static void main(String[] args) {
        // {{ DO NOT TOUCH THIS
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();

        RingBuffer ringBuffer = new RingBuffer(capacity);

        int n = scanner.nextInt();

        int cmd, val;

        for (int i = 0; i < n; ++i)
        {
            cmd = scanner.nextInt();
            val = scanner.nextInt();

            switch (cmd)
            {
                case 0: // push
                    ringBuffer.write(val);
                    break;

                case 1: // pop
                    System.out.print(ringBuffer.read() + " ");
                    break;

                default:
                    break;
            }
        }
        // }} DO NOT TOUCH THIS
    }
}
