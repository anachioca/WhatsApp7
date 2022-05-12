public class Image extends Message{
    private int size = 2;


    public Image(User sender, Chat receiver){
        super("IMAGE", sender, receiver);
    }

    public String getMessage() {
        String message = this.getTimestamp().toString() + " - " + this.getFromUser().name + ": ";
        message = message + "IMAGE";
        return message;
    }

}
