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
@Named(value="servce")
public class Service {
    private List<User> users;
    private List<Category> categories;
    
    public Service() {
        users = new ArrayList<>();
        categories = new ArrayList<>();
        users.add(new User("mark", "password", false));
        users.add(new User("mike", "mike", true));
        users.add(new User("lizette","adhd",false));
        users.add(new User("Christine", "moew", false));
        categories.add(new Category("MIKE IS A FAG", "MIKE IS A MASSIVE FAG"));
        categories.add(new Category("SHIT", "ALL ABOUT SHTI"));
        System.out.println(categories);
    }
    
    public User getValidUser(User user) {
        User us = null;
        for(User u:users) {
            if(u.getUserName().equals(user.getUserName()) && u.getPassword().equals(user.getPassword())) {
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
}