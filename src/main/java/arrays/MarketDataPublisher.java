package arrays;

import api.Observer;
import api.Subject;

import java.util.ArrayList;
import java.util.List;

public class MarketDataPublisher implements Subject {
    private List<Observer> subscribers;

    public MarketDataPublisher() {
        subscribers = new ArrayList<>();
    }

    @Override
    public void register(Observer ob) {
        subscribers.add(ob);
    }

    @Override
    public void degister(Observer ob) {
        subscribers.remove(ob);
    }

    @Override
    public void publish() {
        System.out.println("Publshing marketdata");
        Message message = new Message("VOD.L 50");
        subscribers.forEach(x->x.update(message));
    }
}
