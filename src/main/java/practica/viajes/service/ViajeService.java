package practica.viajes.service;

import java.util.List;

import practica.viajes.model.ViajeDTO;

public interface ViajeService {
	
	
	ViajeDTO crearViaje(ViajeDTO viajeDTO);
	
	List<ViajeDTO> listaDeViajes();
	
	ViajeDTO buscarViajePorId(Integer viajeId);


}
