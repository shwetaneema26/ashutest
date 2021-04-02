package api;


import arrays.Message;

public interface Observer {
    void update(Message message);
}
