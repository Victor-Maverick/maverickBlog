package africa.semicolon.maverickblog.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EditPostRequest {
    private Integer id;
    private String newTitle;
    private String newContent;
}
