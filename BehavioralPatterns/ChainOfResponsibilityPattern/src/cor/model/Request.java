package cor.model;

public class Request {

    private final String user;
    private final String action;
    private final String payload;

    public Request(String user, String action, String payload) {
        this.user = user;
        this.action = action;
        this.payload = payload;
    }

    public String getUser() {
        return user;
    }

    public String getAction() {
        return action;
    }

    public String getPayload() {
        return payload;
    }
}