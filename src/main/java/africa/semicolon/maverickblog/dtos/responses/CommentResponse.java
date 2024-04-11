package africa.semicolon.maverickblog.dtos.responses;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CommentResponse {
    private Integer id;
    private String comment;
    private String commenter;
    private LocalDateTime timeCommented;
}
