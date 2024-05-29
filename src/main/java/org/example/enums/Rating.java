package org.example.enums;

public enum Rating {
    G("G"),
    PG("PG"),
    PG13("PG-17"),
    R("R"),
    NC17("NC-17");

    private String title;

    Rating(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
