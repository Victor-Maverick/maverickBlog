package africa.semicolon.maverickblog.controllers;

import africa.semicolon.maverickblog.data.repository.Users;
import africa.semicolon.maverickblog.dtos.requests.DeleteUserRequest;
import africa.semicolon.maverickblog.dtos.requests.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserControllerTest {
    @Autowired
    UserController userController;
    @Autowired
    Users users;
    @Test
    public void registerUserTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username4");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("08148624687");
        userController.register(registerRequest);
        assertEquals(1, users.count());
    }

    @Test
    public void deleteUserTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username4");
        registerRequest.setPassword("password");
        registerRequest.setEmail("vic@gmail.com");
        registerRequest.setPhoneNumber("08148624687");
        userController.register(registerRequest);
        assertEquals(1, users.count());
        DeleteUserRequest deleteUserRequest = new DeleteUserRequest();
        deleteUserRequest.setUsername("username4");
        deleteUserRequest.setPassword("password");
        userController.deleteUser(deleteUserRequest);
        assertEquals(1, users.count());
    }
}