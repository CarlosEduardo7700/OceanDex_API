package br.com.oceandex.models.dtos.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginUsuarioDto(
        @Email(message = "Formato de email inválido!")
        @NotBlank(message = "Email é obrigatório!")
        @Size(max = 100)
        String email,
        @NotBlank(message = "Senha é obrigatório!")
        @Size(max = 16)
        String senha
) {
}
