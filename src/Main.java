public class Main {

    public static void main(String[] args) {

        // Criando usuários
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        User user3 = new User("Feliz");
        User user4 = new User("Dani");

        // Criando Conversa entre dois usuários e testando
        Conversation user1_user2 = user1.startConversation(user2);
        user1.sendTextMessage("Oi Luiz!", user1_user2);
        user2.sendTextMessage("Oi Ana! Tudo bem?", user1_user2);
        user2.sendImageMessage(user1_user2);
        user1_user2.showMessages();
        user1_user2.showMembers();

        // Criando grupo e testando
        Group timeStark = user1.createGroup(user3, "timeStark");
        user1.addMember(user4, timeStark);

        user1.sendTextMessage("Oi pessoal!", timeStark);
        user3.sendTextMessage("Que hora é a daily?", timeStark);
//        user2.sendTextMessage("Eu sou do Stark?", timeStark);
        user1.sendAudioMessage(timeStark);

        timeStark.showMessages();
        timeStark.showMembers();
        timeStark.showAdmins();
        timeStark.adminCount();
        user1.addAdmin(user3, timeStark);
        user1.removeMember(user4, timeStark);
        timeStark.showMembers();
        timeStark.showAdmins();
        timeStark.adminCount();
    }

}
