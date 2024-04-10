package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Comment;
import africa.semicolon.maverickblog.data.repository.Comments;
import africa.semicolon.maverickblog.dtos.requests.CommentRequest;
import africa.semicolon.maverickblog.dtos.responses.CommentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static africa.semicolon.maverickblog.utils.Mapper.map;

@Service
public interface CommentServices {
    CommentResponse addComment(CommentRequest commentRequest);
}
