import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

abstract class Chat {
    public static int count;
    protected ArrayList<User> members = new ArrayList<User>();
    protected ArrayList<Message> messages = new ArrayList<Message>();
    public int id;

    public Chat(ArrayList<User> newMembers){
        members = newMembers;
        count++;
        id = count;
    }

    public void receiveMessage(Message newMessage){
        this.messages.add(newMessage);
    }

    public abstract void showMessages();
    public abstract void showMembers();

    public boolean isMember(User user){
        for (int i = 0; i < members.size(); i++){
            if (user.id == members.get(i).id) return true;
        }
        return false;
    }

    public ArrayList<User> orderMembers() {
        Collections.sort(members, new Comparator<User>(){
            public int compare(User user1, User user2){
                return user1.name.compareTo(user2.name);
            }
        });
        return members;
    }
}
