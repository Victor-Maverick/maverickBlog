package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.repository.Posts;
import africa.semicolon.maverickblog.dtos.requests.CreatePostRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class PostServicesTest {
    @Autowired
    PostServices postServices;
    @Autowired
    Posts posts;
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void addPost_postsSizeIncreasesTest(){
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("new post");
        postRequest.setContent("content for new post");
        postRequest.setAuthor("author");
        postServices.addPost(postRequest);
        assertEquals(1, posts.count());
    }
}