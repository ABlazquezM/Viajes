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

import practica.viajes.model.ViajeDTO;
import practica.viajes.service.ViajeService;

@RestController
@RequestMapping("/viajes")
public class ViajeRestController {

	@Autowired
	ViajeService viajeService;
	
	@PostMapping
	ResponseEntity<?> crearViaje(@RequestBody ViajeDTO viajeDTO){
		
		ViajeDTO viaje = viajeService.crearViaje(viajeDTO);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/"+viaje.getViajeId()).buildAndExpand(viaje.getViajeId())
				.toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@GetMapping("/{cursoId}")
	ResponseEntity<?> buscarCursoPorId(@PathVariable Integer cursoId){
		ViajeDTO viajeDTO = viajeService.buscarViajePorId(cursoId);
		
		return ResponseEntity.ok(viajeDTO);
	}
	
	@GetMapping
	ResponseEntity<?> listaDeViajes(){
		
		
		List<ViajeDTO> lista = viajeService.listaDeViajes();
		
		return ResponseEntity.ok(lista);
	}
}
