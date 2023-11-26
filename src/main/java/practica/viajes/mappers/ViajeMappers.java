package practica.viajes.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import practica.viajes.model.ViajeDTO;
import practica.viajes.persistence.entities.ViajeEntity;

@Mapper(componentModel = "spring", uses = {PasajeroMappers.class})
public interface ViajeMappers {
	
	ViajeDTO viajeEntityToViajeDTO(ViajeEntity viajeEntity);
	
	ViajeEntity viajeDTOToViajeEntity(ViajeDTO viajeDTO);
	
	List<ViajeDTO> listaToDTO(List<ViajeEntity> listaEntity);

}
