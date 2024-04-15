package africa.semicolon.maverickblog.controllers;

import africa.semicolon.maverickblog.data.model.Post;
import africa.semicolon.maverickblog.dtos.requests.*;
import africa.semicolon.maverickblog.dtos.responses.*;
import africa.semicolon.maverickblog.exceptions.MaverickBlogException;
import africa.semicolon.maverickblog.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor

public class UserController {
    private UserServices userServices;


    @PatchMapping("/edit-post")
    public ResponseEntity<?> editPost(@RequestBody EditPostRequest editPostRequest){
        try{
            EditPostResponse response = userServices.editPost(editPostRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }
        catch (MaverickBlogException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete-post")
    public ResponseEntity<?> deletePost(DeletePostRequest deletePostRequest){
        try{
            String response = userServices.deletePost(deletePostRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }
        catch (MaverickBlogException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

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
        try{
            String response = userServices.deleteUser(deleteUserRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }
        catch (MaverickBlogException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            LoginResponse response = userServices.login(loginRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }
        catch (MaverickBlogException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/sign-out")
    public ResponseEntity<?> logout(@RequestBody LogoutRequest logoutRequest) {
        try{
            String response = userServices.logout(logoutRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }
        catch (MaverickBlogException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add-post")
    public ResponseEntity<?> addPost(@RequestBody CreatePostRequest postRequest) {
        try{
            AddPostResponse response = userServices.addPost(postRequest);
            return new ResponseEntity<>(response, CREATED);
        }
        catch (MaverickBlogException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find-posts-for/{name}")
    public ResponseEntity<?> findPostFor(@PathVariable("name") String username) {
        try{
            List<Post> response = userServices.findPostFor(username);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }
        catch (MaverickBlogException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/view-post")
    public ResponseEntity<?> viewPost(@RequestBody AddViewRequest viewRequest) {
        try{
            var response = userServices.viewPost(viewRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }
        catch (MaverickBlogException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("comment")
    public ResponseEntity<?> addComment(@RequestBody CommentRequest commentRequest) {
        try{
            var response = userServices.addComment(commentRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }
        catch (MaverickBlogException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
