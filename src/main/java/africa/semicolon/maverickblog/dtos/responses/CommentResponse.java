package africa.semicolon.maverickblog.dtos.responses;

import africa.semicolon.maverickblog.data.model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CommentResponse {
    private String comment;
    private User commenter;
    private LocalDateTime timeCommented;
}
