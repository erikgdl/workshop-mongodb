package br.com.erikdev.workshopmongodb.dto;

import br.com.erikdev.workshopmongodb.domain.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AutorDto {

    private String id;
    private String nome;
    private String autor;

    public AutorDto(UsuarioEntity usuarioEntity) {
        this.id = usuarioEntity.getId();
        this.nome = usuarioEntity.getNome();
    }
}
