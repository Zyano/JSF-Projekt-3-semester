package core;

import java.util.ArrayList;
import java.util.List;

public class Message {
    
    private String text;
    
    private User user;
    private List<Comment> comments;
    
    public Message(User user, String text) {
        comments = new ArrayList<>();
        this.user = user;
        this.text = text;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        if (!this.user.equals(user)) {
            this.user = user;
        }
    }
    
    public List<Comment> getComments() {
        return comments;
    }
    
    public void addComment(Comment comment) {
        if (!this.comments.contains(comment)) {
            comments.add(comment);
        }
    }
    
    public void removeComment(Comment comment) {
        if (this.comments.contains(comment)) {
            comments.remove(comment);
            comment.setUser(null);
        }
    }
    
    public void removeAllComments() {
        for(Comment c: comments) {
            removeComment(c);
        }
    }
    
    public String toString() {
        return user.getUserName()+": " +text;
    }
}