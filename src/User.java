import java.util.ArrayList;

public class User {
    public static int count;
    public String name;
    public int id;

    public User(String name){
        this.name = name;
        count++;
        id = count;
    }

    public boolean sendTextMessage(String content, Chat receiver){
        if (!receiver.isMember(this)){
            System.out.println("\nUser is not allowed to send messages.");
            return false;
        }
        Text newMessage = new Text(content, this, receiver);
        receiver.receiveMessage(newMessage);
        return true;
    }

    public boolean sendAudioMessage(Chat receiver){
        if (!receiver.isMember(this)){
            System.out.println("\nUser is not allowed to send messages.");
            return false;
        }
        Audio newMessage = new Audio(this, receiver);
        receiver.receiveMessage(newMessage);
        return true;
    }

    public boolean sendImageMessage(Chat receiver){
        if (!receiver.isMember(this)){
            System.out.println("\nUser is not allowed to send messages.");
            return false;
        }
        Image newMessage = new Image(this, receiver);
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
        if (!group.isAdmin(this)){
            System.out.println("User is not allowed to add new members to group.");
            return false;
        }
        return group.newMember(member);
    }

    public boolean removeMember(User member, Group group){
        if (!group.isAdmin(this)){
            System.out.println("User is not allowed to remove members from group.");
            return false;
        }
        return group.removeMember(member);
    }

    public boolean addAdmin(User newAdmin, Group group){
        if (!group.isAdmin(this)) {
            System.out.println("User is not allowed to add new administrators to group.");
            return false;
        }
        return group.newAdmin(newAdmin);
    }

    public boolean removeAdmin(User admin, Group group){
        if (!group.isAdmin(this)){
            System.out.println("User is not allowed to remove admins from group.");
            return false;
        }
        return group.removeAdmin(admin);
    }

}
