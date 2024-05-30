package br.com.oceandex.models;

import br.com.oceandex.models.dtos.CadastrarAnimalDto;
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
@Table(name = "OD_ANIMAL")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    @Column(name = "DT_CAD_ANIMAL", nullable = false)
    private LocalDate dataDeCadastro;

    @ManyToOne
    @JoinColumn(name = "ID_ESPECIE", nullable = false)
    private Especie especie;

    @ManyToOne
    @JoinColumn(name = "ID_DIETA", nullable = false)
    private Dieta dieta;

    @ManyToMany
    @JoinTable(name = "OD_HABITAT_ANIMAL",
                joinColumns = @JoinColumn(name = "ID_ANIMAL"),
                inverseJoinColumns = @JoinColumn(name = "ID_HABITAT"))
    private List<Habitat> habitats;

    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY)
    private List<IdentificacaoDoAnimal> identificacoesDoAnimal;

    public Animal(CadastrarAnimalDto dto, Especie especie, Dieta dieta) {
        this.nomeComum = dto.nomeComum();
        this.nomeCientifico = dto.nomeCientifico();
        this.descricao = dto.descricao();
        this.status = dto.status();
        this.imagem = dto.imagem();
        this.especie = especie;
        this.dieta = dieta;
    }
}
