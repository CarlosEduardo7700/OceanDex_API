package br.com.oceandex.controllers;

import br.com.oceandex.models.Animal;
import br.com.oceandex.models.dtos.CadastrarAnimalDto;
import br.com.oceandex.models.dtos.DetalhesAnimaisDto;
import br.com.oceandex.repositories.AnimalRepository;
import br.com.oceandex.repositories.DietaRepository;
import br.com.oceandex.repositories.EspecieRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
}
