import org.junit.Test;
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
    public void conversationMembersTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        Conversation conv = user1.startConversation(user2);
        assertEquals("\nConversation between " + user1.name + " and " + user2.name + ".", conv.showMembers());
    }

    @Test
    public void memberCountTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        Conversation conv = user1.startConversation(user2);
        assertEquals(2, conv.memberCount());
    }
}
