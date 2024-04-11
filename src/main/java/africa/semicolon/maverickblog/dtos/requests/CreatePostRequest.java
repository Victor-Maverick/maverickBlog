package africa.semicolon.maverickblog.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePostRequest {
    private String title;
    private String content;
    private String author;
}
