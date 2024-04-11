package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.repository.Users;
import africa.semicolon.maverickblog.dtos.requests.CreatePostRequest;
import africa.semicolon.maverickblog.dtos.requests.RegisterRequest;
import org.checkerframework.checker.units.qual.A;
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
    @BeforeEach
    public void setUp() {
        users.deleteAll();
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
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("new note");
        postRequest.setContent("new content");
        postRequest.setAuthor("username");
        userServices.addPost(postRequest);
        assertEquals(1, userServices.findPostFor("username").size());
    }

}