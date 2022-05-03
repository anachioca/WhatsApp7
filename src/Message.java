import java.util.ArrayList;
import java.sql.Timestamp;

abstract class Message {

    public enum types {
        Text, Image, Audio;
    }
    public static int count;
    public int id;
    private Timestamp timestamp;
    protected String content;
    private User fromUser;
    private Chat toChat;

    public Message(String content, User sender, Chat receiver){
        count++;
        int newId = count;
        id = newId;
        this.content = content;
        Long datetime = System.currentTimeMillis();
        timestamp = new Timestamp(datetime);
        fromUser = sender;
        toChat = receiver;

//        System.out.println("Saved message from " + fromUser.name + " to chat id " + toChat.id + ": ");
//        System.out.println("From " + this.fromUser.name + " at " + this.timestamp.toString() + ": ");
//        System.out.println(this.content);
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getContent(){
        return content;
    }

    public User getFromUser() {
        return fromUser;
    }

    // message types (text, picture, voice)
}
