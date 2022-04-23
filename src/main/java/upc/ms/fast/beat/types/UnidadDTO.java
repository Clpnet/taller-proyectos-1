package upc.ms.fast.beat.types;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnidadDTO {
	
	public  int id;
	public String nro_placa;
	public String nro_serie;
	public String nro_motor;
	public String color ;
	public String marca ;
	public String  modelo; 
	public int sede_id;
	public int estado_id;
	
	public boolean enabled;
}

