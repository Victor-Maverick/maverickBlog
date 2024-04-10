package africa.semicolon.maverickblog.data.repository;

import africa.semicolon.maverickblog.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Users extends JpaRepository<User, Integer> {

}