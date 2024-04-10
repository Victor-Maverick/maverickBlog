package africa.semicolon.maverickblog.data.repository;

import africa.semicolon.maverickblog.data.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Posts extends JpaRepository<Post, Integer> {

}
