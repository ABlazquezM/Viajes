package practica.viajes.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViajeDTO {
	
	
	private Integer viajeId;
	private String destino;
	private String descripcion;
	private Integer precio;
	private List<PasajeroDTO> pasajeros;
	
	
	
	//////////
	
	public ViajeDTO(Integer viajeId, String destino, String descripcion, Integer precio, List<PasajeroDTO> pasajeros) {
		super();
		this.viajeId = viajeId;
		this.destino = destino;
		this.descripcion = descripcion;
		this.precio = precio;
		this.pasajeros = pasajeros;
	}
	
	
	public ViajeDTO() {}


	public Integer getViajeId() {
		return viajeId;
	}


	public void setViajeId(Integer viajeId) {
		this.viajeId = viajeId;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getPrecio() {
		return precio;
	}


	public void setPrecio(Integer precio) {
		this.precio = precio;
	}


	public List<PasajeroDTO> getPasajeros() {
		return pasajeros;
	}


	public void setPasajeros(List<PasajeroDTO> pasajeros) {
		this.pasajeros = pasajeros;
	}
	
	

}
