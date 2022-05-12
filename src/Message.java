import java.util.ArrayList;
import java.sql.Timestamp;

abstract class Message {

    public static int count;
    public int id;
    private Timestamp timestamp;
    private User fromUser;
    private Chat toChat;
    protected String content;

    public Message(String content, User sender, Chat receiver){
        count++;
        int newId = count;
        id = newId;
        Long datetime = System.currentTimeMillis();
        timestamp = new Timestamp(datetime);
        fromUser = sender;
        toChat = receiver;
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public User getFromUser() {
        return fromUser;
    }

    public String getContent() {
        return content;
    }

    abstract String getMessage();
}
