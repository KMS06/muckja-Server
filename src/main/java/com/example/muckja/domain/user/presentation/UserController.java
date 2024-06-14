package com.example.muckja.domain.user.presentation;

import com.example.muckja.domain.user.presentation.dto.request.UserLoginRequest;
import com.example.muckja.domain.user.presentation.dto.request.UserSignupRequest;
import com.example.muckja.domain.user.presentation.dto.response.TokenResponse;
import com.example.muckja.domain.user.presentation.dto.response.UserProfileResponse;
import com.example.muckja.domain.user.service.UserLoginService;
import com.example.muckja.domain.user.service.UserProfileService;
import com.example.muckja.domain.user.service.UserSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/users")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserSignupService userSignupService;
    private final UserLoginService userLoginService;
    private final UserProfileService userProfileService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody @Valid UserSignupRequest request){
        userSignupService.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid UserLoginRequest request){
        return userLoginService.execute(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public UserProfileResponse profile(){
        return userProfileService.execute();
    }
}
