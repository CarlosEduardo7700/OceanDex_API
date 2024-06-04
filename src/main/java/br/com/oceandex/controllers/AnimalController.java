package br.com.oceandex.controllers;

import br.com.oceandex.models.Animal;
import br.com.oceandex.models.Dieta;
import br.com.oceandex.models.Especie;
import br.com.oceandex.models.dtos.animal.AtualizarAnimalDto;
import br.com.oceandex.models.dtos.animal.CadastrarAnimalDto;
import br.com.oceandex.models.dtos.animal.DetalhesAnimaisDto;
import br.com.oceandex.models.dtos.animal.ListagemAnimalDto;
import br.com.oceandex.models.dtos.usuario.ListagemUsuarioDto;
import br.com.oceandex.repositories.AnimalRepository;
import br.com.oceandex.repositories.DietaRepository;
import br.com.oceandex.repositories.EspecieRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("animais")
public class AnimalController {

    @Autowired
    private AnimalRepository repository;

    @Autowired
    private EspecieRepository especieRepository;

    @Autowired
    private DietaRepository dietaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesAnimaisDto> cadastrar(@RequestBody @Valid CadastrarAnimalDto dto,
                                                        UriComponentsBuilder builder){
        var animal = new Animal(dto,
                                especieRepository.getReferenceById(dto.idEspecie()),
                                dietaRepository.getReferenceById(dto.idDieta()));
        repository.save(animal);
        var uri = builder.path("animais/{id}").buildAndExpand(animal.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesAnimaisDto(animal));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemAnimalDto>> buscarTudo(Pageable pageable) {
        var page = repository.findAll(pageable)
                .map(ListagemAnimalDto::new);

        if (!page.isEmpty())
            return ResponseEntity.ok(page);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesAnimaisDto> buscarPorId(@PathVariable("id") Long id) {
        var animal = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesAnimaisDto(animal));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesAnimaisDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizarAnimalDto dto) {
        var animal = repository.getReferenceById(id);
        Especie especie = null;
        Dieta dieta = null;

        if (dto.idEspecie() != null)
            especie = especieRepository.getReferenceById(dto.idEspecie());

        if (dto.idDieta() != null)
            dieta = dietaRepository.getReferenceById(dto.idDieta());

        animal.atualizarDados(dto, especie, dieta);

        return ResponseEntity.ok(new DetalhesAnimaisDto(animal));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
