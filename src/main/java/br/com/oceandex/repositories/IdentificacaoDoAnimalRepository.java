package br.com.oceandex.repositories;

import br.com.oceandex.models.IdentificacaoDoAnimal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentificacaoDoAnimalRepository extends JpaRepository<IdentificacaoDoAnimal, Long> {

    Page<IdentificacaoDoAnimal> findByUsuarioId(Long id, Pageable pageable);
}
