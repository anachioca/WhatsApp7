import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Conversation extends Chat{

    public Conversation(ArrayList<User> members){
        super(members);
    }

    public void showMessages(){
        System.out.println("\nMessages between " + members.get(0).name + " and " + members.get(1).name + ":\n");
        for (int i = 0; i < messages.size(); i++){
            Message msg = this.messages.get(i);
            System.out.println(msg.getMessage());
        }
    }

    public void showMembers(){
        members = orderMembers();
        System.out.println("\nConversation between " + members.get(0).name + " and " + members.get(1).name + ".");
    }

}
