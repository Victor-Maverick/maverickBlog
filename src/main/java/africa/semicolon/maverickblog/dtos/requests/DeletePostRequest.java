package africa.semicolon.maverickblog.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeletePostRequest {
    private String id;
    private String author;
}
