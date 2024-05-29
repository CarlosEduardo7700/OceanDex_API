package br.com.oceandex.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "OD_DIETA")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Dieta {

    @Id
    @GeneratedValue
    @Column(name = "ID_DIETA")
    private Long id;

    @Column(name = "NM_DIETA", length = 100, nullable = false)
    private String nome;

    @Column(name = "DESC_DIETA", length = 200, nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "dieta", fetch = FetchType.LAZY)
    private List<Animal> animais;
}
