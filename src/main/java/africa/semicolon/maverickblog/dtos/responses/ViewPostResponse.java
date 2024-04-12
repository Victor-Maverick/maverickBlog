package africa.semicolon.maverickblog.dtos.responses;

import africa.semicolon.maverickblog.data.model.Comment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ViewPostResponse {
    private String postId;
    private String postTitle;
    private String content;
    private List<Comment>comments;
}
