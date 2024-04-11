package africa.semicolon.maverickblog.data.repository;

import africa.semicolon.maverickblog.data.model.View;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Views extends MongoRepository<View, String> {

    View findViewById(String id);
}
