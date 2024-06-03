package br.com.oceandex.models.dtos.usuario;

public record CadastrarUsuarioDto(
        String nome,
        String email,
        String senha,
        String fotoDePerfil
) {
}
