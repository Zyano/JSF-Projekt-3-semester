/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package core;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@SessionScoped
@Named(value="userBean")
public class UserBean implements Serializable{
    private User user = new User();
    @Inject
    private Service service;
    
    
    public String login() {
        User validUser = service.getValidUser(user);
        if(validUser !=null) {
            this.user = validUser;
            return "welcome";
        } else {
            return "error";
        }
    }
    
    public User getUser() {
        return user;
    }
    
    public String createUser() {
        service.addUser(user);
        return login();
    }
    
    public boolean isAdmin() {
        return user.isAdmin();
    }
    
    // we need the user object when a category is created.
    public boolean isCurrentUser(User user) {
        return !user.equals(this.user);
    }
    
    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "index";
    }
}