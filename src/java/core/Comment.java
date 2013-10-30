package core;

public class Comment {

    private User user;
    private String text;

    public Comment(User user, String text) {
        this.user = user;
        this.text = text;

    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUser(User user) {
        if (this.user != user) {
            this.user = user;
        }
    }
    
    public String toString() {
        return user.getUserName()+": " + text;
    }
}