package br.com.erikdev.workshopmongodb.repository;

import br.com.erikdev.workshopmongodb.domain.PostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<PostEntity, String> {
}
