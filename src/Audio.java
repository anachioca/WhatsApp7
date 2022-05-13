public class Audio extends Message{

    public Audio(User sender, Chat receiver){
        super("PLAY AUDIO", sender, receiver);
    }
}
