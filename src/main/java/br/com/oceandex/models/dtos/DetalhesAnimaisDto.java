package br.com.oceandex.models.dtos;

import br.com.oceandex.models.Animal;
import br.com.oceandex.models.Dieta;
import br.com.oceandex.models.Especie;

import java.time.LocalDate;

public record DetalhesAnimaisDto(
        Long id,
        String nomeComum,
        String nomeCientifico,
        String descricao,
        String status,
        String imagem,
        LocalDate dataDeCadastro,
        String nomeEspecie,
        String nomeDieta
) {
    public DetalhesAnimaisDto(Animal animal) {
        this(
                animal.getId(),
                animal.getNomeComum(),
                animal.getNomeCientifico(),
                animal.getDescricao(),
                animal.getStatus(),
                animal.getImagem(),
                animal.getDataDeCadastro(),
                animal.getEspecie().getNome(),
                animal.getDieta().getNome()
        );
    }
}
