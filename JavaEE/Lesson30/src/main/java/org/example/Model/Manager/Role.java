package org.example.Model.Manager;

public enum Role {
    DIRECTOR ("Директор"),
    DEPUTY_DIRECTOR ("Заместитель директора"),
    ADMINISTRATOR ("Администратор");

    private String title;

    Role(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
