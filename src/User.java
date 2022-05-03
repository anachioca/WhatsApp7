import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class User {
    public static int count;
    public String name;
    public int id;

    public User(String name){
        this.name = name;
        count++;
        id = count;
    }

    public boolean sendMessage(String content, Chat receiver, int type){
        if (!receiver.isMember(this)) return false;
        Message newMessage = new Message(content, this, receiver);
        receiver.receiveMessage(newMessage);
        return true;
    }

    public Conversation startConversation(User member){
        ArrayList<User> members = new ArrayList<User>();
        members.add(member);
        members.add(this);
        Conversation newConv = new Conversation(members);
        return newConv;
    }

    public Group createGroup(User member, String name){
        ArrayList<User> members = new ArrayList<User>();
        members.add(member);
        members.add(this);
        Group newGroup = new Group(members, name, this);
        return newGroup;
    }

    public boolean addMember(User member, Group group){
        if (!group.isAdmin(this)) return false;
        return group.newMember(member);
    }

}
