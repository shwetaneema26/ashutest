package arrays;

import ashutest.Test;

import java.util.concurrent.CopyOnWriteArrayList;

public class Test2 extends Test  implements  Cloneable{
    Test2()
    {
        this.hello();
    }
    protected static class inner
    {


        public void heyya()
        {
            System.out.println("heyya");
        }

    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String args [])
    {
        Test2.inner in = new Test2.inner();
        //Test2 test = new Test2();
        /*try {
            //Test2 t3 = (Test2) test.clone();
            //System.out.println(t3 == test);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }*/
        CopyOnWriteArrayList<Integer> cl = new CopyOnWriteArrayList<Integer>(new Integer [] {1,2,3,4,5});
        cl.add(6);
        cl.get(6);
        cl.forEach(System.out::println);
    }
}
