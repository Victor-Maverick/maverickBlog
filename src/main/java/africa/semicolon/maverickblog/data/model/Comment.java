package africa.semicolon.maverickblog.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@Document("comment")
public class Comment {
    private String id;
    private String commenter;
    private String comment;
    private LocalDateTime dateCommented = LocalDateTime.now();

}
