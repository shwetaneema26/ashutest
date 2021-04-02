package ashutest;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Collection;

public class OrderBookTest {

    @Test
    public void testorder() {
        OrderBk ord = new OrderBk();
        Order orf = new Order();
        System.out.println(ord.getAsk().toString());
        System.out.println(ord.getBid().toString());

    }

}