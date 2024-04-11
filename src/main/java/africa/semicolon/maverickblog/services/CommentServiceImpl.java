package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Comment;
import africa.semicolon.maverickblog.data.repository.Comments;
import africa.semicolon.maverickblog.dtos.requests.CommentRequest;
import africa.semicolon.maverickblog.dtos.requests.DeleteCommentRequest;
import africa.semicolon.maverickblog.exceptions.NonExistingCommentException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentServices{
    private final Comments comments;
    public Comment addComment(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setComment(comment.getComment());
        comments.save(comment);
        return comment;
    }

    @Override
    public String deleteComment(DeleteCommentRequest deleteRequest) {
        Optional<Comment> comment = comments.findById(deleteRequest.getId());
        if (comment.isEmpty())throw new NonExistingCommentException("no such comment");
        comments.delete(comment.get());
        return "delete successful";
    }
}
