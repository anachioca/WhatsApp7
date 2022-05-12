import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class MessageTest {

    @Test
    public void sendTextMessageTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        User user3 = new User("Pará");
        Conversation conv = user1.startConversation(user2);

        assertTrue(user1.sendTextMessage("Olá", conv));
        assertFalse(user3.sendTextMessage("Olá, Ana!", conv));

        // Message from user1 was saved succesfully in chat
        assertEquals(user1, conv.getMessages().get(0).getFromUser());
        assertEquals("Olá", conv.getMessages().get(0).getContent());
    }

    @Test
    public void sendImageMessageTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        User user3 = new User("Pará");
        Conversation conv = user1.startConversation(user2);

        assertTrue(user1.sendImageMessage(conv));
        assertFalse(user3.sendImageMessage(conv));

        // Message from user1 was saved succesfully in chat
        assertEquals(user1, conv.getMessages().get(0).getFromUser());
        assertEquals("IMAGE", conv.getMessages().get(0).getContent());
    }

    @Test
    public void sendAudioMessageTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        User user3 = new User("Pará");
        Conversation conv = user1.startConversation(user2);

        assertTrue(user1.sendAudioMessage(conv));
        assertFalse(user3.sendAudioMessage(conv));

        // Message from user1 was saved succesfully in chat
        assertEquals(user1, conv.getMessages().get(0).getFromUser());
        assertEquals("PLAY AUDIO", conv.getMessages().get(0).getContent());
    }

    // timestamp? formato de impressão?
}
