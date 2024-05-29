package br.com.oceandex.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "OD_ANIMAL")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue
    @Column(name = "ID_ANIMAL")
    private Long id;

    @Column(name = "NM_ANIMAL", length = 200, nullable = false)
    private String nomeComum;

    @Column(name = "NM_CIENTIFICO_ANIMAL", length = 300, nullable = false)
    private String nomeCientifico;

    @Column(name = "DESC_ANIMAL", length = 300, nullable = false)
    private String descricao;

    @Column(name = "STATUS_ANIMAL", length = 20, nullable = false)
    private String status;

    @Column(name = "IMG_ANIMAL", length = 100, nullable = false)
    private String imagem;

    @Column(name = "DT_CAD_ANIMAL", nullable = false)
    private LocalDate dataDeCadastro;

    @ManyToOne
    @JoinColumn(name = "ID_ESPECIE", nullable = false)
    private Especie especie;
}
