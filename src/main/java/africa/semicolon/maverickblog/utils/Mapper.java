package africa.semicolon.maverickblog.utils;

import africa.semicolon.maverickblog.data.model.Comment;
import africa.semicolon.maverickblog.data.model.Post;
import africa.semicolon.maverickblog.dtos.requests.CommentRequest;
import africa.semicolon.maverickblog.dtos.requests.EditPostRequest;
import africa.semicolon.maverickblog.dtos.responses.CommentResponse;
import africa.semicolon.maverickblog.dtos.responses.EditPostResponse;
import africa.semicolon.maverickblog.exceptions.PostNotFoundException;

import java.time.LocalDateTime;

public class Mapper {
    public static CommentResponse map(Comment comment, CommentRequest commentRequest){
        CommentResponse response = new CommentResponse();
        response.setCommenter(commentRequest.getCommenterName());
        response.setComment(comment.getComment());
        return response;
    }
    public static void map(Post post, EditPostRequest editRequest){
        post.setTitle(editRequest.getNewTitle());
        post.setContent(editRequest.getNewContent());
        post.setDateUpdated(LocalDateTime.now());
    }
    public static EditPostResponse map(Post post){
        EditPostResponse editResponse = new EditPostResponse();
        editResponse.setId(post.getId());
        editResponse.setNewTitle(post.getTitle());
        editResponse.setNewContent(post.getContent());
        editResponse.setDateUpdated(post.getDateUpdated());
        return editResponse;
    }
}
