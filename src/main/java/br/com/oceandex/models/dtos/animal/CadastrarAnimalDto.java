package br.com.oceandex.models.dtos.animal;

import br.com.oceandex.models.Especie;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastrarAnimalDto(
        @NotBlank
        String nomeComum,
        @NotBlank
        String nomeCientifico,
        @NotBlank
        String descricao,
        @NotBlank
        String status,
        @NotBlank
        String imagem,
        @NotNull
        Long idEspecie,
        @NotNull
        Long idDieta
) {
}
