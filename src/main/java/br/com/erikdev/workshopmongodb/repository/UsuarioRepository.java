package br.com.erikdev.workshopmongodb.repository;

import br.com.erikdev.workshopmongodb.domain.UsuarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {
}
