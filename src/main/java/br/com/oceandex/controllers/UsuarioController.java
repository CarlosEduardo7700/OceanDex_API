package br.com.oceandex.controllers;

import br.com.oceandex.models.Usuario;
import br.com.oceandex.models.dtos.CadastrarUsuarioDto;
import br.com.oceandex.models.dtos.DetalhesUsuarioDto;
import br.com.oceandex.repositories.UsuarioRepository;
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
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesUsuarioDto> cadastrar(@RequestBody @Valid CadastrarUsuarioDto dto,
                                                        UriComponentsBuilder builder){
        var usuario = new Usuario(dto);
        repository.save(usuario);
        var uri = builder.path("usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesUsuarioDto(usuario));
    }
}
