package core;

import java.util.ArrayList;
import java.util.List;

public class Category {
    
    private String title;
    private String desc;
    private List<Message> messages;
    private User user;
    
    public Category(User user,String title, String desc) {
        messages = new ArrayList<>();
        this.title = title;
        this.desc = desc;
        this.user = user;
    }
    
    public void removeMessage(Message message) {
        if (messages.contains(message)) {
            messages.remove(message);
            message.removeAllComments();
        }
    }
    
    public void addMessage(Message message) {
        if (!messages.contains(message)) {
            messages.add(message);
        }
    }
    
    public void removeAllMessages() {
        if (messages.size() > 0) {
            for (Message m : messages) {
                m.removeAllComments();
            }
        }
    }
    
    public List<Message> getMessages() {
        return messages;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDesc() {
        return desc;
    }
    
    @Override
    public String toString() {
        return "Category{" + "title=" + title + ", desc=" + desc +" }";
    }
    
    public User getUser() {
        return user;
    }
}