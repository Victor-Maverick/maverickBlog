package africa.semicolon.maverickblog.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class RegisterResponse {
    private String id;
    private String username;
    private String email;
    private String phoneNumber;
    private LocalDateTime dateCreated;
}
