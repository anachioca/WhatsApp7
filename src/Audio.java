public class Audio extends Message{
    private float duration;


    public Audio(String content, User sender, Chat receiver){
        super(content, sender, receiver);
    }

    @Override
    public String getContent(){
        return "IMAGEM";
    }

}
