package br.com.erikdev.workshopmongodb.service;

import br.com.erikdev.workshopmongodb.domain.UsuarioEntity;
import br.com.erikdev.workshopmongodb.dto.UsuarioDto;
import br.com.erikdev.workshopmongodb.exception.ObjectNotFoundException;
import br.com.erikdev.workshopmongodb.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<UsuarioDto> getFindAll() {
        List<UsuarioEntity> usuarioEntities = usuarioRepository.findAll();
        return usuarioEntities.stream()
                .map(UsuarioDto::new)
                .toList();
    }

    public UsuarioEntity getById(String id) throws ObjectNotFoundException {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new  ObjectNotFoundException("Usuario não encontrado"));
    }

    public UsuarioEntity create(UsuarioDto usuarioDto) {
        return usuarioRepository.save(UsuarioEntity.builder()
                .id(usuarioDto.getId())
                .nome(usuarioDto.getNome())
                .email(usuarioDto.getEmail())
                .build());
    }

    public void delete(String id) {
        UsuarioEntity user = usuarioRepository.findById(id)
                        .orElseThrow(() -> new ObjectNotFoundException("Não encontrado"));
        usuarioRepository.deleteById(id);
    }

    public UsuarioEntity update(String id,UsuarioDto dto) {
        UsuarioEntity user = usuarioRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Não encontrado"));

        user.setNome(dto.getNome());
        user.setEmail(dto.getEmail());
        return usuarioRepository.save(user);
    }
}
