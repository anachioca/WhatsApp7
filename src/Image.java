public class Image extends Message{
    private int size = 2;

    public Image(User sender, Chat receiver){
        super("IMAGE", sender, receiver);
    }
}
