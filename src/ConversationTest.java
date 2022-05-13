import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversationTest {

    @Test
    public void startConversationTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        Conversation conv = user1.startConversation(user2);
        assertEquals(user2, conv.getMembers().get(0));
        assertEquals(user1, conv.getMembers().get(1));
    }

    @Test
    public void memberCountTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        Conversation conv = user1.startConversation(user2);
        assertEquals(2, conv.memberCount());
    }

    @Test
    public void convMembersTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        Conversation conv = user1.startConversation(user2);

        ArrayList<User> members = new ArrayList<User>(4);
        members.add(user2);
        members.add(user1);
        assertEquals(members, conv.getMembers());
    }
}
