package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Post;
import africa.semicolon.maverickblog.data.repository.Posts;
import africa.semicolon.maverickblog.dtos.requests.CreatePostRequest;
import africa.semicolon.maverickblog.dtos.requests.DeletePostRequest;
import africa.semicolon.maverickblog.dtos.requests.EditPostRequest;
import africa.semicolon.maverickblog.dtos.responses.EditPostResponse;
import africa.semicolon.maverickblog.exceptions.PostNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static africa.semicolon.maverickblog.utils.Mapper.map;

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
        map(post.get(), editRequest);
        posts.save(post.get());
        return map(post.get());
    }

    @Override
    public String deletePost(DeletePostRequest deleteRequest) {
        Optional<Post> post = posts.findById(deleteRequest.getId());
        if(post.isEmpty())throw new PostNotFoundException("post not found");
        posts.delete(post.get());
        return "delete successful";
    }
}
