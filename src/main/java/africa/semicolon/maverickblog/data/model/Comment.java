package africa.semicolon.maverickblog.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document("comment")
public class Comment {
    private String id;
    private String commenter;
    private String comment;

}
