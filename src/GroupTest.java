import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupTest {

    @Test
    public void createGroupTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        Group group = user1.createGroup(user2, "Grupinho");
        assertEquals(user2, group.getMembers().get(0));
        assertEquals(user1, group.getMembers().get(1));
    }

    @Test
    public void memberCountTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        User user3 = new User("Feliz");
        Group group = user1.createGroup(user2, "Grupinho");
        assertEquals(2, group.memberCount());
        user1.addMember(user3, group);
        assertEquals(3, group.memberCount());
    }

    @Test
    public void groupMembersTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        User user3 = new User("Feliz");
        User user4 = new User("Pará");
        Group group = user1.createGroup(user2, "Grupinho");
        user1.addMember(user3, group);
        user1.addMember(user4, group);

        ArrayList<User> members = new ArrayList<User>(4);
        members.add(user2);
        members.add(user1);
        members.add(user3);
        members.add(user4);
        assertEquals(members, group.getMembers());
    }

    @Test
    public void groupAdminsTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        User user3 = new User("Feliz");
        Group group = user1.createGroup(user2, "Grupinho");
        user1.addMember(user3, group);
        user1.addAdmin(user2, group);

        ArrayList<User> admins = new ArrayList<User>(4);
        admins.add(user1);
        admins.add(user2);
        assertEquals(admins, group.getAdmin());
    }

    @Test
    public void addMemberToGroupTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        User user3 = new User("Pará");
        User user4 = new User("Feliz");
        Group group = user1.createGroup(user2, "Grupinho");

        // Admin tem permissão para adicionar membros:
        user1.addMember(user3, group);
        assertTrue(group.isMember(user3));

        // Se usuário que já é membro for adicionado novamente:
        user1.addMember(user3, group);
        int count = 0;
        for (int i = 0; i < group.getMembers().size(); i++){
            if (user3 == group.getMembers().get(i)){
                count++;
            }
        }
        assertEquals(1, count);

        // Outros usuários não possuem essa permissão:
        user3.addMember(user4, group);
        assertFalse(group.isMember(user4));
    }

    @Test
    public void removeMemberFromGroupTest(){
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        User user3 = new User("Pará");
        Group group = user1.createGroup(user2, "Grupinho");

        user1.addMember(user3, group);

        // Admin tem permissão para remover usuário:
        assertTrue(user1.removeMember(user3, group));
        assertFalse(group.isMember(user3));

        // Se uma pessoa que não estiver no grupo for removida, nada acontece:
        assertFalse(user1.removeMember(user3, group));
        assertFalse(group.isMember(user3));
        assertTrue(group.isMember(user1));
        assertTrue(group.isMember(user2));

        // Outros usuários não tem permissão para remover usuário:
        user1.addMember(user3, group);
        assertFalse(user3.removeMember(user2, group));
        assertTrue(group.isMember(user2));

    }

    @Test
    public void addAdminToGroupTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        User user3 = new User("Feliz");
        User user4 = new User("Pará");
        Group group = user1.createGroup(user2, "Grupinho");
        user1.addMember(user3, group);

        // Admins possuem permissão:
        user1.addAdmin(user2, group);
        assertTrue(group.isAdmin(user2));

        // Adicionando usuário que já é admin:
        user1.addAdmin(user2, group);
        int count = 0;
        for (int i = 0; i < group.getAdmin().size(); i++){
            if (user2 == group.getAdmin().get(i)){
                count++;
            }
        }
        assertEquals(1, count);

        // Pessoas de fora do grupo não podem eleger admins
        user4.addAdmin(user3, group);
        assertFalse(group.isAdmin(user3));

        // Se o usuário não for membro do grupo, não é possível fazê-lo admin
        user1.addAdmin(user4, group);
        assertFalse(group.isAdmin(user4));

        // Outros usuários não podem adicionar admins
        user1.addMember(user4, group);
        user3.addAdmin(user4, group);
        assertFalse(group.isAdmin(user4));

    }

    @Test
    public void removeAdminFromGroupTest() throws InterruptedException{
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        User user3 = new User("Feliz");
        Group group = user1.createGroup(user2, "Grupinho");

        // Apenas um admin pod remover outro admin:
        user1.addAdmin(user2, group);
        assertTrue(group.isAdmin(user2));
        user1.removeAdmin(user2, group);
        assertFalse(group.isAdmin(user2));

        // Outros usuários não possuem essa permissão:
        user1.addMember(user3, group);
        user1.addAdmin(user2, group);
        user3.removeAdmin(user2, group);
        assertTrue(group.isAdmin(user2));
    }
}
