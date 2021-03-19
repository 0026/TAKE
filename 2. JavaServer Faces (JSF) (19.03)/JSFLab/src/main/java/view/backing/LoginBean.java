/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Tomasz
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    private String username;
    private String password;
    private HtmlSelectBooleanCheckbox acceptCheckbox;
    private HtmlCommandButton loginButton;
    private boolean addititonalComment;
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        this.addititonalComment=false;
    }
    
    public String login(){
        if(username.equals("scott")&&password.equals("tiger")){
            this.addititonalComment=true;
            return "index";
        }
        if (username.equals(password)) {
            return "success";
        } else {
            return "failure";
        }
    }
    
    public void activateButton(ValueChangeEvent e){
        FacesContext context = FacesContext.getCurrentInstance();
        context.renderResponse();
        if (acceptCheckbox.isSelected())
            loginButton.setDisabled(false);
        else
            loginButton.setDisabled(true);
    }


    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the acceptCheckbox
     */
    public HtmlSelectBooleanCheckbox getAcceptCheckbox() {
        return acceptCheckbox;
    }

    /**
     * @param acceptCheckbox the acceptCheckbox to set
     */
    public void setAcceptCheckbox(HtmlSelectBooleanCheckbox acceptCheckbox) {
        this.acceptCheckbox = acceptCheckbox;
    }

    /**
     * @return the loginButton
     */
    public HtmlCommandButton getLoginButton() {
        return loginButton;
    }

    /**
     * @param loginButton the loginButton to set
     */
    public void setLoginButton(HtmlCommandButton loginButton) {
        this.loginButton = loginButton;
    }

    /**
     * @return the addititonalComment
     */
    public boolean isAddititonalComment() {
        return addititonalComment;
    }

    /**
     * @param addititonalComment the addititonalComment to set
     */
    public void setAddititonalComment(boolean addititonalComment) {
        this.addititonalComment = addititonalComment;
    }
    
}
