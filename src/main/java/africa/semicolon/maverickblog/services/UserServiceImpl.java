package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.Post;
import africa.semicolon.maverickblog.data.model.User;
import africa.semicolon.maverickblog.data.repository.Users;
import africa.semicolon.maverickblog.dtos.requests.*;
import africa.semicolon.maverickblog.dtos.responses.*;
import africa.semicolon.maverickblog.exceptions.IncorrectPasswordException;
import africa.semicolon.maverickblog.exceptions.LoginException;
import africa.semicolon.maverickblog.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static africa.semicolon.maverickblog.utils.Mapper.map;
import static africa.semicolon.maverickblog.utils.Mapper.mapLogin;

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
        validateUserLogin(user);
        List<Post> userPosts = user.getPosts();
        Post post = postServices.findById(response.getId());
        userPosts.add(post);
        user.setPosts(userPosts);
        users.save(user);
       return response;
    }

    private static void validateUserLogin(User user) {
        if (!user.isLoggedIn())throw new LoginException("log in first");
    }

    @Override
    public List<Post> findPostFor(String username) {
        return postServices.findByAuthor(username);
    }

    @Override
    public ViewPostResponse viewPost(AddViewRequest viewRequest) {
        User user = users.findByUsername(viewRequest.getViewerName());
        if (user == null)throw new UserNotFoundException(viewRequest.getViewerName()+" not found");
        validateUserLogin(user);
        return postServices.viewPost(viewRequest);
    }

    @Override
    public CommentResponse addComment(CommentRequest commentRequest) {
        User user = users.findByUsername(commentRequest.getCommenterName());
        if (user == null)throw new UserNotFoundException(commentRequest.getCommenterName()+" not found");
        validateUserLogin(user);
        return postServices.addComment(commentRequest);
    }

    @Override
    public String deleteComment(DeleteCommentRequest deleteRequest) {
        User user = users.findByUsername(deleteRequest.getAuthor());
        if (user == null)throw new UserNotFoundException(deleteRequest.getAuthor()+" not found");
        validateUserLogin(user);
        return postServices.deleteComment(deleteRequest);
    }

    @Override
    public EditPostResponse editPost(EditPostRequest editRequest) {
        User user = users.findByUsername(editRequest.getAuthor());
        if (user == null)throw new UserNotFoundException(editRequest.getAuthor()+" not found");
        validateUserLogin(user);
        return postServices.editPost(editRequest);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = users.findByUsername(loginRequest.getUsername());
        if (user == null)throw new UserNotFoundException(loginRequest.getUsername()+" not found");
        if (!user.getPassword().equals(loginRequest.getPassword()))throw new IncorrectPasswordException("wrong password");
        user.setLoggedIn(true);
        users.save(user);
        return mapLogin(user);
    }


}
