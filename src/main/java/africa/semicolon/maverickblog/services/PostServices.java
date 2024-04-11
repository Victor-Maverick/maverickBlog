package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.dtos.requests.CreatePostRequest;
import africa.semicolon.maverickblog.dtos.requests.DeletePostRequest;
import africa.semicolon.maverickblog.dtos.requests.EditPostRequest;
import africa.semicolon.maverickblog.dtos.responses.AddPostResponse;
import africa.semicolon.maverickblog.dtos.responses.EditPostResponse;
import org.springframework.stereotype.Service;

@Service
public interface PostServices {

    AddPostResponse addPost(CreatePostRequest postRequest);

    EditPostResponse editPost(EditPostRequest editRequest);

    String deletePost(DeletePostRequest deleteRequest);
}
