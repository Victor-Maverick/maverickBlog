package africa.semicolon.maverickblog.data.repository;

import africa.semicolon.maverickblog.data.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Posts extends MongoRepository<Post, String> {

    List<Post> findByAuthor(String username);

    Post findPostById(String id);
}
