package chatroom.user;

import chatroom.mediator.ChatRoomMediator;

public class ConcreteUser extends User {

    public ConcreteUser(ChatRoomMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        mediator.sendMessage(message, this);
    }

    @Override
    public void sendPrivate(String message, String to) {
        mediator.sendPrivateMessage(message, this, to);
    }

    @Override
    public void receive(String message) {
        System.out.println("[" + name + "] " + message);
    }
}