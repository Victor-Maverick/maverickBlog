package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Comment;
import africa.semicolon.maverickblog.data.model.Post;
import africa.semicolon.maverickblog.data.model.View;
import africa.semicolon.maverickblog.data.repository.Posts;
import africa.semicolon.maverickblog.dtos.requests.*;
import africa.semicolon.maverickblog.dtos.responses.AddPostResponse;
import africa.semicolon.maverickblog.dtos.responses.CommentResponse;
import africa.semicolon.maverickblog.dtos.responses.EditPostResponse;
import africa.semicolon.maverickblog.dtos.responses.ViewResponse;
import africa.semicolon.maverickblog.exceptions.PostNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static africa.semicolon.maverickblog.utils.Mapper.map;
import static africa.semicolon.maverickblog.utils.Mapper.mapAdd;

@Service
@AllArgsConstructor
public class PostServicesImpl implements PostServices{
    private final Posts posts;
    private final ViewServices viewServices;
    private final CommentServices commentServices;
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
    public Post findById(String id) {
        return posts.findPostById(id);
    }

    @Override
    public List<Post> findByAuthor(String username) {
        List<Post> userPosts = new ArrayList<>();
        posts.findAll().forEach(post -> {if (post.getAuthor().equalsIgnoreCase(username))userPosts.add(post);});
        return userPosts;
    }

    @Override
    public void viewPost(AddViewRequest viewRequest) {
        Post post = findById(viewRequest.getPostId());
        ViewResponse response = viewServices.addView(viewRequest);
        View view = viewServices.findBy(response.getId());
        if(post==null)throw new PostNotFoundException("post not found");
        List<View> views = post.getViews();
        views.add(view);
        post.setViews(views);
        posts.save(post);
    }

    @Override
    public CommentResponse addComment(CommentRequest commentRequest) {
        Post post = findById(commentRequest.getPostId());
        CommentResponse response = commentServices.addComment(commentRequest);
        Comment comment = commentServices.findById(response.getId());
        if(post == null)throw new PostNotFoundException("post not found");
        List<Comment>comments = post.getComments();
        comments.add(comment);
        post.setComments(comments);
        posts.save(post);
        return response;
    }

    @Override
    public String deleteComment(DeleteCommentRequest deleteRequest) {
        Post post = findById(deleteRequest.getPostId());
        if(post==null)throw new PostNotFoundException("post not found");
        List<Comment>comments = post.getComments();
        comments.removeIf(comment -> comment.getId() == deleteRequest.getCommentId());
        post.setComments(comments);
        commentServices.deleteComment(deleteRequest);
        posts.save(post);
        return "delete success";
    }


}
