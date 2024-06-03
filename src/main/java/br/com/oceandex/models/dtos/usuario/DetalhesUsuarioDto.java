package br.com.oceandex.models.dtos.usuario;

import br.com.oceandex.models.Usuario;

import java.time.LocalDate;

public record DetalhesUsuarioDto(
        Long id,
        String nome,
        String email,
        String senha,
        String fotoDePerfil,
        LocalDate dataDeCadastro
) {
    public DetalhesUsuarioDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getFotoDePerfil(),
                usuario.getDataDeCadastro()
        );
    }
}
