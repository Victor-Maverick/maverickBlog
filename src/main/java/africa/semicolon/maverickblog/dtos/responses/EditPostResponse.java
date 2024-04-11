package africa.semicolon.maverickblog.dtos.responses;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class EditPostResponse {
    private String id;
    private String newTitle;
    private String newContent;
    private LocalDateTime dateUpdated;
}
