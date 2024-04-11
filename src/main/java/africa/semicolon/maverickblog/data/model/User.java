package africa.semicolon.maverickblog.data.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Data
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Post> posts = new ArrayList<>();
    private LocalDateTime dateCreated = LocalDateTime.now();

}
