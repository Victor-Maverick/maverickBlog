package africa.semicolon.maverickblog.data.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="view_table")
public class View {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private User viewer;
    private LocalDateTime dateViewed;
}
