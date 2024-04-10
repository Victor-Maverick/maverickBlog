package africa.semicolon.maverickblog.data.repository;

import africa.semicolon.maverickblog.data.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UsersTest {
    @Autowired
    Users users;

    @BeforeEach
    public void collapse(){
        users.deleteAll();
    }
    @Test
    public void saveUserTest(){
        User user = new User();
        users.save(user);
        assertEquals(1, users.count());
    }
    @Test
    public void deleteTest(){
        User user = new User();
        users.save(user);
        assertEquals(1, users.count());
        users.delete(user);
        assertEquals(0, users.count());
    }

}