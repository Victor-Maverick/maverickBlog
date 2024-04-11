package africa.semicolon.maverickblog.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeleteCommentRequest {
    private String postId;
    private String commentId;
    private String author;
}
