package br.com.oceandex.controllers;

import br.com.oceandex.models.Usuario;
import br.com.oceandex.models.dtos.usuario.EmailUsuarioDto;
import br.com.oceandex.models.dtos.usuario.AtualizarUsuarioDto;
import br.com.oceandex.models.dtos.usuario.CadastrarUsuarioDto;
import br.com.oceandex.models.dtos.usuario.DetalhesUsuarioDto;
import br.com.oceandex.models.dtos.usuario.ListagemUsuarioDto;
import br.com.oceandex.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public ResponseEntity<Page<ListagemUsuarioDto>> buscarTudo(Pageable pageable) {

        var page = repository.findAll(pageable)
                .map(ListagemUsuarioDto::new);

        if (!page.isEmpty())
            return ResponseEntity.ok(page);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesUsuarioDto> buscarPorId(@PathVariable("id") Long id) {
        var usuario = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesUsuarioDto(usuario));
    }

    @GetMapping("email")
    public ResponseEntity<Page<DetalhesUsuarioDto>> buscarPorEmail(@RequestBody EmailUsuarioDto dto,
                                                                   Pageable pageable) {
        var page = repository.findByEmail(dto.email(), pageable).map(DetalhesUsuarioDto::new);
        if (!page.isEmpty())
            return ResponseEntity.ok(page);
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesUsuarioDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizarUsuarioDto dto) {
        var usuario = repository.getReferenceById(id);

        usuario.atualizarDados(dto);

        return ResponseEntity.ok(new DetalhesUsuarioDto(usuario));
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
