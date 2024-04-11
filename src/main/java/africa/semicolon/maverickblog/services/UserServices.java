package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.dtos.requests.CreatePostRequest;
import africa.semicolon.maverickblog.dtos.requests.RegisterRequest;
import africa.semicolon.maverickblog.dtos.responses.AddPostResponse;
import africa.semicolon.maverickblog.dtos.responses.RegisterResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {

    RegisterResponse register(RegisterRequest registerRequest);

    AddPostResponse addPost(CreatePostRequest postRequest);
}
