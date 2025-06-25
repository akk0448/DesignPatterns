package chatroom.mediator;

import chatroom.user.User;

public interface ChatRoomMediator {

    void sendMessage(String message, User sender);

    void sendPrivateMessage(String message, User sender, String receiverName);

    void addUser(User user);
}