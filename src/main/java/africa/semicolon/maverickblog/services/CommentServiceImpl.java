package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Comment;
import africa.semicolon.maverickblog.data.repository.Comments;
import africa.semicolon.maverickblog.dtos.requests.CommentRequest;
import africa.semicolon.maverickblog.dtos.requests.DeleteCommentRequest;
import africa.semicolon.maverickblog.dtos.responses.CommentResponse;
import africa.semicolon.maverickblog.exceptions.NonExistingCommentException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static africa.semicolon.maverickblog.utils.Mapper.map;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentServices{
    private final Comments comments;
    public CommentResponse addComment(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setComment(commentRequest.getComment());
        comment.setCommenter(commentRequest.getCommenterName());
        comments.save(comment);
        return map(comment, commentRequest);
    }

    @Override
    public String deleteComment(DeleteCommentRequest deleteRequest) {
        Comment comment = findById(deleteRequest.getCommentId());
        if (comment == null)throw new NonExistingCommentException("no such comment");
        comments.delete(comment);
        return "delete successful";
    }

    @Override
    public Comment findById(String id) {
        return comments.findCommentById(id);
    }
}
