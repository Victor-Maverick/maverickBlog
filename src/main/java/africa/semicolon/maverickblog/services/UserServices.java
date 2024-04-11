package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Post;
import africa.semicolon.maverickblog.dtos.requests.CreatePostRequest;
import africa.semicolon.maverickblog.dtos.requests.RegisterRequest;
import africa.semicolon.maverickblog.dtos.responses.AddPostResponse;
import africa.semicolon.maverickblog.dtos.responses.RegisterResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServices {

    RegisterResponse register(RegisterRequest registerRequest);

    AddPostResponse addPost(CreatePostRequest postRequest);

    List<Post> findPostFor(String username);
}
