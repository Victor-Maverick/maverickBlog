package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Post;
import africa.semicolon.maverickblog.data.repository.Posts;
import africa.semicolon.maverickblog.dtos.requests.CreatePostRequest;
import africa.semicolon.maverickblog.dtos.requests.EditPostRequest;
import africa.semicolon.maverickblog.dtos.responses.EditPostResponse;
import africa.semicolon.maverickblog.exceptions.PostNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostServicesImpl implements PostServices{
    private final Posts posts;
    @Override
    public Post addPost(CreatePostRequest postRequest) {
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setContent(post.getContent());
        post.setDateCreated(LocalDateTime.now());
        posts.save(post);
        return post;
    }

    @Override
    public EditPostResponse editPost(EditPostRequest editRequest) {
        Optional<Post> post = posts.findById(editRequest.getId());
        if(post.isEmpty())throw new PostNotFoundException("post not found");
        post.get().setTitle(editRequest.getNewTitle());
        post.get().setContent(editRequest.getNewContent());
        post.get().setDateUpdated(LocalDateTime.now());
        return null;
    }
}
