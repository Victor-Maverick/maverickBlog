package africa.semicolon.maverickblog.utils;

import africa.semicolon.maverickblog.data.model.Comment;
import africa.semicolon.maverickblog.dtos.requests.CommentRequest;
import africa.semicolon.maverickblog.dtos.responses.CommentResponse;

public class Mapper {
    public static CommentResponse map(Comment comment, CommentRequest commentRequest){
        CommentResponse response = new CommentResponse();
        response.setCommenter(commentRequest.getCommenterName());
        response.setComment(comment.getComment());
        return response;
    }
}
