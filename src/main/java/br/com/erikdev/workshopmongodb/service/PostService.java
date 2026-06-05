package br.com.erikdev.workshopmongodb.service;

import br.com.erikdev.workshopmongodb.domain.PostEntity;
import br.com.erikdev.workshopmongodb.domain.UsuarioEntity;
import br.com.erikdev.workshopmongodb.dto.AutorDto;
import br.com.erikdev.workshopmongodb.dto.ComentarioCreateDto;
import br.com.erikdev.workshopmongodb.dto.ComentarioDto;
import br.com.erikdev.workshopmongodb.dto.PostCreateDto;
import br.com.erikdev.workshopmongodb.dto.PostUpdateDto;
import br.com.erikdev.workshopmongodb.exception.ObjectNotFoundException;
import br.com.erikdev.workshopmongodb.repository.PostRepository;
import br.com.erikdev.workshopmongodb.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UsuarioRepository usuarioRepository;

    public List<PostEntity> getFindAll() {
        return postRepository.findAll();
    }

    public PostEntity getById(String id) throws ObjectNotFoundException {
        return postRepository.findById(id)
                .orElseThrow(() -> new  ObjectNotFoundException("post não encontrado"));
    }

    public PostEntity create(PostCreateDto dto) {
        UsuarioEntity user = getUsuarioById(dto.getAutorId());

        PostEntity post = PostEntity.builder()
                .data(new Date())
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .autor(buildAutor(user))
                .build();

        PostEntity saved = postRepository.save(post);
        if (user.getPosts() == null) {
            user.setPosts(new ArrayList<>());
        }
        user.getPosts().add(saved);
        usuarioRepository.save(user);
        return saved;
    }

    public PostEntity update(String id, PostUpdateDto dto) {
        PostEntity post = getById(id);

        if (dto.getTitulo() != null) {
            post.setTitulo(dto.getTitulo());
        }
        if (dto.getDescricao() != null) {
            post.setDescricao(dto.getDescricao());
        }
        return postRepository.save(post);
    }

    public void delete(String id) {
        PostEntity post = getById(id);
        postRepository.deleteById(id);

        if (post.getAutor() != null && post.getAutor().getId() != null) {
            usuarioRepository.findById(post.getAutor().getId())
                    .ifPresent(user -> {
                        if (user.getPosts() != null) {
                            user.getPosts().removeIf(item -> item != null && id.equals(item.getId()));
                        }
                        usuarioRepository.save(user);
                    });
        }
    }

    public PostEntity addComentario(String postId, ComentarioCreateDto dto) {
        PostEntity post = getById(postId);
        UsuarioEntity user = getUsuarioById(dto.getAutorId());

        ComentarioDto comentario = ComentarioDto.builder()
                .texto(dto.getTexto())
                .data(new Date())
                .autor(new AutorDto(user))
                .build();

        if (post.getComentarios() == null) {
            post.setComentarios(new ArrayList<>());
        }
        post.getComentarios().add(comentario);
        return postRepository.save(post);
    }

    private UsuarioEntity getUsuarioById(String id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
    }

    private UsuarioEntity buildAutor(UsuarioEntity user) {
        return UsuarioEntity.builder()
                .id(user.getId())
                .nome(user.getNome())
                .email(user.getEmail())
                .build();
    }

}
