package africa.semicolon.maverickblog.utils;

import africa.semicolon.maverickblog.data.model.Comment;
import africa.semicolon.maverickblog.dtos.responses.CommentResponse;

public class Mapper {
    public static CommentResponse map(Comment comment){
        CommentResponse response = new CommentResponse();
        response.setComment();
    }
}
