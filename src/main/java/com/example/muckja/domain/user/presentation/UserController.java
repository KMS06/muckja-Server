package com.example.muckja.domain.user.presentation;

import com.example.muckja.domain.user.presentation.dto.request.UserSignupRequest;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void signup(@RequestBody @Valid UserSignupRequest request){
        userSignupService.execute(request);
    }
}
