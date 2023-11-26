package practica.viajes.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import practica.viajes.persistence.entities.PasajeroEntity;

public interface PasajeroRepository extends JpaRepository<PasajeroEntity, Integer> {

}
