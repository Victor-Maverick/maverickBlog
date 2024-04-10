package africa.semicolon.maverickblog.data.repository;

import africa.semicolon.maverickblog.data.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Comments extends JpaRepository<Comment, Integer> {
}
