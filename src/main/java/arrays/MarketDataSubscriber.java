package arrays;

import api.Observer;
import api.Subject;

public class MarketDataSubscriber implements Observer {
    @Override
    public void update(Message message) {
        System.out.println("Markdata Received " + message);
    }
    public static void main(String [] args)
    {
        Subject publisher =  new MarketDataPublisher();
        Observer listener = new MarketDataSubscriber();
        publisher.register(listener);
        publisher.publish();
    }
}
