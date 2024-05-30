package br.com.oceandex.models.dtos;

public record AtualizarAnimalDto(
        String nomeComum,
        String nomeCientifico,
        String descricao,
        String status,
        String imagem,
        Long idEspecie,
        Long idDieta
) {
}
