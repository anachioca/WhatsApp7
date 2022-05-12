import org.junit.Test;

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
    public void addMemberToGroupTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        User user3 = new User("Pará");
        User user4 = new User("Feliz");
        Group group = user1.createGroup(user2, "Grupinho");
        boolean flag = false;

        // Admin tem permissão para adicionar membros:
        user1.addMember(user3, group);
        for (int i = 0; i < group.getMembers().size(); i++){
            if (user3 == group.getMembers().get(i)){
                flag = true;
            }
        }
        assertTrue(flag);

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
        flag = false;
        user3.addMember(user4, group);
        for (int i = 0; i < group.getMembers().size(); i++){
            if (user4 == group.getMembers().get(i)){
                flag = true;
            }
        }
        assertFalse(flag);
    }

    @Test
    public void removeMemberFromGroupTest(){
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        User user3 = new User("Pará");
        Group group = user1.createGroup(user2, "Grupinho");
        boolean flag = false;

        user1.addMember(user3, group);

        // Admin tem permissão para remover usuário:
        user1.removeMember(user3, group);
        for (int i = 0; i < group.getMembers().size(); i++){
            if (user3 == group.getMembers().get(i)){
                flag = true;
            }
        }
        assertFalse(flag);

        // Se uma pessoa que não estiver no grupo for removida, nada acontece:
        user1.removeMember(user3, group);
        for (int i = 0; i < group.getMembers().size(); i++){
            if (user3 == group.getMembers().get(i)){
                flag = true;
            }
        }
        assertFalse(flag);

        // Outros usuários não tem permissão para remover usuário:
        user1.addMember(user3, group);
        user3.removeMember(user2, group);
        for (int i = 0; i < group.getMembers().size(); i++){
            if (user3 == group.getMembers().get(i)){
                flag = true;
            }
        }
        assertTrue(flag);

    }

    @Test
    public void addAdminToGroupTest() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        User user3 = new User("Feliz");
        User user4 = new User("Pará");
        Group group = user1.createGroup(user2, "Grupinho");
        user1.addMember(user3, group);
        boolean flag = false;

        // Admins possuem permissão:
        user1.addAdmin(user2, group);
        for (int i = 0; i < group.getAdmin().size(); i++){
            if (user2 == group.getAdmin().get(i)){
                flag = true;
            }
        }
        assertTrue(flag);

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
        flag = false;
        user4.addAdmin(user3, group);
        for (int i = 0; i < group.getAdmin().size(); i++){
            if (user3 == group.getAdmin().get(i)){
                flag = true;
            }
        }
        assertFalse(flag);

        // Se o usuário não for membro do grupo, não é possível fazê-lo admin
        flag = false;
        user1.addAdmin(user4, group);
        for (int i = 0; i < group.getAdmin().size(); i++){
            if (user4 == group.getAdmin().get(i)){
                flag = true;
            }
        }
        assertFalse(flag);

        // Outros usuários não podem adicionar admins
        flag = false;
        user1.addMember(user4, group);
        user3.addAdmin(user4, group);
        for (int i = 0; i < group.getAdmin().size(); i++){
            if (user4 == group.getAdmin().get(i)){
                flag = true;
            }
        }
        assertFalse(flag);

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
}
