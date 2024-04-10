package africa.semicolon.maverickblog.data.model;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String username;
    private String password;
    private String email;

}
