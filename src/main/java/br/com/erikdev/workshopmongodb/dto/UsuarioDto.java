package br.com.erikdev.workshopmongodb.dto;

import br.com.erikdev.workshopmongodb.domain.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UsuarioDto {

    private String id;
    private String nome;
    private String email;

    public UsuarioDto(UsuarioEntity usuarioEntity) {
        this.id = usuarioEntity.getId();
        this.nome = usuarioEntity.getNome();
        this.email = usuarioEntity.getEmail();
    }
}
