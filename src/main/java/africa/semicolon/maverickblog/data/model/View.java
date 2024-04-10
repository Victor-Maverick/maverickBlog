package africa.semicolon.maverickblog.data.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="view_table")
public class View {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne
    private User viewer;
    private LocalDateTime dateViewed = LocalDateTime.now();
}
