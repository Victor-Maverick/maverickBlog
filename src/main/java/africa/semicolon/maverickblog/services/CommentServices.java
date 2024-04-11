package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Comment;
import africa.semicolon.maverickblog.dtos.requests.CommentRequest;
import africa.semicolon.maverickblog.dtos.requests.DeleteCommentRequest;
import africa.semicolon.maverickblog.dtos.responses.CommentResponse;
import org.springframework.stereotype.Service;

@Service
public interface CommentServices {
    CommentResponse addComment(CommentRequest commentRequest);

    String deleteComment(DeleteCommentRequest deleteRequest);
}
