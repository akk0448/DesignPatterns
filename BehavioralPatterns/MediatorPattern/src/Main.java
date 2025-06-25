import chatroom.mediator.ChatRoom;
import chatroom.user.ConcreteUser;
import chatroom.user.User;

public class Main {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User alice = new ConcreteUser(chatRoom, "Alice");
        User bob = new ConcreteUser(chatRoom, "Bob");
        User charlie = new ConcreteUser(chatRoom, "Charlie");

        chatRoom.addUser(alice);
        chatRoom.addUser(bob);
        chatRoom.addUser(charlie);

        alice.send("Hello everyone!");
        bob.sendPrivate("Hey Alice!", "Alice");
        charlie.sendPrivate("Bob, are you there?", "Bob");
        bob.sendPrivate("Yes Charlie!", "Charlie");
        charlie.sendPrivate("Someone not here", "Ghost");
    }
}