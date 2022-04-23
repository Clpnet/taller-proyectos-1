package upc.ms.fast.beat.utils;

import upc.ms.fast.beat.entity.Chofer;
import upc.ms.fast.beat.entity.Unidad;
import upc.ms.fast.beat.types.ChoferDTO;
import upc.ms.fast.beat.types.UnidadDTO;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

	
	public static List<UnidadDTO> convertToListUnityDTO(List<Unidad> entity) {

		List<UnidadDTO> lista=new ArrayList<UnidadDTO>();
		
		entity.forEach(e->{
		
			UnidadDTO u = UnidadDTO.builder().color(e.color)
					.estado_id(e.estado_id)
					.id(e.id)
					.marca(e.marca)
					.modelo(e.modelo)
					.nro_motor(e.nro_motor)
					.nro_placa(e.nro_placa)
					.nro_serie(e.nro_serie)
					.sede_id(e.sede_id).build();

			lista.add(u);
		});
		
		return lista;

	}
	

	public static UnidadDTO convertToUnityDTO(Unidad e) {

		
			UnidadDTO u = UnidadDTO.builder().color(e.color)
					.estado_id(e.estado_id)
					.id(e.id)
					.marca(e.marca)
					.modelo(e.modelo)
					.nro_motor(e.nro_motor)
					.nro_placa(e.nro_placa)
					.nro_serie(e.nro_serie)
					.sede_id(e.sede_id).build();

		
		return u;

	}
	
	public static Unidad convertToEntityUnidad(UnidadDTO e) {

		
		Unidad u = Unidad.builder().color(e.color)
				.estado_id(e.estado_id)
				.marca(e.marca)
				.modelo(e.modelo)
				.nro_motor(e.nro_motor)
				.nro_placa(e.nro_placa)
				.nro_serie(e.nro_serie)
				.sede_id(e.sede_id).build();

	
	return u;

}
	
	
	public static List<Unidad> convertToListUnityEntity(List<UnidadDTO> entities) {

		List<Unidad> list =new ArrayList<Unidad>();
		
		entities.forEach(e->{
		
			Unidad u = Unidad.builder().color(e.color)
					.estado_id(e.estado_id)
					.id(e.id)
					.marca(e.marca)
					.modelo(e.modelo)
					.nro_motor(e.nro_motor)
					.nro_placa(e.nro_placa)
					.nro_serie(e.nro_serie)
					.sede_id(e.sede_id).build();

			list.add(u);
		});
		
		return list;

	}
	
	
	
	public static List<Chofer> convertToListChoferEntity(List<ChoferDTO> entities) {

		List<Chofer> list =new ArrayList<Chofer>();
		
		entities.forEach(e->{
			
			Chofer c = Chofer.builder()
			.apellidos(e.apellidos)
			.celular(e.celular)
			.fecha_nacimiento(e.fecha_nacimiento)
			.nombres(e.nombres)
			.id(e.id)
			.build();

			list.add(c);
		});
		
		return list;

	}
	
	public static List<ChoferDTO> convertToListChoferDTO(List<Chofer> entities) {

		List<ChoferDTO> list =new ArrayList<ChoferDTO>();
		
		entities.forEach(e->{
			
			ChoferDTO c = ChoferDTO.builder()
			.apellidos(e.apellidos)
			.celular(e.celular)
			.fecha_nacimiento(e.fecha_nacimiento)
			.nombres(e.nombres)
			.id(e.id)
			.build();

			list.add(c);
		});
		
		return list;

	}
	
	public static Chofer convertChoferEntity(ChoferDTO entity) {

			Chofer c = Chofer.builder()
			.apellidos(entity.apellidos)
			.celular(entity.celular)
			.fecha_nacimiento(entity.fecha_nacimiento)
			.nombres(entity.nombres)
			.id(entity.id)
			.build();
		
		
		return c;

	}
	
	public static ChoferDTO convertChoferDTO(Chofer entity) {

		ChoferDTO c = ChoferDTO.builder()
		.apellidos(entity.apellidos)
		.celular(entity.celular)
		.fecha_nacimiento(entity.fecha_nacimiento)
		.nombres(entity.nombres)
		.id(entity.id)
		.build();
	
	
	return c;

}

}
