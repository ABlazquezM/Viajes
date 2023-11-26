package practica.viajes.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import practica.viajes.model.PasajeroDTO;
import practica.viajes.model.ViajeDTO;
import practica.viajes.service.PasajeroService;

@RestController
@RequestMapping("/pasajeros")
public class PasajeroRestController {

	@Autowired
	PasajeroService pasajeroService;
	
	
	@PostMapping
	ResponseEntity<?> crearPasajero(@RequestBody PasajeroDTO pasajeroDTO){
		
		PasajeroDTO pasajero = pasajeroService.crearPasajero(pasajeroDTO);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/"+pasajero.getId()).buildAndExpand(pasajero.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/viaje")
	ResponseEntity<?> crearPasajeroConViaje(@RequestBody PasajeroDTO pasajeroDTO){
		PasajeroDTO pasajero = pasajeroService.crearPasajeroConViaje(pasajeroDTO);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/"+pasajero.getId()).buildAndExpand(pasajero.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	@PostMapping("/{pasajeroId}/inscripcion/{viajeId}")
	ResponseEntity<?> añadirPasajeroAViaje(@PathVariable Integer pasajeroId, @PathVariable Integer viajeId){
		PasajeroDTO pasajero = pasajeroService.añadirPasajeroAViaje(pasajeroId, viajeId);
		
		return ResponseEntity.ok(pasajero);
	}
	
	@GetMapping
	ResponseEntity<?> listaDePasajeros(){
		List<PasajeroDTO> lista = pasajeroService.verTodosLosPasajeros();
		
		return ResponseEntity.ok(lista);
	}
}
