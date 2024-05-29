package br.com.oceandex.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "OD_ESPECIE")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Especie {

    @Id
    @GeneratedValue
    @Column(name = "ID_ESPECIE")
    private Long id;

    @Column(name = "NM_ESPECIE", length = 200, nullable = false)
    private String nome;

    @Column(name = "DESC_ESPECIE", length = 500, nullable = false)
    private String descricao;

    @Column(name = "DT_CADASTRO", nullable = false)
    private LocalDate dataDeCadastro;
}
