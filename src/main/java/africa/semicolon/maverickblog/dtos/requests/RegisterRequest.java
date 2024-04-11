package africa.semicolon.maverickblog.dtos.requests;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
}
