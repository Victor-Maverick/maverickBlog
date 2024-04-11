package africa.semicolon.maverickblog.dtos.requests;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddViewRequest {
    private Integer postId;
    private String viewerName;
}
