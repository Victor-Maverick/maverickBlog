package africa.semicolon.maverickblog.exceptions;

public class UserNotFoundException extends MaverickBlogException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
