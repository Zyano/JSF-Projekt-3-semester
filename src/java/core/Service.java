/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package core;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named(value="service")
public class Service {
    
    private List<User> users;
    private List<Category> categories;
    
    // category creation!
    private String newCategoryTitle;
    private String newCategoryDesc;
    
    public Service() {
        users = new ArrayList<>();
        categories = new ArrayList<>();
        createUsers();
        createData();
        
        System.out.println(categories);
    }
    
    private void createUsers() {
        users.add(new User("mark", "password", false));
        users.add(new User("mike", "mike", true));
        users.add(new User("lizette","adhd",false));
        users.add(new User("Christine", "moew", false));
    }
    
    private void createData() {
        Category c = new Category(users.get(0),"IT Related","IT related news");
        Category c2 = new Category(users.get(1),"Random", "Anything goes here - random");
        categories.add(c);
        categories.add(c2);
        Message m = new Message(users.get(0), "Fønik Computers og fortrydelsesretten", "Artikel kommer her");
        Message m2 = new Message(users.get(1), "MAC ER BEDRE END PC, DERP!", "Artikel kommer her");
        c.addMessage(m);
        c.addMessage(m2);
        Comment cm = new Comment(users.get(3), "Unrelated exception");
        m.addComment(cm);
        
    }
    
    public User getValidUser(User user) {
        User us = null;
        for(User u:users) {
            if((u.getUserName().toLowerCase()).equals((user.getUserName().toLowerCase())) && u.getPassword().equals(user.getPassword())) {
                us = u ;
                break;
            }
        }
        return us;
    }
    
    public List<User> getUsers() {
        return users;
    }
    
    public void removeUser(User user) {
        if(users.contains(user)) {
            users.remove(user);
        }
    }
    
    public void addUser(User user) {
        if(!users.contains(user)) {
            users.add(user);
        }
    }
    
    public List<Category> getCategories() {
        return categories;
    }
    
    public void addCategory(Category c) {
        if(!this.categories.contains(c)) {
            this.categories.add(c);
        }
    }
    
    public void removeCategory(Category c) {
        if(this.categories.contains(c)) {
            this.categories.remove(c);
        }
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
    
    public String createNewCategory(User user) {
        Category c = new Category(user, newCategoryTitle, newCategoryDesc);
        categories.add(c);
        return "welcome";
    }
}