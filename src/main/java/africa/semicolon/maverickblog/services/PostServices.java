package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Post;
import africa.semicolon.maverickblog.dtos.requests.CreatePostRequest;
import org.springframework.stereotype.Service;

@Service
public interface PostServices {

    Post addPost(CreatePostRequest postRequest);
}
