public class Main {

    public static void main(String[] args) {

        // Criando usuários
        User user1 = new User("Ana");
        User user2 = new User("Luiz");
        User user3 = new User("Feliz");
        User user4 = new User("Dani");

        // Criando Conversa entre dois usuários e testando
        Conversation user1_user2 = user1.startConversation(user2);
        user1.sendMessage("Oi Luiz!", user1_user2);
        user2.sendMessage("Oi Ana! Tudo bem?", user1_user2);
        user1_user2.showMessages();
        user1_user2.showMembers();

        // Criando grupo e testando
        Group timeStark = user1.createGroup(user3, "timeStark");
        user1.addMember(user4, timeStark);

        user1.sendMessage("Oi pessoal!", timeStark);
        user3.sendMessage("Que hora é a daily?", timeStark);
        user2.sendMessage("Eu sou do Stark?", timeStark);

        timeStark.showMessages();
        timeStark.showMembers();
    }

}
