package br.com.oceandex.models.dtos.animal;

import br.com.oceandex.models.Animal;

import java.time.LocalDate;

public record ListagemAnimalDto(
        Long id,
        String nomeComum,
        String nomeCientifico,
        String descricao,
        String imagem,
        LocalDate dataDeCadastro
) {
    public ListagemAnimalDto(Animal animal) {
        this(
                animal.getId(),
                animal.getNomeComum(),
                animal.getNomeCientifico(),
                animal.getDescricao(),
                animal.getImagem(),
                animal.getDataDeCadastro()
        );
    }
}
