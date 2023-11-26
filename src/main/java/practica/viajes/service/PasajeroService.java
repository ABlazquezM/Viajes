package practica.viajes.service;

import java.util.List;

import practica.viajes.model.PasajeroDTO;

public interface PasajeroService {
	
	PasajeroDTO crearPasajero(PasajeroDTO pasajeroDTO);
	
	PasajeroDTO crearPasajeroConViaje(PasajeroDTO pasajeroDTO);
	
	List<PasajeroDTO> verTodosLosPasajeros();
	
	PasajeroDTO añadirPasajeroAViaje(Integer PasajeroId, Integer ViajeId);

}
