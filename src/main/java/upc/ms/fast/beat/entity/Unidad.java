package upc.ms.fast.beat.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Unidad {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public  int id;

	public String nro_placa;
	public String nro_serie;
	public String nro_motor;
	public String color ;
	public String marca ;
	public String modelo;
	public Double kilometraje;
	public int sede_id;
	public int estado_id;
	public boolean enabled;
}
