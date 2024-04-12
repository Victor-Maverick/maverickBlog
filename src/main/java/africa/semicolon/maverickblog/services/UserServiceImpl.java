package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Comment;
import africa.semicolon.maverickblog.data.model.Post;
import africa.semicolon.maverickblog.data.model.User;
import africa.semicolon.maverickblog.data.repository.Users;
import africa.semicolon.maverickblog.dtos.requests.*;
import africa.semicolon.maverickblog.dtos.responses.AddPostResponse;
import africa.semicolon.maverickblog.dtos.responses.CommentResponse;
import africa.semicolon.maverickblog.dtos.responses.EditPostResponse;
import africa.semicolon.maverickblog.dtos.responses.RegisterResponse;
import africa.semicolon.maverickblog.exceptions.PostNotFoundException;
import africa.semicolon.maverickblog.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static africa.semicolon.maverickblog.utils.Mapper.map;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServices{
    private Users users;
    private PostServices postServices;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        User user = new User();
        map(user, registerRequest);
        users.save(user);
        return map(user);
    }

    @Override
    public AddPostResponse addPost(CreatePostRequest postRequest) {
        AddPostResponse response = postServices.addPost(postRequest);
        User user = users.findByUsername(postRequest.getAuthor());
        if(user == null)throw new UserNotFoundException("user not found");
        List<Post> userPosts = user.getPosts();
        Post post = postServices.findById(response.getId());
        userPosts.add(post);
        user.setPosts(userPosts);
        users.save(user);
       return response;
    }

    @Override
    public List<Post> findPostFor(String username) {
        return postServices.findByAuthor(username);
    }

    @Override
    public void viewPost(AddViewRequest viewRequest) {
        User user = users.findByUsername(viewRequest.getViewerName());
        if (user == null)throw new UserNotFoundException(viewRequest.getViewerName()+" not found");
        postServices.viewPost(viewRequest);
    }

    @Override
    public CommentResponse addComment(CommentRequest commentRequest) {
        User user = users.findByUsername(commentRequest.getCommenterName());
        if (user == null)throw new UserNotFoundException(commentRequest.getCommenterName()+" not found");

        return postServices.addComment(commentRequest);
    }

    @Override
    public String deleteComment(DeleteCommentRequest deleteRequest) {
        User user = users.findByUsername(deleteRequest.getAuthor());
        if (user == null)throw new UserNotFoundException(deleteRequest.getAuthor()+" not found");
        return postServices.deleteComment(deleteRequest);
    }

    @Override
    public EditPostResponse editPost(EditPostRequest editRequest) {
        User user = users.findByUsername(editRequest.getAuthor());
        if (user == null)throw new UserNotFoundException(editRequest.getAuthor()+" not found");
        return postServices.editPost(editRequest);
    }


}
