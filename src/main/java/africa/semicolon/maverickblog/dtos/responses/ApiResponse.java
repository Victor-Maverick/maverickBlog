package africa.semicolon.maverickblog.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ApiResponse {
    private boolean isSuccessful;
    private Object data;
}
