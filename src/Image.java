public class Image extends Message{
    private int size = 2;


    public Image(String content, User sender, Chat receiver){
        super(content, sender, receiver);
    }

    @Override
    public String getContent(){
        return "IMAGEM";
    }

}
