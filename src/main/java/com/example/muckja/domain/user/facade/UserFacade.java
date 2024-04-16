package com.example.muckja.domain.user.facade;

import com.example.muckja.domain.user.domain.User;
import com.example.muckja.domain.user.domain.repositry.UserRepository;
import com.example.muckja.domain.user.exception.UserExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;

    public void checkUserExist(String email){
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent())
            throw UserExistException.EXCEPTION;
    }
}
