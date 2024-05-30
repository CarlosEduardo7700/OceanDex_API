package br.com.oceandex.repositories;

import br.com.oceandex.models.Especie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecieRepository extends JpaRepository<Especie, Long> {
}
