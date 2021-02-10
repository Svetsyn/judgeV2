package com.softuni.judge.service;

import com.softuni.judge.model.service.UserServiceModel;

public interface UserSevice {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void login(UserServiceModel userServiceModel);

    void logout();
}
