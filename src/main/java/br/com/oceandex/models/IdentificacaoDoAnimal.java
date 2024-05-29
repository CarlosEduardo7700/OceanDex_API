package br.com.oceandex.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "OD_IDENTIFICACAO_ANIMAL")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class IdentificacaoDoAnimal {

    @Id
    @GeneratedValue
    @Column(name = "ID_USUARIO_ANIMAL")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_ANIMAL", nullable = false)
    private Animal animal;
}
