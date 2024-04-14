package africa.semicolon.maverickblog.controllers;

import africa.semicolon.maverickblog.data.model.Comment;
import africa.semicolon.maverickblog.data.model.Post;
import africa.semicolon.maverickblog.data.repository.Comments;
import africa.semicolon.maverickblog.data.repository.Posts;
import africa.semicolon.maverickblog.data.repository.Users;
import africa.semicolon.maverickblog.data.repository.Views;
import africa.semicolon.maverickblog.dtos.requests.*;
import africa.semicolon.maverickblog.services.UserServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@WebMvcTest

public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserServices userServices;

    @Test
    public void registerShouldReturnCreatedTest()throws Exception{
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username4");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        Mockito.when(userServices.register(registerRequest));

        this.mockMvc.perform(get("/register"))
                .andExpect(status().isCreated());

    }
//    @Autowired
//    UserController userController;
//    @Autowired
//    Users users;
//    @Autowired
//    Posts posts;
//    @Autowired
//    Views views;
//    @Autowired
//    Comments comments;
//
//    @BeforeEach
//    public void collapseAll(){
//        users.deleteAll();
//    }
//
//
//    @Test
//    public void commentOnPost_listOfCommentTest(){
//        RegisterRequest registerRequest = new RegisterRequest();
//        registerRequest.setUsername("username4");
//        registerRequest.setPassword("password");
//        registerRequest.setEmail("vic@gmail.com");
//        registerRequest.setPhoneNumber("08148624687");
//        userController.register(registerRequest);
//        assertEquals(1, users.count());
//
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("username4");
//        loginRequest.setPassword("password");
//        userController.login(loginRequest);
//
//        CreatePostRequest postRequest = new CreatePostRequest();
//        postRequest.setTitle("new note");
//        postRequest.setContent("new content");
//        postRequest.setAuthor("username4");
//        userController.addPost(postRequest);
//        Post post = posts.findByAuthor("username4").getFirst();
//        CommentRequest commentRequest =  new CommentRequest();
//        commentRequest.setComment("new comment");
//        commentRequest.setCommenterName("username4");
//        commentRequest.setPostId(post.getId());
//        userController.addComment(commentRequest);
//        assertEquals(1, comments.count());
//        assertEquals(1, posts.findByAuthor("username4").getFirst().getComments().size());
//
//
//    }
//    @Test
//    public void viewPost_listOfViewsIncreaseTest(){
//        RegisterRequest registerRequest = new RegisterRequest();
//        registerRequest.setUsername("username4");
//        registerRequest.setPassword("password");
//        registerRequest.setEmail("vic@gmail.com");
//        registerRequest.setPhoneNumber("08148624687");
//        userController.register(registerRequest);
//        assertEquals(1, users.count());
//
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("username4");
//        loginRequest.setPassword("password");
//        userController.login(loginRequest);
//
//        CreatePostRequest postRequest = new CreatePostRequest();
//        postRequest.setTitle("new note");
//        postRequest.setContent("new content");
//        postRequest.setAuthor("username4");
//        userController.addPost(postRequest);
//        assertEquals(1, posts.count());
//        AddViewRequest viewRequest = new AddViewRequest();
//        viewRequest.setViewerName("username4");
//        Post post = posts.findByAuthor("username4").getFirst();
//        viewRequest.setPostId(post.getId());
//        userController.viewPost(viewRequest);
//        assertEquals(1, views.count());
//    }
//    @Test
//    public void addPostTest(){
//        RegisterRequest registerRequest = new RegisterRequest();
//        registerRequest.setUsername("username4");
//        registerRequest.setPassword("password");
//        registerRequest.setEmail("vic@gmail.com");
//        registerRequest.setPhoneNumber("08148624687");
//        userController.register(registerRequest);
//        assertEquals(1, users.count());
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("username4");
//        loginRequest.setPassword("password");
//        userController.login(loginRequest);
//        CreatePostRequest postRequest = new CreatePostRequest();
//        postRequest.setTitle("new note");
//        postRequest.setContent("new content");
//        postRequest.setAuthor("username4");
//        userController.addPost(postRequest);
//        assertEquals(1, users.findByUsername("username4").getPosts().size());
//
//    }
//    @Test
//    public void registerUserTest(){
//        RegisterRequest registerRequest = new RegisterRequest();
//        registerRequest.setUsername("username4");
//        registerRequest.setPassword("password");
//        registerRequest.setEmail("vic@gmail.com");
//        registerRequest.setPhoneNumber("08148624687");
//        userController.register(registerRequest);
//        assertEquals(1, users.count());
//    }
//
//    @Test
//    public void deleteUserTest(){
//        RegisterRequest registerRequest = new RegisterRequest();
//        registerRequest.setUsername("username4");
//        registerRequest.setPassword("password");
//        registerRequest.setEmail("vic@gmail.com");
//        registerRequest.setPhoneNumber("08148624687");
//        userController.register(registerRequest);
//        assertEquals(1, users.count());
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("username4");
//        loginRequest.setPassword("password");
//        userController.login(loginRequest);
//        DeleteUserRequest deleteUserRequest = new DeleteUserRequest();
//        deleteUserRequest.setUsername("username4");
//        userController.deleteUser(deleteUserRequest);
//        assertEquals(0, users.count());
//    }
//
//    @Test
//    public void userLoginTest(){
//        RegisterRequest registerRequest = new RegisterRequest();
//        registerRequest.setUsername("username4");
//        registerRequest.setPassword("password");
//        registerRequest.setEmail("vic@gmail.com");
//        registerRequest.setPhoneNumber("08148624687");
//        userController.register(registerRequest);
//        assertEquals(1, users.count());
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("username4");
//        loginRequest.setPassword("password");
//        userController.login(loginRequest);
//        assertTrue(users.findByUsername("username4").isLoggedIn());
//    }
//    @Test
//    public void LogoutTest(){
//        RegisterRequest registerRequest = new RegisterRequest();
//        registerRequest.setUsername("username4");
//        registerRequest.setPassword("password");
//        registerRequest.setEmail("vic@gmail.com");
//        registerRequest.setPhoneNumber("08148624687");
//        userController.register(registerRequest);
//        assertEquals(1, users.count());
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername("username4");
//        loginRequest.setPassword("password");
//        userController.login(loginRequest);
//        assertTrue(users.findByUsername("username4").isLoggedIn());
//        LogoutRequest logoutRequest = new LogoutRequest();
//        logoutRequest.setUsername("username4");
//        userController.logout(logoutRequest);
//        assertFalse(users.findByUsername("username4").isLoggedIn());
//    }




}