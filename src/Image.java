public class Image extends Message{
    private int size = 2;


    public Image(User sender, Chat receiver){
        super(sender, receiver);
    }

    public String getMessage() {
        String message = this.getTimestamp().toString() + " - " + this.getFromUser().name + ": ";
        message = message + "IMAGEM";
        return message;
    }

}
