/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named(value = "category")
public class CategoryBean implements Serializable{
    private List<Comment> comments;
    private List<Message> messages;
    @ManagedProperty(value = "#{param.cat}")
    private Category category;
    private Message currentlySelectedMessage;
    @Inject
    private UserBean user;
    public CategoryBean() {
        comments = new ArrayList<>();
        messages = new ArrayList<>();
    }
    
    public void addComment(String text) {
        Comment c = new Comment(user.getUser(), text);
        currentlySelectedMessage.addComment(c);
    }
    
    public void addMessage(String text) {
        category.addMessage(new Message(user.getUser(), text));
    }
    
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    
    public List<Comment> getComments() {
        return comments;
    }
    
    public List<Message> getMessages() {
        return messages;
    }
    
    public Category getCategory() {
        return category;
    }
    
    /**
     * sendes the user to category.xhtml. showing all messages from the selected category.
     * @param cat
     * @return category
     */
    public String selectedCategory(Category cat) {
        this.category = cat;
        return "category";
    }

    /**
     * used on category.xhtml for the link and updates the selectedmessage.
     * @param msg
     * @return message
     */
    public String selectedMessage(Message msg) {
        this.currentlySelectedMessage = msg;
        return "message";
    }

    public String categoryToString() {
        return category.toString();
    }
}