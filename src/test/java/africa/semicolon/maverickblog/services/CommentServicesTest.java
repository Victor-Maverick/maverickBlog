package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Comment;
import africa.semicolon.maverickblog.data.repository.Comments;
import africa.semicolon.maverickblog.dtos.requests.CommentRequest;
import africa.semicolon.maverickblog.dtos.requests.DeleteCommentRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CommentServicesTest {
    @Autowired
    CommentServices commentServices;
    @Autowired
    Comments comments;
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void createCommentTest(){
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setCommenterName("name");
        commentRequest.setComment("new comment");
        commentServices.addComment(commentRequest);
        assertEquals(1, comments.count());
    }

    @Test
    public void deleteCommentTest(){
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setCommenterName("name");
        commentRequest.setComment("new comment");
        var comment = commentServices.addComment(commentRequest);
        assertEquals(1, comments.count());
        DeleteCommentRequest deleteRequest = new DeleteCommentRequest();
        deleteRequest.setId(comment.getId());
        commentServices.deleteComment(deleteRequest);
        assertEquals(0, comments.count());
    }
}