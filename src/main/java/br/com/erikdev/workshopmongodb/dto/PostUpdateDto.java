package br.com.erikdev.workshopmongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PostUpdateDto {

    private String titulo;
    private String descricao;
}
