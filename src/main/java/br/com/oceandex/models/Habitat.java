package br.com.oceandex.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "OD_HABITAT")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Habitat {

    @Id
    @GeneratedValue
    @Column(name = "ID_HABITAT")
    private Long id;

    @Column(name = "NM_ESPECIE", length = 200, nullable = false)
    private String nome;

    @Column(name = "DESC_HABITAT", length = 300, nullable = false)
    private String descricao;

    @Column(name = "CLIMA_HABITAT", length = 50, nullable = false)
    private String clima;

    @Column(name = "VEG_HABITAT", length = 100, nullable = false)
    private String vegetacao;

    @Column(name = "REGIAO_HABITAT", length = 100, nullable = false)
    private String regiao;

    @Column(name = "DT_CADASTRO", nullable = false)
    private LocalDate dataDeCadastro;

    @ManyToMany(mappedBy = "habitats")
    private List<Animal> animais;
}
