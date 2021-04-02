package arrays;

public class Message {
    private String message ;
    public Message(String str) {
        this.message = str;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                '}';
    }
}
