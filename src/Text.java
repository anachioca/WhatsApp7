public class Text extends Message{
    protected String content;
    public Text(String content, User sender, Chat receiver){
        super(sender, receiver);
        this.content = content;
    }
    public String getMessage() {
        String message = this.getTimestamp().toString() + " - " + this.getFromUser().name + ": ";
        message = message + content;
        return message;
    }

}
