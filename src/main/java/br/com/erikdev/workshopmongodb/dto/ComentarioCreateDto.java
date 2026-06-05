package br.com.erikdev.workshopmongodb.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ComentarioCreateDto {

    @NotBlank
    private String texto;

    @NotBlank
    private String autorId;
}
