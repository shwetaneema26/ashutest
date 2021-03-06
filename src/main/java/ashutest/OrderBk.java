package ashutest;

import java.util.Collections;
import java.util.TreeMap;

public class OrderBk {
    private TreeMap<Integer,Order> bid;
    private TreeMap<Integer,Order> ask;

    public TreeMap<Integer, Order> getBid() {
        return bid;
    }

    public TreeMap<Integer, Order> getAsk() {
        return ask;
    }

    OrderBk()
    {
        ask = new TreeMap<Integer, Order>();
        bid = new TreeMap<Integer, Order>(Collections.reverseOrder());

        ask.put(10,new Order());
        ask.put(20,new Order());
        ask.put(30,new Order());
        ask.put(40,new Order());
        ask.put(50,new Order());

        bid.put(10,new Order());
        bid.put(20,new Order());
        bid.put(30,new Order());
        bid.put(40,new Order());
        bid.put(50,new Order());
    }
}
