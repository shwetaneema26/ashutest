package api;

public interface Subject {

    void register(Observer ob);

    void degister(Observer ob);

    void publish();
}
