package br.com.oceandex.models.dtos.usuario;

public record AtualizarUsuarioDto(
        String nome,
        String email,
        String senha,
        String fotoDePerfil
) {
}
