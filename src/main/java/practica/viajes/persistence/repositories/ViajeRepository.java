package practica.viajes.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import practica.viajes.persistence.entities.ViajeEntity;

public interface ViajeRepository extends JpaRepository<ViajeEntity, Integer> {

}
