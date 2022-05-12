import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;


public class ConversationTest {

    @Test
    public void startConversationTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        Conversation conv = user1.startConversation(user2);
        assertEquals(user2, conv.getMembers().get(0));
        assertEquals(user1, conv.getMembers().get(1));
    }
}
