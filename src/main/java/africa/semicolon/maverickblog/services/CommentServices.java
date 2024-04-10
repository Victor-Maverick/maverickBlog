package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Comment;
import africa.semicolon.maverickblog.data.repository.Comments;
import africa.semicolon.maverickblog.dtos.requests.CommentRequest;
import africa.semicolon.maverickblog.dtos.responses.CommentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentServices {
    private final Comments comments;
    public CommentResponse addComment(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setComment(comment.getComment());
        comments.save(comment);
        return map(comment);
    }
}
