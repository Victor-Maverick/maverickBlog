package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Comment;
import africa.semicolon.maverickblog.dtos.requests.CommentRequest;
import africa.semicolon.maverickblog.dtos.requests.DeleteCommentRequest;
import org.springframework.stereotype.Service;

@Service
public interface CommentServices {
    Comment addComment(CommentRequest commentRequest);

    String deleteComment(DeleteCommentRequest deleteRequest);
}
