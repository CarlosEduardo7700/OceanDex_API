package br.com.oceandex.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "OD_HABITAT_ANIMAL")
@IdClass(HabitatDoAnimalID.class)
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class HabitatDoAnimal {

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_ANIMAL", nullable = false)
    private Animal animal;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_HABITAT", nullable = false)
    private Habitat habitat;
}
