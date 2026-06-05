package br.com.erikdev.workshopmongodb.controller;


import br.com.erikdev.workshopmongodb.domain.UsuarioEntity;
import br.com.erikdev.workshopmongodb.dto.UsuarioDto;
import br.com.erikdev.workshopmongodb.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/usuario")
@RequiredArgsConstructor
@Validated
public class UsuarioController {

    private final UsuarioService usuarioService;


    @GetMapping
    public ResponseEntity<List<UsuarioDto>> findAll() {
        List<UsuarioDto> user = usuarioService.getFindAll();
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> findById(@PathVariable String id) {
        UsuarioEntity user = usuarioService.getById(id);
        return ResponseEntity.ok().body(new UsuarioDto(user));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid UsuarioDto usuarioDto) {
        UsuarioEntity usuarioEntity = usuarioService.create(usuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



}
