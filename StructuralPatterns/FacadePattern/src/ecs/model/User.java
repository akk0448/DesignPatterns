package ecs.model;

public class User {

    private final String name;
    private final String email;
    private final String address;

    public User(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return String.format("👤 %s | 📧 %s | 📍 %s", name, email, address);
    }
}