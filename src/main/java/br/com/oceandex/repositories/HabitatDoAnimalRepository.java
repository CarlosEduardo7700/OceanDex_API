package br.com.oceandex.repositories;

import br.com.oceandex.models.Animal;
import br.com.oceandex.models.HabitatDoAnimal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HabitatDoAnimalRepository extends JpaRepository<HabitatDoAnimal, Long> {

    @Query("select ha.animal from HabitatDoAnimal ha where ha.habitat.nome = :nome")
    Page<Animal> buscarAnimaisPorNomeDoHabitat(String nome, Pageable pageable);
}
