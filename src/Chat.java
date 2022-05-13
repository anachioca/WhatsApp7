import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

abstract class Chat {
    private static int count;
    protected ArrayList<User> members = new ArrayList<>();
    protected ArrayList<Message> messages = new ArrayList<>();
    public int id;

    public Chat(ArrayList<User> newMembers){
        members = newMembers;
        count++;
        id = count;
    }

    public void receiveMessage(Message newMessage){
        this.messages.add(newMessage);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

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

    public int memberCount(){
        System.out.println("\nThere are " + members.size() + " members in this chat.");
        return members.size();
    }

    public abstract String showMessages();
    public abstract String showMembers();
}
