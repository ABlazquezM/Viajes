package practica.viajes.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import practica.viajes.model.PasajeroDTO;
import practica.viajes.persistence.entities.PasajeroEntity;
import practica.viajes.persistence.entities.ViajeEntity;

@Mapper(componentModel = "spring")
public interface PasajeroMappers {
	
	@Mapping(source = "viaje", target = "viajeId", qualifiedByName = "mapViajeId")
	PasajeroDTO PasajeroEntityToPasajeroDTO(PasajeroEntity pasajeroEntity);
	
	PasajeroEntity PasajeroDTOToPasajeroEntity(PasajeroDTO pasajeroDTO);
	
	List<PasajeroDTO> listaToDTO(List<PasajeroEntity> listaEntity);
	

	@Named("mapViajeId")
	default Integer mapViajeId(ViajeEntity viajeEntity) {
		if(viajeEntity != null) {
			return viajeEntity.getViajeId();
		}
		return null;
	}
}
