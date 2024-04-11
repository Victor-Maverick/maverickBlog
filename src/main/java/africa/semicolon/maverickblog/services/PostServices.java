package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Post;
import africa.semicolon.maverickblog.dtos.requests.AddViewRequest;
import africa.semicolon.maverickblog.dtos.requests.CreatePostRequest;
import africa.semicolon.maverickblog.dtos.requests.DeletePostRequest;
import africa.semicolon.maverickblog.dtos.requests.EditPostRequest;
import africa.semicolon.maverickblog.dtos.responses.AddPostResponse;
import africa.semicolon.maverickblog.dtos.responses.EditPostResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostServices {

    AddPostResponse addPost(CreatePostRequest postRequest);

    EditPostResponse editPost(EditPostRequest editRequest);

    String deletePost(DeletePostRequest deleteRequest);

    Optional<Post> findById(Integer id);

    List<Post> findByAuthor(String username);
    void viewPost(AddViewRequest viewRequest);
}
