public class Text extends Message{
    public Text(String content, User sender, Chat receiver){
        super(content, sender, receiver);
    }
    public String getMessage() {
        String message = this.getTimestamp().toString() + " - " + this.getFromUser().name + ": ";
        message = message + content;
        return message;
    }

    public String getContent() {
        return content;
    }
}
