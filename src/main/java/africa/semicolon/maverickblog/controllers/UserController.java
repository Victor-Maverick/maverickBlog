package africa.semicolon.maverickblog.controllers;

import africa.semicolon.maverickblog.dtos.requests.DeleteUserRequest;
import africa.semicolon.maverickblog.dtos.requests.RegisterRequest;
import africa.semicolon.maverickblog.dtos.responses.ApiResponse;
import africa.semicolon.maverickblog.dtos.responses.RegisterResponse;
import africa.semicolon.maverickblog.exceptions.MaverickBlogException;
import africa.semicolon.maverickblog.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor

public class UserController {
    private UserServices userServices;

    @PostMapping("/register-user")
    public ResponseEntity<?>register(@RequestBody RegisterRequest registerRequest) {
        try{
            RegisterResponse response = userServices.register(registerRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), CREATED);
        }
        catch (MaverickBlogException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("sign-off")
    public ResponseEntity<?> deleteUser(@RequestBody DeleteUserRequest deleteUserRequest) {
        try
    }
}
