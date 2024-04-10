package africa.semicolon.maverickblog.data.repository;

import africa.semicolon.maverickblog.data.model.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Views extends JpaRepository<View, Integer> {

}
