package br.com.erikdev.workshopmongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ComentarioDto {

    private String texto;
    private Date data;
    private AutorDto autor;

}
