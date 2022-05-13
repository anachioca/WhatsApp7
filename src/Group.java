import java.util.ArrayList;

public class Group extends Chat{
    private ArrayList<User> admin = new ArrayList<User>();
    private String name;

    public Group(ArrayList<User> members, String name, User creator){
        super(members);
        this.name = name;
        this.admin.add(creator);
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin(User user){
        for (int i = 0; i < admin.size(); i++){
            if (user.id == admin.get(i).id) return true;
        }
        return false;
    }

    public ArrayList<User> getAdmin() {
        return admin;
    }

    public boolean newMember(User user){
        if (!this.isMember(user)){
            members.add(user);
        }
        return true;
    }

    public boolean removeMember(User user){
        for (int i = 0; i < members.size(); i++){
            if (user.id == members.get(i).id);
            members.remove(user);
            return true;
        }
        return false;
    }

    public String showMembers(){
        String membersInGroup = "\nMembers of group \"" + name + "\":";
        members = orderMembers();
        for (int i = 0; i < members.size(); i++){
            membersInGroup += '\n' + members.get(i).name;
        }
        System.out.println(membersInGroup);
        return membersInGroup;
    }

    public void showAdmins(){
        System.out.println("\nAdmins of group \"" + name + "\":");
        for (int i = 0; i < admin.size(); i++){
            System.out.println(admin.get(i).name);
        }
    }

    public String showMessages(){
        String messagesInConv = "\nMessages in group \"" + name + "\":";
        for (int i = 0; i < messages.size(); i++){
            Message msg = this.messages.get(i);
            messagesInConv += "\n" + msg.getMessage();
        }
        System.out.println(messagesInConv);
        return messagesInConv;
    }

    public void adminCount(){
        System.out.println("\nThere are " + admin.size() + " administrator(s) in this group.");
    }

    public boolean newAdmin(User newAdmin){
        if (!this.isMember(newAdmin)){
            System.out.println("\nUser is not member of group.");
            return false;
        }
        if (!this.isAdmin(newAdmin)){
            admin.add(newAdmin);
        }
        return true;
    }

    public boolean removeAdmin(User user){
        for (int i = 0; i < admin.size(); i++){
            if (user.id == admin.get(i).id);
            admin.remove(user);
            return true;
        }
        return false;
    }

}
