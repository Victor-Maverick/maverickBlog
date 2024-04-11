package africa.semicolon.maverickblog.dtos.responses;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class CommentResponse {
    private String id;
    private String comment;
    private String commenter;
    private LocalDateTime timeCommented;
}
