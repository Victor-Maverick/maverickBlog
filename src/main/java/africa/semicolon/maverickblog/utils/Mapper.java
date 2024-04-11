package africa.semicolon.maverickblog.utils;

import africa.semicolon.maverickblog.data.model.Comment;
import africa.semicolon.maverickblog.data.model.Post;
import africa.semicolon.maverickblog.data.model.User;
import africa.semicolon.maverickblog.dtos.requests.CommentRequest;
import africa.semicolon.maverickblog.dtos.requests.CreatePostRequest;
import africa.semicolon.maverickblog.dtos.requests.EditPostRequest;
import africa.semicolon.maverickblog.dtos.requests.RegisterRequest;
import africa.semicolon.maverickblog.dtos.responses.AddPostResponse;
import africa.semicolon.maverickblog.dtos.responses.CommentResponse;
import africa.semicolon.maverickblog.dtos.responses.EditPostResponse;
import africa.semicolon.maverickblog.dtos.responses.RegisterResponse;
import africa.semicolon.maverickblog.exceptions.PostNotFoundException;

import java.time.LocalDateTime;

public class Mapper {
    public static CommentResponse map(Comment comment, CommentRequest commentRequest){
        CommentResponse response = new CommentResponse();
        response.setId(comment.getId());
        response.setCommenter(commentRequest.getCommenterName());
        response.setComment(comment.getComment());
        return response;
    }
    public static void map(Post post, EditPostRequest editRequest){
        post.setTitle(editRequest.getNewTitle());
        post.setContent(editRequest.getNewContent());
        post.setDateUpdated(LocalDateTime.now());
    }
    public static AddPostResponse mapAdd(Post post, CreatePostRequest postRequest){
        AddPostResponse response = new AddPostResponse();
        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setDateCreated(post.getDateCreated());
        response.setAuthor(postRequest.getAuthor());
        return response;
    }
    public static EditPostResponse map(Post post){
        EditPostResponse editResponse = new EditPostResponse();
        editResponse.setId(post.getId());
        editResponse.setNewTitle(post.getTitle());
        editResponse.setNewContent(post.getContent());
        editResponse.setDateUpdated(post.getDateUpdated());
        return editResponse;
    }
    public static void map(User user, RegisterRequest registerRequest){
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setPhoneNumber(registerRequest.getPhoneNumber());
    }
    public static RegisterResponse map(User user){
        RegisterResponse response = new RegisterResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setDateCreated(user.getDateCreated());
        response.setPhoneNumber(user.getPhoneNumber());
        return response;
    }
}
