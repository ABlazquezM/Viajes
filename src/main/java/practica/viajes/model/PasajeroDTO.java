package practica.viajes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasajeroDTO {
	
	private Integer id;
	private String nombre;
	private Integer viajeId;
	
	
	
	///////////////////////////
	
	public PasajeroDTO(Integer id, String nombre, Integer viajeId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.viajeId = viajeId;
	}
	
	public PasajeroDTO() {}

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

	public Integer getViajeId() {
		return viajeId;
	}

	public void setViajeId(Integer viajeId) {
		this.viajeId = viajeId;
	}
	
	
	

}
