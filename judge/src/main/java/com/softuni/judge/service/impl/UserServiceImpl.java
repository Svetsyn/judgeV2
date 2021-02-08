package com.softuni.judge.service.impl;

import com.softuni.judge.model.entity.RoleNameEnum;
import com.softuni.judge.model.entity.User;
import com.softuni.judge.model.service.UserServiceModel;
import com.softuni.judge.repository.UserRepository;
import com.softuni.judge.service.RoleService;
import com.softuni.judge.service.UserSevice;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserSevice {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }


    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        user.setRole(roleService.findRole(RoleNameEnum.USER));

        userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {

return userRepository.findByUsernameAndPassword(username,password)
        .map(user -> modelMapper.map(user,UserServiceModel.class)).orElse(null);
    }
}
