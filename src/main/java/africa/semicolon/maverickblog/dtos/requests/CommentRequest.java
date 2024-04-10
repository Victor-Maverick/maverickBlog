package africa.semicolon.maverickblog.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentRequest {
    private String commenterName;
    private String comment;
}
