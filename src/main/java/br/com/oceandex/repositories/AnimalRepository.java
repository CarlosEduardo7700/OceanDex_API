package br.com.oceandex.repositories;

import br.com.oceandex.models.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Page<Animal> findByEspecieNome(String nome, Pageable pageable);
    Page<Animal> findByDietaNome(String nome, Pageable pageable);
}
