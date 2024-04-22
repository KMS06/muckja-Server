package com.example.muckja.domain.user.service;

import com.example.muckja.domain.user.domain.User;
import com.example.muckja.domain.user.facade.UserFacade;
import com.example.muckja.domain.user.presentation.dto.request.UserLoginRequest;
import com.example.muckja.domain.user.presentation.dto.response.TokenResponse;
import com.example.muckja.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserLoginService {
    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse execute(UserLoginRequest request){
        User user = userFacade.findByEmail(request.getEmail());
        userFacade.checkPassword(user, request.getPassword());

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(request.getEmail()))
                .build();
    }
}
