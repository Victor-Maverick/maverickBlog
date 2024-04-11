package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Post;
import africa.semicolon.maverickblog.data.repository.Posts;
import africa.semicolon.maverickblog.dtos.requests.CreatePostRequest;
import africa.semicolon.maverickblog.dtos.requests.DeletePostRequest;
import africa.semicolon.maverickblog.dtos.requests.EditPostRequest;
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
        posts.deleteAll();
    }

    @Test
    public void addPost_postsSizeIncreasesTest(){
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("new post");
        postRequest.setContent("content for new post");
        postRequest.setAuthor("author");
        Post post = postServices.addPost(postRequest);
        assertNotNull(post.getId());
        assertEquals(1, posts.count());
    }

    @Test
    public void editPost_postsSizeIsSameTest(){
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("new post");
        postRequest.setContent("content for new post");
        postRequest.setAuthor("author");
        Post post = postServices.addPost(postRequest);
        assertEquals(1, posts.count());
        EditPostRequest editRequest = new EditPostRequest();
        editRequest.setId(post.getId());
        editRequest.setNewTitle("updated title");
        editRequest.setNewContent("updated content");
        postServices.editPost(editRequest);
        assertEquals(1, posts.count());
    }

    @Test
    public void deletePostTest(){
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("new post");
        postRequest.setContent("content for new post");
        postRequest.setAuthor("author");
        Post post = postServices.addPost(postRequest);
        assertEquals(1, posts.count());
        DeletePostRequest deleteRequest = new DeletePostRequest();
        deleteRequest.setId(post.getId());
        postServices.deletePost(deleteRequest);
        assertEquals(0, posts.count());
    }

}