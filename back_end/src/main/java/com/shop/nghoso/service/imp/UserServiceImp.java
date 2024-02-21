package com.shop.nghoso.service.imp;

import com.shop.nghoso.entity.UserEntity;
import com.shop.nghoso.payload.request.SignUpLogInRequest;
import com.shop.nghoso.repository.UserRepository;
import com.shop.nghoso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean check(SignUpLogInRequest signUpLogInRequest) {
        return userRepository.existsByEmail(signUpLogInRequest.getEmail());
    }

    @Override
    public boolean addUser(SignUpLogInRequest signUpLogInRequest) {
        boolean isSuccess = false;
        try {
            UserEntity usersEntity = new UserEntity();
            usersEntity.setUsername(signUpLogInRequest.getUsername());
            usersEntity.setEmail(signUpLogInRequest.getEmail());
            usersEntity.setPassword(signUpLogInRequest.getPassword());
            userRepository.save(usersEntity);
            isSuccess = true;
        }catch (Exception e){
            System.out.println("Lỗi " + e.getLocalizedMessage());
        }
        return isSuccess;
    }

    @Override
    public boolean passCompare(SignUpLogInRequest signUpLogInRequest) {
        UserEntity usersEntity = userRepository.findByEmail(signUpLogInRequest.getEmail());
        if (usersEntity.getPassword().equals(signUpLogInRequest.getPassword())){
            return true;
        }
        return false;
    }
}
