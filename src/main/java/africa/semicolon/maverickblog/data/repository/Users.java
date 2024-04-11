package africa.semicolon.maverickblog.data.repository;

import africa.semicolon.maverickblog.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Users extends MongoRepository<User, String> {

    User findByUsername(String author);
}
