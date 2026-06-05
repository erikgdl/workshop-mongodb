package br.com.erikdev.workshopmongodb.controller;


import br.com.erikdev.workshopmongodb.domain.PostEntity;
import br.com.erikdev.workshopmongodb.dto.ComentarioCreateDto;
import br.com.erikdev.workshopmongodb.dto.PostCreateDto;
import br.com.erikdev.workshopmongodb.dto.PostUpdateDto;
import br.com.erikdev.workshopmongodb.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/post")
@RequiredArgsConstructor
@Validated
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostEntity>> findAll() {
        List<PostEntity> posts = postService.getFindAll();
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostEntity> findById(@PathVariable String id) {
        PostEntity post = postService.getById(id);
        return ResponseEntity.ok().body(post);
    }

    @PostMapping
    public ResponseEntity<PostEntity> create(@RequestBody @Valid PostCreateDto dto) {
        PostEntity post = postService.create(dto);
        return ResponseEntity.ok().body(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostEntity> update(@PathVariable String id, @RequestBody @Valid PostUpdateDto dto) {
        PostEntity post = postService.update(id, dto);
        return ResponseEntity.ok().body(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/comentarios")
    public ResponseEntity<PostEntity> addComentario(@PathVariable String id, @RequestBody @Valid ComentarioCreateDto dto) {
        PostEntity post = postService.addComentario(id, dto);
        return ResponseEntity.ok().body(post);
    }

}
