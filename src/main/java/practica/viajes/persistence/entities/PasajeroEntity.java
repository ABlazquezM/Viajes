package practica.viajes.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PasajeroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String nombre;
	
	
	@ManyToOne
	@JoinColumn(name = "viaje_id")
	private ViajeEntity viaje;


	
	
	
	
	
	
	
	
	
	
	
	////////////////
	
	
	
	public PasajeroEntity(Integer id, String nombre, ViajeEntity viaje) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.viaje = viaje;
	}
	
	public PasajeroEntity() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ViajeEntity getViaje() {
		return viaje;
	}

	public void setViaje(ViajeEntity viaje) {
		this.viaje = viaje;
	}
	
	
	

	
	
	
	
}
