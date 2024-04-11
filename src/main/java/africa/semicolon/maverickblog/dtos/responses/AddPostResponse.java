package africa.semicolon.maverickblog.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AddPostResponse {
    private Integer id;
    private String title;
    private String author;
    private LocalDateTime dateCreated;
}
