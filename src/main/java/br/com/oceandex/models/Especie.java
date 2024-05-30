package br.com.oceandex.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "OD_ESPECIE")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Especie {

    @Id
    @GeneratedValue
    @Column(name = "ID_ESPECIE")
    private Long id;

    @Column(name = "NM_ESPECIE", length = 200, nullable = false)
    private String nome;

    @Column(name = "DESC_ESPECIE", length = 500, nullable = false)
    private String descricao;

    @CreatedDate
    @Column(name = "DT_CADASTRO", nullable = false)
    private LocalDate dataDeCadastro;

    @OneToMany(mappedBy = "especie", fetch = FetchType.LAZY)
    private List<Animal> animais;
}
