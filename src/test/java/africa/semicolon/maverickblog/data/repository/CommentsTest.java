package africa.semicolon.maverickblog.data.repository;

import africa.semicolon.maverickblog.data.model.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class CommentsTest {
    @Autowired
    Comments comments;

    @Test
    public void saveCommentTest(){
        Comment comment = new Comment();
        comments.save(comment);
        assertEquals(1, comments.count());
    }

    @Test
    public void deleteCommentTest(){
        Comment comment = new Comment();
        comments.save(comment);
        assertEquals(1, comments.count());
        comments.delete(comment);
        assertEquals(0, comments.count());
    }

}