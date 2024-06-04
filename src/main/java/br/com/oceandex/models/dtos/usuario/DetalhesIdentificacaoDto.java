package br.com.oceandex.models.dtos.usuario;

import br.com.oceandex.models.Animal;
import br.com.oceandex.models.IdentificacaoDoAnimal;
import br.com.oceandex.models.Usuario;
import br.com.oceandex.models.dtos.animal.DetalhesAnimaisDto;

public record DetalhesIdentificacaoDto(
        Long id,
        DetalhesAnimaisDto animal
) {
    public DetalhesIdentificacaoDto(IdentificacaoDoAnimal identificacaoDoAnimal) {
        this(
                identificacaoDoAnimal.getId(),
                new DetalhesAnimaisDto(identificacaoDoAnimal.getAnimal())
        );
    }
}
