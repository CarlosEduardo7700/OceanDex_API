package br.com.oceandex.models.dtos;

public record AtualizarUsuarioDto(
        String nome,
        String email,
        String senha,
        String fotoDePerfil
) {
}
