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
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named(value = "category")
public class CategoryBean implements Serializable{
    private List<Comment> comments;
    private List<Message> messages;
    private Category category;
    private Message currentlySelectedMessage;
    @Inject
    private UserBean user;
    @Inject
    private Service service;
    
    // create Message
    private String newMessageTitle;
    private String newMessageText;
    
    // create Category
    private String newCategoryTitle;
    private String newCategoryDesc;
    
    // create Comment
    private String newCommentText;
    
    /**
     * creates the message and comment lists.
     */
    public CategoryBean() {
        comments = new ArrayList<>();
        messages = new ArrayList<>();
    }
    
    /**
     * Creates a comment on the currently selected message(news post).
     * @param text
     */
    public void addComment(String text) {
        Comment c = new Comment(user.getUser(), text);
        currentlySelectedMessage.addComment(c);
    }
    
    /**
     * adds a message(news post) to the currently selected category. admin use case?
     * @param text
     * @param title
     */
    public void addMessage(String title, String text) {
        category.addMessage(new Message(user.getUser(), title, text));
    }
    
    /**
     * for admin usecase if a comment is deleted.
     * @param comments
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    
    /**
     * Admin usecase for deletion of messages(news posts)
     * @param messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
    /**
     * Sets the currently selected category.
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
    }
    
    /**
     * Gets all the comments on a given message(news post)
     * @return List<Comment>
     */
    public List<Comment> getComments() {
        System.out.println(comments);
        return comments;
    }
    
    /**
     * Gets the Messages (news posts)
     * @return List<Message>
     */
    public List<Message> getMessages() {
        return messages;
    }
    
    /**
     * Does not appear to have a usecase. delete ?
     * @return Category
     */
    public Category getCategory() {
        return category;
    }
    
    /**
     * Sends the user to category.xhtml. showing all messages from the selected category.
     * @param cat
     * @return category
     */
    public String selectedCategory(Category cat) {
        this.category = cat;
        this.messages = category.getMessages();
        return "category";
    }
    
    /**
     * used on category.xhtml for the link and updates the selectedmessage.
     * @param msg
     * @return message
     */
    public String selectedMessage(Message msg) {
        this.currentlySelectedMessage = msg;
        this.comments = msg.getComments();
        return "message";
    }
    
    /**
     * Should be changed to return the currently selected Category and the amount of submessages.
     * @return
     */
    public String categoryToString() {
        return category.toString();
    }
    /**
     * Description of the category selected
     * @return String
     */
    public String getCategoryDesc(){
        return category.getDesc();
    }
    
    /**
     * Tittle of the Category currently selected.
     * @return String
     */
    public String getCategoryTittle(){
        return category.getTitle();
    }
    
    public String getMessageUserAndTitle(Message msg) {
        return msg.getUsernameTitleToString();
    }
    
    public String getMessageTitle() {
        return currentlySelectedMessage.getTitle();
    }
    
    public String getMessageText() {
        return currentlySelectedMessage.getText();
    }
    
    public String deleteComment(Comment comment) {
        currentlySelectedMessage.removeComment(comment);
        return "";
    }
    
    public String getNewCategoryTitle() {
        return newCategoryTitle;
    }
    
    public void setNewCategoryTitle(String newCategoryTitle) {
        this.newCategoryTitle = newCategoryTitle;
    }
    
    public String getNewCategoryDesc() {
        return newCategoryDesc;
    }
    
    public void setNewCategoryDesc(String newCategoryDesc) {
        this.newCategoryDesc = newCategoryDesc;
    }
    
    public String createNewCategory() {
        service.createCategory(user.getUser(), newCategoryTitle, newCategoryDesc);
        return "welcome";
    }
    
    public String getNewMessageTitle() {
        return newMessageTitle;
    }
    
    public void setNewMessageTitle(String newMessageTitle) {
        this.newMessageTitle = newMessageTitle;
    }
    
    public String getNewMessageText() {
        return newMessageText;
    }
    
    public void setNewMessageText(String newMessageText) {
        this.newMessageText = newMessageText;
    }
    
    public String createMessage() {
        service.createMessage(category, user.getUser() , newMessageTitle, newMessageText);
        return "category";
    }
    
    public String createComment() {
        service.createComment(currentlySelectedMessage, user.getUser(), newCommentText);
        return "message";
    }
}