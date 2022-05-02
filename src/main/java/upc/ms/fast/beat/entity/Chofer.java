package upc.ms.fast.beat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Chofer {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int id;
	public String nombres;
	public String apellidos ;
	public String celular ;
	public Date fecha_nacimiento;
	public boolean enabled;
	
	
	//public DocumentoIdentidad documentoIdentidad;
}
