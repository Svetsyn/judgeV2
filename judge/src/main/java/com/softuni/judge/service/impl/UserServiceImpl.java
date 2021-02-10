package com.softuni.judge.service.impl;

import com.softuni.judge.model.entity.RoleNameEnum;
import com.softuni.judge.model.entity.User;
import com.softuni.judge.model.service.UserServiceModel;
import com.softuni.judge.repository.UserRepository;
import com.softuni.judge.security.CurrentUser;
import com.softuni.judge.service.RoleService;
import com.softuni.judge.service.UserSevice;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserSevice {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.currentUser = currentUser;
    }


    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        if (!user.getUsername().equals("Svetulkata")){

            user.setRole(roleService.findRole(RoleNameEnum.USER));
        }else {
            user.setRole(roleService.findRole(RoleNameEnum.ADMIN));
        }

        userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {

return userRepository.findByUsernameAndPassword(username,password)
        .map(user -> modelMapper.map(user,UserServiceModel.class)).orElse(null);
    }

    @Override
    public void login(UserServiceModel userServiceModel) {
        currentUser.setId(userServiceModel.getId());
        currentUser.setUsername(userServiceModel.getUsername());
        currentUser.setRoleNameEnum(userServiceModel.getRole().getRoleNameEnum());
    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
        currentUser.setRoleNameEnum(null);
    }
}
