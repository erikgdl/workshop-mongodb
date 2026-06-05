package br.com.erikdev.workshopmongodb.domain;

import br.com.erikdev.workshopmongodb.dto.ComentarioDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "post")
public class PostEntity {

    @Id
    private String id;
    private Date data;
    private String titulo;
    private String descricao;
    private UsuarioEntity autor;

    @JsonIgnore
    private List<ComentarioDto> comentarios =  new ArrayList<>();

}
