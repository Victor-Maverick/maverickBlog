package africa.semicolon.maverickblog.data.repository;

import africa.semicolon.maverickblog.data.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Comments extends MongoRepository<Comment, String> {

    Comment findCommentById(String id);
}
