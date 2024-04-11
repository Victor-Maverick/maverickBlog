package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Post;
import africa.semicolon.maverickblog.data.repository.Posts;
import africa.semicolon.maverickblog.dtos.requests.CreatePostRequest;
import africa.semicolon.maverickblog.dtos.requests.DeletePostRequest;
import africa.semicolon.maverickblog.dtos.requests.EditPostRequest;
import africa.semicolon.maverickblog.dtos.responses.AddPostResponse;
import africa.semicolon.maverickblog.dtos.responses.EditPostResponse;
import africa.semicolon.maverickblog.exceptions.PostNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static africa.semicolon.maverickblog.utils.Mapper.map;
import static africa.semicolon.maverickblog.utils.Mapper.mapAdd;

@Service
@AllArgsConstructor
public class PostServicesImpl implements PostServices{
    private final Posts posts;
    @Override
    public AddPostResponse addPost(CreatePostRequest postRequest) {
        Post post = new Post();
        map(post, postRequest);
        posts.save(post);
        return mapAdd(post);
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

    @Override
    public Optional<Post> findById(Integer id) {
        return posts.findById(id);
    }

    @Override
    public List<Post> findByAuthor(String username) {
        return posts.findByAuthor(username);
    }
}
