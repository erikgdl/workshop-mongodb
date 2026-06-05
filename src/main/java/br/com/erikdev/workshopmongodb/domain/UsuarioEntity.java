package br.com.erikdev.workshopmongodb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "usuarios")
public class UsuarioEntity {

    @Id
    private String id;
    private String nome;
    private String email;

    @DBRef(lazy = true)
    @JsonIgnore
    private List<PostEntity> posts = new ArrayList<>();

}
