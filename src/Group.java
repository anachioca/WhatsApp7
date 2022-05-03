import java.util.ArrayList;

public class Group extends Chat{
    private ArrayList<User> admin = new ArrayList<User>();
    private String name;

    public Group(ArrayList<User> members, String name, User creator){
        super(members);
        this.name = name;
        this.admin.add(creator);
    }

    public boolean isAdmin(User user){
        for (int i = 0; i < admin.size(); i++){
            if (user.id == admin.get(i).id) return true;
        }
        return false;
    }

    public boolean newMember(User user){
        for (int i = 0; i < members.size(); i++){
            if (user.id == members.get(i).id) return false; // user already in group
        }
        members.add(user);
        return true;
    }

    public void showMembers(){
        System.out.println("\nMembers of group \"" + name + "\":");
        members = orderMembers();
        for (int i = 0; i < members.size(); i++){
            System.out.println(members.get(i).name);
        }
    }

    public void showMessages(){
        System.out.println("\nMessages in group \"" + name + "\":\n");
        for (int i = 0; i < this.messages.size(); i++){
            Message msg = this.messages.get(i);
            System.out.println("From " + msg.getFromUser().name + " at " + msg.getTimestamp().toString() + ": ");
            System.out.println(msg.getContent());
        }
    }

    // newAdmin
    // removeMember
}
