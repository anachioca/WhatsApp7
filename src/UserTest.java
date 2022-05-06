import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class UserTest {

    @Test
    public void checkUserIds() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");

        assertEquals(1, user1.id);
        assertEquals(2, user2.id);
    }

    @Test
    public void startConversationTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        Conversation conv = user1.startConversation(user2);
        assertEquals(user2, conv.getMembers().get(0));
        assertEquals(user1, conv.getMembers().get(1));
    }

    @Test
    public void createGroupTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        Group group = user1.createGroup(user2, "Grupinho");
        assertEquals(user2, group.getMembers().get(0));
        assertEquals(user1, group.getMembers().get(1));
    }

    @Test
    public void addMemberToGroupTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        User user3 = new User("Pará");
        Group group = user1.createGroup(user2, "Grupinho");
        user1.addMember(user3, group);
        assertEquals(user3, group.getMembers().get(2));
    }

    @Test
    public void removeMemberFromGroupTest() throws InterruptedException{
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        User user3 = new User("Pará");
        Group group = user1.createGroup(user2, "Grupinho");
        user1.addMember(user3, group);
        user1.removeMember(user3, group);
        for (int i = 0; i < group.getMembers().size(); i++){
            assertFalse(user3 == group.getMembers().get(i));
        }
    }

    @Test
    public void addAdminToGroupTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        Group group = user1.createGroup(user2, "Grupinho");
        user1.addAdmin(user2, group);
        assertEquals(user2, group.getAdmin().get(1));
    }

    @Test
    public void removeAdminFromGroupTest() throws InterruptedException{
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        Group group = user1.createGroup(user2, "Grupinho");

        user1.addAdmin(user2, group);
        user1.removeAdmin(user2, group);
        for (int i = 0; i < group.getAdmin().size(); i++){
            assertFalse(user2 == group.getAdmin().get(i));
        }

        assertFalse(user2.removeAdmin(user1, group));
    }

    @Test
    public void sendTextMessageTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        User user3 = new User("Pará");
        Conversation conv = user1.startConversation(user2);

        assertTrue(user1.sendTextMessage("Olá", conv));
        assertFalse(user3.sendTextMessage("Olá", conv));

        // Message from user1 was saved succesfully in chat
        assertEquals(user1, conv.getMessages().get(0).getFromUser());
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
    }
}
