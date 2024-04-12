package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Post;
import africa.semicolon.maverickblog.data.repository.Comments;
import africa.semicolon.maverickblog.data.repository.Posts;
import africa.semicolon.maverickblog.data.repository.Views;
import africa.semicolon.maverickblog.dtos.requests.*;
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
    @Autowired
    Views views;
    @Autowired
    Comments comments;

    @BeforeEach
    public void setUp() {
        comments.deleteAll();
        posts.deleteAll();
    }

    @Test
    public void addPost_postsSizeIncreasesTest(){
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("new post");
        postRequest.setContent("content for new post");
        postRequest.setAuthor("author");
        var response = postServices.addPost(postRequest);
        assertNotNull(response.getId());
        assertEquals(1, posts.count());
    }

    @Test
    public void editPost_postsSizeIsSameTest(){
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("new post");
        postRequest.setContent("content for new post");
        postRequest.setAuthor("author");
        var response = postServices.addPost(postRequest);
        assertEquals(1, posts.count());
        EditPostRequest editRequest = new EditPostRequest();
        editRequest.setId(response.getId());
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
        var response = postServices.addPost(postRequest);
        assertEquals(1, posts.count());
        DeletePostRequest deleteRequest = new DeletePostRequest();
        deleteRequest.setId(response.getId());
        postServices.deletePost(deleteRequest);
        assertEquals(0, posts.count());
    }
    @Test
    public void viewPostTest(){
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("new note");
        postRequest.setContent("new content");
        postRequest.setAuthor("username");
        var postResponse = postServices.addPost(postRequest);

        AddViewRequest viewRequest = new AddViewRequest();
        viewRequest.setViewerName("username2");
        viewRequest.setPostId(postResponse.getId());
        postServices.viewPost(viewRequest);
        assertEquals(1, views.count());
    }

    @Test
    public void addCommentTest(){
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("new note");
        postRequest.setContent("new content");
        postRequest.setAuthor("username");
        var postResponse = postServices.addPost(postRequest);

        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setPostId(postResponse.getId());
        commentRequest.setComment("new comment");
        commentRequest.setCommenterName("username");
        postServices.addComment(commentRequest);
        assertEquals(1, comments.count());;
    }

    @Test
    public void deleteCommentTest(){
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle("new note");
        postRequest.setContent("new content");
        postRequest.setAuthor("username");
        var postResponse = postServices.addPost(postRequest);

        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setPostId(postResponse.getId());
        commentRequest.setComment("new comment");
        commentRequest.setCommenterName("username");
        var commentResponse  = postServices.addComment(commentRequest);
        System.out.println(commentResponse);
        assertEquals(1, comments.count());
        DeleteCommentRequest deleteRequest = new DeleteCommentRequest();
        deleteRequest.setPostId(postResponse.getId());
        deleteRequest.setCommentId(commentResponse.getId());
        deleteRequest.setAuthor("username");
        postServices.deleteComment(deleteRequest);
        assertEquals(0, comments.count());
    }

}