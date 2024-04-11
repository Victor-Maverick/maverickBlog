package africa.semicolon.maverickblog.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@Document("view")
public class View {
    private String id;
    private String viewer;
    private LocalDateTime dateViewed = LocalDateTime.now();
}
