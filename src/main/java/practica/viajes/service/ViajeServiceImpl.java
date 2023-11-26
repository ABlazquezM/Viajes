package practica.viajes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practica.viajes.mappers.ViajeMappers;
import practica.viajes.model.ViajeDTO;
import practica.viajes.persistence.entities.ViajeEntity;
import practica.viajes.persistence.repositories.ViajeRepository;

@Service
public class ViajeServiceImpl implements ViajeService{
	
	@Autowired
	ViajeRepository viajeRepository;
	
	@Autowired
	ViajeMappers viajeMappers;

	@Override
	public ViajeDTO crearViaje(ViajeDTO viajeDTO) {

		ViajeEntity viajeEntity = viajeRepository.save(viajeMappers.viajeDTOToViajeEntity(viajeDTO));
		
		return viajeMappers.viajeEntityToViajeDTO(viajeEntity);
	}

	@Override
	public List<ViajeDTO> listaDeViajes() {

		List<ViajeEntity> listaViajes = viajeRepository.findAll();
		
		List<ViajeDTO> listaDTOviajes = viajeMappers.listaToDTO(listaViajes);
		
		return listaDTOviajes;
	}

	@Override
	public ViajeDTO buscarViajePorId(Integer viajeId) {
		
		Optional<ViajeEntity> viajeEntity  = viajeRepository.findById(viajeId);
		
		if(viajeEntity.isPresent()) {
			return viajeMappers.viajeEntityToViajeDTO(viajeEntity.get());
		}
		return null;
	}
	
	

}
