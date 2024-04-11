package africa.semicolon.maverickblog.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EditPostResponse {
    private String id;
    private String newTitle;
    private String newContent;
    private LocalDateTime dateUpdated;
}
