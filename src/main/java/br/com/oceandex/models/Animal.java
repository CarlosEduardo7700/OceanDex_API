package br.com.oceandex.models;

import br.com.oceandex.models.dtos.animal.AtualizarAnimalDto;
import br.com.oceandex.models.dtos.animal.CadastrarAnimalDto;
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

    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY)
    private List<HabitatDoAnimal> habitatsDoAnimal;

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

    public void atualizarDados(AtualizarAnimalDto dto, Especie especie, Dieta dieta) {
        if (dto.nomeComum() != null)
            this.nomeComum = dto.nomeComum();
        if (dto.nomeCientifico() != null)
            this.nomeCientifico = dto.nomeCientifico();
        if (dto.descricao() != null)
            this.descricao = dto.descricao();
        if (dto.status() != null)
            this.status = dto.status();
        if (dto.imagem() != null)
            this.imagem = dto.imagem();
        if (especie != null)
            this.especie = especie;
        if (dieta != null)
            this.dieta = dieta;

    }
}
