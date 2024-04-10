package africa.semicolon.maverickblog.data.repository;

import africa.semicolon.maverickblog.data.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PostsTest {
    @Autowired
    Posts posts;

    @Test
    public void savePostTest(){
        Post post = new Post();
        posts.save(post);
        assertEquals(1, posts.count());
    }
    @Test
    public void deletePostTest(){
        Post post = new Post();
        posts.save(post);
        assertEquals(1, posts.count());
        posts.delete(post);
        assertEquals(0, posts.count());
    }
}