import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Conversation extends Chat{

    public Conversation(ArrayList<User> members){
        super(members);
    }

    public String showMessages(){
        String messagesInConv = "\nMessages between " + members.get(0).name + " and " + members.get(1).name + ":";
        for (int i = 0; i < messages.size(); i++){
            Message msg = this.messages.get(i);
            messagesInConv += "\n" + msg.getMessage();
        }
        System.out.println(messagesInConv);
        return messagesInConv;
    }

    public String showMembers(){
        members = orderMembers();
        String membersInConv = "\nConversation between " + members.get(0).name + " and " + members.get(1).name + ".";
        System.out.println(membersInConv);
        return membersInConv;
    }

}
