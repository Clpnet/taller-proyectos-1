package upc.ms.fast.beat.service.impl;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import upc.ms.fast.beat.entity.Parametros;
import upc.ms.fast.beat.entity.Unidad;
import upc.ms.fast.beat.mappers.UnidadMapper;
import upc.ms.fast.beat.repository.IParametrosRepository;
import upc.ms.fast.beat.repository.IUnidadRepository;
import upc.ms.fast.beat.repository.IUsersRepository;
import upc.ms.fast.beat.service.IUnidadService;
import upc.ms.fast.beat.types.JSONResultDTO;
import upc.ms.fast.beat.types.UnidadDTO;
import upc.ms.fast.beat.utils.EmailUtils;
import upc.ms.fast.beat.utils.Mapper;

import java.util.*;

@Service
public class UnidadService implements IUnidadService {

	@Autowired
	IUnidadRepository unidadRepository;

	@Autowired
	private IParametrosRepository iParametrosRepository;

	@Autowired
	private EmailUtils emailUtils;

	@Autowired
	private UnidadMapper unidadMapper;

	@Override
	public JSONResultDTO<List<UnidadDTO>> findAll() {

		List<Unidad> lista = unidadRepository.findAll();
	
		JSONResultDTO<List<UnidadDTO>> result =
				new JSONResultDTO<List<UnidadDTO>>(Mapper.convertToListUnityDTO(lista),"",true);
		
		return result;
	}

	@Override
	public JSONResultDTO<UnidadDTO> save(UnidadDTO data) {

		Unidad u = Mapper.convertToEntityUnidad(data);
		
		if(u==null) {

			// Retorno de la petición de la solicitud http con un consturctor JSONResultDto ("mensaje", false);
		}
		JSONResultDTO<UnidadDTO> result =
				new JSONResultDTO<UnidadDTO>(Mapper.convertToUnityDTO(unidadRepository.save(u)),"",true);
		
		
		return  result;

	}

	@Override
	public JSONResultDTO<UnidadDTO> update(UnidadDTO data, int id) {
		
		Unidad u = unidadRepository.findById(id).orElse(null);
		u.color =data.color;
		u.estado_id=data.estado_id;
		u.marca = data.marca;
		u.modelo = data.modelo;
		u.kilometraje = data.kilometraje;
		u.enabled = data.enabled;
		u.nro_motor = data.nro_motor;
		u.nro_placa = data.nro_placa;
		u.nro_serie = data.nro_serie;
		u.sede_id = data.sede_id;
		
		UnidadDTO saved = Mapper.convertToUnityDTO(unidadRepository.save(u));
		
		
		// if(saved==null){ lógica de validación de error}
		
		JSONResultDTO<UnidadDTO> result =
				new JSONResultDTO<UnidadDTO>(saved,"",true);
		
		
		return  result;
	}

	@Override
	public JSONResultDTO<UnidadDTO> delete(int id) {
		
		Unidad u = unidadRepository.findById(id).orElse(null);
		// lógica de validación
		//if(u==null){ agregar lógica de validación} 
		
		unidadRepository.deleteById(id);
		
		JSONResultDTO<UnidadDTO> result =
				new JSONResultDTO<UnidadDTO>(Mapper.convertToUnityDTO(u),"",true);
		
		return  result;
	}

	@Override
	public JSONResultDTO<UnidadDTO> disabledUnity(int id) {
		
		Unidad u = unidadRepository.findById(id).orElse(null);
		String msj = ""; 
		// lógica de validación
		//if(u==null){ agregar lógica de validación} 
		
	
		u.enabled = !u.enabled;
		msj = u.enabled==true ? "Se ha habilitado la unidad" : "Se ha deshabilitado la unidad";
		
		JSONResultDTO<UnidadDTO> result =
				new JSONResultDTO<UnidadDTO>(Mapper.convertToUnityDTO(u),msj,true);
		
		return  result;
	}
	
	@Override
	public JSONResultDTO<UnidadDTO> findById(int id) {
		
		Unidad u = unidadRepository.findById(id).orElse(null);
		String msj = ""; 
		// lógica de validación
		//if(u==null){ agregar lógica de validación} 
		
		JSONResultDTO<UnidadDTO> result =
				new JSONResultDTO<UnidadDTO>(Mapper.convertToUnityDTO(u),msj,true);

		return  result;
	}


	@Override
	public JSONResultDTO<UnidadDTO> updatePerProp(UnidadDTO data, int id) {
		Unidad request = unidadMapper.parseUnidad(data);
		return Single.just(unidadRepository.getById(id))
				.map(unidad -> unidadMapper.updateUnidad(request, unidad))
				.map(unidad -> unidadRepository.save(unidad))
				.map(unidad -> sendNotificationKilometraje(request, unidad))
				.map(unidad -> unidadMapper.parseUnidadDTO(unidad))
				.map(unidadDTO ->  JSONResultDTO.<UnidadDTO>builder()
						.data(unidadDTO)
						.build())
				.blockingGet();
	}

	public Unidad sendNotificationKilometraje(Unidad requestUnidad, Unidad toUpdate){
		if(Objects.isNull(requestUnidad.getKilometraje())){
			return requestUnidad;
		}
		List<Double> kmNotification = new ArrayList<>();
		List<String> emailsKmNotification = new ArrayList<>();
		Optional<Parametros> parametros = iParametrosRepository.findAll().stream().findFirst();
		if(parametros.isPresent()){
			if(StringUtils.hasText(parametros.get().getKmForNotification()) && StringUtils.hasText(parametros.get().getEmailsForKmNoti())){
				try {
					ObjectMapper objectMapper = new ObjectMapper();
					kmNotification = objectMapper.readValue(parametros.get().getKmForNotification(), new TypeReference<List<Double>>() {});
					emailsKmNotification = objectMapper.readValue(parametros.get().getEmailsForKmNoti(), new TypeReference<List<String>>() {});
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}
		if(!CollectionUtils.isEmpty(kmNotification) &&
				!CollectionUtils.isEmpty(emailsKmNotification) &&
				kmNotification.contains(requestUnidad.getKilometraje())){
			emailUtils.sendEmailWhitGmail(new HashSet<>(emailsKmNotification),
					"NOTIFICACION DE KILOMETRAJE",
					String.format("La unidad con placa %s ha alcanzado el kilometraje: %s.", toUpdate.getNro_placa(), requestUnidad.getKilometraje()));
		}
		return toUpdate;
	}
}
