package practica.viajes.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practica.viajes.mappers.PasajeroMappers;
import practica.viajes.model.PasajeroDTO;
import practica.viajes.persistence.entities.PasajeroEntity;
import practica.viajes.persistence.entities.ViajeEntity;
import practica.viajes.persistence.repositories.PasajeroRepository;
import practica.viajes.persistence.repositories.ViajeRepository;

@Service
public class PasajeroServiceImpl implements PasajeroService{
	
	@Autowired
	PasajeroRepository pasajeroRepository;
	
	@Autowired
	PasajeroMappers pasajeroMappers;
	
	@Autowired
	ViajeRepository viajeRepository;

	@Override
	public PasajeroDTO crearPasajero(PasajeroDTO pasajeroDTO) {
		
		PasajeroEntity pasajeroEntity = pasajeroRepository.save(pasajeroMappers.PasajeroDTOToPasajeroEntity(pasajeroDTO));
		
		return pasajeroMappers.PasajeroEntityToPasajeroDTO(pasajeroEntity);
	}

	@Override
	public PasajeroDTO crearPasajeroConViaje(PasajeroDTO pasajeroDTO) {
		PasajeroEntity pasajeroEntity = pasajeroMappers.PasajeroDTOToPasajeroEntity(pasajeroDTO);
		
		Optional<ViajeEntity> optViajeEntity = viajeRepository.findById(pasajeroDTO.getViajeId());
		
		if(optViajeEntity.isPresent()) {
			pasajeroEntity.setViaje(optViajeEntity.get());
		}
		
		
		pasajeroEntity = pasajeroRepository.save(pasajeroEntity);
		
		return pasajeroMappers.PasajeroEntityToPasajeroDTO(pasajeroEntity);
	}

	@Override
	public List<PasajeroDTO> verTodosLosPasajeros() {
		
		List<PasajeroEntity> listaPasajeros = pasajeroRepository.findAll();
		
		List<PasajeroDTO> listaPasajerosDTO = pasajeroMappers.listaToDTO(listaPasajeros);
		
		
		return listaPasajerosDTO;
	}

	@Override
	public PasajeroDTO añadirPasajeroAViaje(Integer PasajeroId, Integer ViajeId) {
		PasajeroEntity pasajeroEntity = new PasajeroEntity();
		
		Optional <PasajeroEntity> pasajeroOpt = pasajeroRepository.findById(PasajeroId);
		
		Optional <ViajeEntity> viajeOpt = viajeRepository.findById(ViajeId);
		
		if(pasajeroOpt.isPresent()) {
			pasajeroEntity = pasajeroOpt.get();
			
			if(viajeOpt.isPresent()) {
				pasajeroEntity.setViaje(viajeOpt.get());
			}
		}
		
		pasajeroEntity = pasajeroRepository.save(pasajeroEntity);
		
		return pasajeroMappers.PasajeroEntityToPasajeroDTO(pasajeroEntity);
	}
	
	

}
