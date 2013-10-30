package core;

import java.util.List;

public class Category {

    private String title;
    private String desc;
    private List<Message> messages;

    public Category(String title, String desc) {
        this.title = title;
        this.desc = desc;
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
}