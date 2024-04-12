package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Post;
import africa.semicolon.maverickblog.dtos.requests.*;
import africa.semicolon.maverickblog.dtos.responses.AddPostResponse;
import africa.semicolon.maverickblog.dtos.responses.CommentResponse;
import africa.semicolon.maverickblog.dtos.responses.EditPostResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostServices {

    AddPostResponse addPost(CreatePostRequest postRequest);

    EditPostResponse editPost(EditPostRequest editRequest);

    String deletePost(DeletePostRequest deleteRequest);

    Post findById(String id);

    List<Post> findByAuthor(String username);
    void viewPost(AddViewRequest viewRequest);

    CommentResponse addComment(CommentRequest commentRequest);

    String deleteComment(DeleteCommentRequest deleteRequest);
}
