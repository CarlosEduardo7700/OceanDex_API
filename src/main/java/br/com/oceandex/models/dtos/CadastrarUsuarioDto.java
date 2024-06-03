package br.com.oceandex.models.dtos;

public record CadastrarUsuarioDto(
        String nome,
        String email,
        String senha,
        String fotoDePerfil
) {
}
