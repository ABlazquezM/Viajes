package practica.viajes.persistence.entities;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ViajeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer viajeId;
	
	private String destino;
	private String descripcion;
	private Integer precio;
	
	@OneToMany(mappedBy = "viaje")
	private List<PasajeroEntity> pasajeros;

	
	
	
	
	public ViajeEntity(Integer viajeId, String destino, String descripcion, Integer precio,
			List<PasajeroEntity> pasajeros) {
		super();
		this.viajeId = viajeId;
		this.destino = destino;
		this.descripcion = descripcion;
		this.precio = precio;
		this.pasajeros = pasajeros;
	}
	
	public ViajeEntity() {}

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

	public List<PasajeroEntity> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(List<PasajeroEntity> pasajeros) {
		this.pasajeros = pasajeros;
	}
	
	
	
	

}
