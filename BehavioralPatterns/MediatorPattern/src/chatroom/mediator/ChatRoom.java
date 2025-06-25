package chatroom.mediator;

import chatroom.user.User;

import java.util.HashMap;
import java.util.Map;

public class ChatRoom implements ChatRoomMediator {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public void addUser(User user) {
        users.put(user.getName(), user);
    }

    @Override
    public void sendMessage(String message, User sender) {
        for (User user : users.values()) {
            if (!user.getName().equals(sender.getName())) {
                user.receive("Broadcast from " + sender.getName() + ": " + message);
            }
        }
    }

    @Override
    public void sendPrivateMessage(String message, User sender, String receiverName) {
        User receiver = users.get(receiverName);
        if (receiver != null) {
            receiver.receive("Private from " + sender.getName() + ": " + message);
        } else {
            sender.receive("User " + receiverName + " not found.");
        }
    }
}