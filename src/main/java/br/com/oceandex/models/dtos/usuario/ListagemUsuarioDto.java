package br.com.oceandex.models.dtos.usuario;

import br.com.oceandex.models.Usuario;

public record ListagemUsuarioDto(
        Long id,
        String nome,
        String email,
        String fotoDePerfil
) {
    public ListagemUsuarioDto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getFotoDePerfil()
        );
    }
}
