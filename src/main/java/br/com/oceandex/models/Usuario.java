package br.com.oceandex.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="OD_USUARIO")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "NM_USUARIO", length = 200, nullable = false)
    private String nome;

    @Column(name = "EMAIL_USUARIO", length = 100, nullable = false)
    private String email;

    @Column(name = "SENHA_USUARIO", length = 16, nullable = false)
    private String senha;

    @Column(name = "IMG_USUARIO", length = 100)
    private String fotoDePerfil;

    @Column(name = "DT_CADASTRO", nullable = false)
    private LocalDate dataDeCadastro;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<IdentificacaoDoAnimal> identificacoesDoAnimal;
}
