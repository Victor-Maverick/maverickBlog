package africa.semicolon.maverickblog.services;

import africa.semicolon.maverickblog.data.model.User;
import africa.semicolon.maverickblog.data.repository.Users;
import africa.semicolon.maverickblog.dtos.requests.CreatePostRequest;
import africa.semicolon.maverickblog.dtos.requests.RegisterRequest;
import africa.semicolon.maverickblog.dtos.responses.AddPostResponse;
import africa.semicolon.maverickblog.dtos.responses.RegisterResponse;
import africa.semicolon.maverickblog.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
        Optional<User> user = users.findByUsername(response.getAuthor());
        if(user.isEmpty())throw new UserNotFoundException("user not found");
        return null;
    }


}
