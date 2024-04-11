package africa.semicolon.maverickblog.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String title;
    private String content;
    @ManyToOne
    private User Author;
    @ManyToMany
    private List<View> views = new ArrayList<>();
    @ManyToMany
    private List<Comment> comments = new ArrayList<>();
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
}
