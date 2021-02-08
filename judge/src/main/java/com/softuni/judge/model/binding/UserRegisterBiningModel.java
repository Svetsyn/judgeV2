package com.softuni.judge.model.binding;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.SmartInitializingSingleton;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class UserRegisterBiningModel {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String git;

    public UserRegisterBiningModel() {
    }

    @Length(min = 2, message = "Username must be minimum 2 characters")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Length(min = 3, message = "Password must be minimum 3 characters")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    @Email(message = "Enter valid e-mail address")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Pattern(regexp = "https:\\/\\/github\\.com\\/.+")
    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }
}
