package br.com.oceandex.repositories;

import br.com.oceandex.models.Dieta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietaRepository extends JpaRepository<Dieta, Long> {
}
