package africa.semicolon.maverickblog.exceptions;

public class NonExistingCommentException extends MaverickBlogException{
    public NonExistingCommentException(String message) {
        super(message);
    }
}
