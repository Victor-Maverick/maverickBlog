package africa.semicolon.maverickblog.dtos.responses;

import lombok.Data;

@Data
public class LoginResponse {
    private String id;
    private String username;
    private String email;
    private String phoneNumber;
    private boolean isLoggedIn;
}
