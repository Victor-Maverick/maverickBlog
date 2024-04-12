package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.repository.Comments;
import africa.semicolon.maverickblog.data.repository.Posts;
import africa.semicolon.maverickblog.data.repository.Users;
import africa.semicolon.maverickblog.dtos.requests.*;
import africa.semicolon.maverickblog.exceptions.MaverickBlogException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServicesTest {
    @Autowired
    UserServices userServices;
    @Autowired
    Users users;
    @Autowired
    Comments comments;
    @Autowired
    Posts posts;
    @BeforeEach
    public void setUp() {
        comments.deleteAll();
        users.deleteAll();
        posts.deleteAll();
    }

    @Test
    public void registerUser_userCountIncreasesTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("08148624687");
        var user = userServices.register(registerRequest);
        assertNotNull(user.getId());
        assertEquals(1, users.count());
    }

    @Test
    public void addPostTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("08148624687");
        userServices.register(registerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        userServices.login(loginRequest);
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("new note");
        postRequest.setContent("new content");
        postRequest.setAuthor("username");
        userServices.addPost(postRequest);
        assertEquals(1, userServices.findPostFor("username").size());
    }
    @Test
    public void addPostWithoutLogin_throwsExceptionTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("08148624687");
        userServices.register(registerRequest);
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("new note");
        postRequest.setContent("new content");
        postRequest.setAuthor("username");
        try {
            userServices.addPost(postRequest);
        }
        catch (MaverickBlogException e){
            assertEquals(e.getMessage(), "log in first");
        }
        assertEquals(1, userServices.findPostFor("username").size());


    }


    @Test
    public void viewPostWhileLoggedInTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username4");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("08148624687");
        userServices.register(registerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username4");
        loginRequest.setPassword("password");
        userServices.login(loginRequest);
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("new note");
        postRequest.setContent("new content");
        postRequest.setAuthor("username4");
        var postResponse = userServices.addPost(postRequest);

        RegisterRequest registerRequest2 = new RegisterRequest();
        registerRequest2.setUsername("username2");
        registerRequest2.setPassword("password2");
        registerRequest2.setEmail("vic2@gmail.com");
        registerRequest2.setPhoneNumber("09148624687");
        userServices.register(registerRequest2);

        LoginRequest loginRequest2 = new LoginRequest();
        loginRequest2.setUsername("username2");
        loginRequest2.setPassword("password2");
        userServices.login(loginRequest2);

        AddViewRequest viewRequest = new AddViewRequest();
        viewRequest.setViewerName("username2");
        viewRequest.setPostId(postResponse.getId());
        userServices.viewPost(viewRequest);
        assertEquals(1, posts.count());
        assertEquals(1, userServices.findPostFor("username4").size());
    }

    @Test
    public void viewPostWithoutLogIn_throwsExceptionTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username4");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("08148624687");
        userServices.register(registerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username4");
        loginRequest.setPassword("password");
        userServices.login(loginRequest);
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("new note");
        postRequest.setContent("new content");
        postRequest.setAuthor("username4");
        var postResponse = userServices.addPost(postRequest);

        RegisterRequest registerRequest2 = new RegisterRequest();
        registerRequest2.setUsername("username2");
        registerRequest2.setPassword("password2");
        registerRequest2.setEmail("vic2@gmail.com");
        registerRequest2.setPhoneNumber("09148624687");
        userServices.register(registerRequest2);
        AddViewRequest viewRequest = new AddViewRequest();
        viewRequest.setViewerName("username2");
        viewRequest.setPostId(postResponse.getId());
        try {
            userServices.viewPost(viewRequest);
        }catch (MaverickBlogException e){
            assertEquals(e.getMessage(), "log in first");
        }
        assertEquals(1, posts.count());
        assertEquals(1, userServices.findPostFor("username4").size());
    }

    @Test
    public void addCommentTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username4");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("08148624687");
        userServices.register(registerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username4");
        loginRequest.setPassword("password");
        userServices.login(loginRequest);
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("new note");
        postRequest.setContent("new content");
        postRequest.setAuthor("username4");
        var postResponse = userServices.addPost(postRequest);

        RegisterRequest registerRequest2 = new RegisterRequest();
        registerRequest2.setUsername("username2");
        registerRequest2.setPassword("password2");
        registerRequest2.setEmail("vic2@gmail.com");
        registerRequest2.setPhoneNumber("09148624687");
        userServices.register(registerRequest2);
        LoginRequest loginRequest2 = new LoginRequest();
        loginRequest2.setUsername("username2");
        loginRequest2.setPassword("password2");
        userServices.login(loginRequest2);

        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setPostId(postResponse.getId());
        commentRequest.setComment("new comment");
        commentRequest.setCommenterName("username2");
        userServices.addComment(commentRequest);
        assertEquals(1, comments.count());
    }

    @Test
    public void deleteCommentTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username4");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("08148624687");
        userServices.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username4");
        loginRequest.setPassword("password");
        userServices.login(loginRequest);

        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("new note");
        postRequest.setContent("new content");
        postRequest.setAuthor("username4");
        var postResponse = userServices.addPost(postRequest);

        RegisterRequest registerRequest2 = new RegisterRequest();
        registerRequest2.setUsername("username2");
        registerRequest2.setPassword("password2");
        registerRequest2.setEmail("vic2@gmail.com");
        registerRequest2.setPhoneNumber("09148624687");
        userServices.register(registerRequest2);

        LoginRequest loginRequest2 = new LoginRequest();
        loginRequest2.setUsername("username2");
        loginRequest2.setPassword("password2");
        userServices.login(loginRequest2);

        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setPostId(postResponse.getId());
        commentRequest.setComment("new comment");
        commentRequest.setCommenterName("username2");
        var commentResponse = userServices.addComment(commentRequest);
        assertEquals(1, comments.count());
        DeleteCommentRequest deleteRequest = new DeleteCommentRequest();
        deleteRequest.setPostId(postResponse.getId());
        deleteRequest.setCommentId(commentResponse.getId());
        deleteRequest.setAuthor("username2");
        userServices.deleteComment(deleteRequest);
        assertEquals(0, comments.count());
    }

    @Test
    public void editPostTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username4");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("08148624687");
        userServices.register(registerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username4");
        loginRequest.setPassword("password");
        userServices.login(loginRequest);
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("new note");
        postRequest.setContent("new content");
        postRequest.setAuthor("username4");
        var postResponse = userServices.addPost(postRequest);
        EditPostRequest editRequest = new EditPostRequest();
        editRequest.setId(postResponse.getId());
        editRequest.setNewTitle("updated title");
        editRequest.setNewContent("updated content");
        editRequest.setAuthor("username4");
        userServices.editPost(editRequest);
        assertEquals(1, posts.count());
    }

    @Test
    public void userLoginTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("08148624687");
        var user = userServices.register(registerRequest);
        assertNotNull(user.getId());
        assertEquals(1, users.count());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        userServices.login(loginRequest);
        assertTrue(users.findByUsername("username").isLoggedIn());
    }
    @Test
    public void loginWithWrongUsernameTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("08148624687");
        var user = userServices.register(registerRequest);
        assertNotNull(user.getId());
        assertEquals(1, users.count());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("wrong username");
        loginRequest.setPassword("password");
        try {
            userServices.login(loginRequest);
        }
        catch (MaverickBlogException e){
            assertEquals(e.getMessage(), loginRequest.getUsername()+ " not found");
        }
        assertFalse(users.findByUsername("username").isLoggedIn());
    }

    @Test
    public void loginWithWrongPassword_throwsExceptionTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("08148624687");
        var user = userServices.register(registerRequest);
        assertNotNull(user.getId());
        assertEquals(1, users.count());
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("wrong password");
        try {
            userServices.login(loginRequest);
        }
        catch (MaverickBlogException e){
            assertEquals(e.getMessage(), "wrong password");
        }
        assertFalse(users.findByUsername("username").isLoggedIn());
    }

}