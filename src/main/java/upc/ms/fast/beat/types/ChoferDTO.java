package upc.ms.fast.beat.types;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChoferDTO {

	public int id;
	public String nombres;
	public String apellidos ;
	public String celular ;
	public Date fecha_nacimiento;
	public DocumentoIdentidadDTO documentoIdentidad;
	public boolean enabled;
	public String getNombresCompletos() {
		
		return this.nombres +" " + this.apellidos;
	}
	
}
