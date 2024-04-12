package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Post;
import africa.semicolon.maverickblog.dtos.requests.*;
import africa.semicolon.maverickblog.dtos.responses.AddPostResponse;
import africa.semicolon.maverickblog.dtos.responses.CommentResponse;
import africa.semicolon.maverickblog.dtos.responses.EditPostResponse;
import africa.semicolon.maverickblog.dtos.responses.RegisterResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServices {

    RegisterResponse register(RegisterRequest registerRequest);

    AddPostResponse addPost(CreatePostRequest postRequest);

    List<Post> findPostFor(String username);

    void viewPost(AddViewRequest viewRequest);

    CommentResponse addComment(CommentRequest commentRequest);

    String deleteComment(DeleteCommentRequest deleteRequest);

    EditPostResponse editPost(EditPostRequest editRequest);
}
