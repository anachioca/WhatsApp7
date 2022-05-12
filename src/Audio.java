public class Audio extends Message{

    public Audio(User sender, Chat receiver){
        super("PLAY AUDIO", sender, receiver);
    }

    public String getMessage() {
        String message = this.getTimestamp().toString() + " - " + this.getFromUser().name + ": ";
        message = message + "PLAY AUDIO";
        return message;
    }

}
