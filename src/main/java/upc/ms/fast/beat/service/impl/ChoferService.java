package upc.ms.fast.beat.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.ms.fast.beat.entity.Chofer;
import upc.ms.fast.beat.enums.Messages;
import upc.ms.fast.beat.repository.IChoferRepository;
import upc.ms.fast.beat.service.IChoferService;
import upc.ms.fast.beat.types.ChoferDTO;
import upc.ms.fast.beat.types.JSONResultDTO;
import upc.ms.fast.beat.utils.Mapper;
import upc.ms.fast.beat.utils.WhatsAppUtil;

import java.util.List;

@Service
public class ChoferService implements IChoferService {

	@Autowired
	private IChoferRepository choferRepository;

	@Autowired
	private WhatsAppUtil whatsAppService;
	
	@Override
	public JSONResultDTO<List<ChoferDTO>> findAll() {
		
		List<Chofer> lista = choferRepository.findAll();
		
		JSONResultDTO<List<ChoferDTO>> result =
				new JSONResultDTO<List<ChoferDTO>>(Mapper.convertToListChoferDTO(lista),"",true);
		
		return result;
	}
	
	@Override
	public JSONResultDTO<ChoferDTO> disabledChofer(int id) {
		
		Chofer c = choferRepository.findById(id).orElse(null);
		String msj = ""; 
		// lógica de validación
		//if(u==null){ agregar lógica de validación} 
	
		c.enabled = !c.enabled;
		msj = c.enabled==true ? "habilitada" : "deshabilitada";
		
		
		String msjReturn = String.format("Estimado %s %s, su cuenta ha sido %s, "
				+ "por favor comuniquese con su administrador",c.nombres,c.apellidos,msj);
		
		whatsAppService.sendWhatsApp("+51934758933",msjReturn);
		
		JSONResultDTO<ChoferDTO> result =
				new JSONResultDTO<ChoferDTO>(Mapper.convertChoferDTO(c),"success",true);
		
		return  result;
	}



	@Override
	public JSONResultDTO<ChoferDTO> save(ChoferDTO data) {
		// TODO Auto-generated method stub
		Chofer c = choferRepository.save(Mapper.convertChoferEntity(data));
		//lógica par validación
		//if(c==null){}
		
		
		JSONResultDTO<ChoferDTO> result =
				new JSONResultDTO<ChoferDTO>(Mapper.convertChoferDTO(c),"Se guardó el chofer",true);
		
		return result;
	}

	@Override
	public JSONResultDTO<ChoferDTO> update(ChoferDTO data, int id) {
		
		String msj = "";
		Chofer c = choferRepository.findById(id).orElse(null);
		c.apellidos = data.apellidos;
		c.celular = data.celular;
		c.fecha_nacimiento = data.fecha_nacimiento;
		c.nombres = data.nombres;
		
		choferRepository.save(Mapper.convertChoferEntity(data));
		//lógica par validación
		//if(c==null){msj="Se guardo de manera correcta"}
		
		
		JSONResultDTO<ChoferDTO> result =
				new JSONResultDTO<ChoferDTO>(Mapper.convertChoferDTO(c),msj,true);
		
		return result;
	}

	@Override
	public JSONResultDTO<ChoferDTO> delete(int id) {
		
		Chofer c = choferRepository.findById(id).orElse(null);
		String msj = "";
		try {
			choferRepository.deleteById(id);
			msj = Messages.DELETE.toString();
			
		} catch (Exception e) {
			// TODO: handle exception}
			msj = e.getMessage();
		}
		
		//lógica par validación
		//if(c==null){}
		
		
		JSONResultDTO<ChoferDTO> result =
				new JSONResultDTO<ChoferDTO>(Mapper.convertChoferDTO(c),msj,true);
		
		return result;
	}

	@Override
	public JSONResultDTO<ChoferDTO> findById(int id) {
		
		Chofer c = choferRepository.findById(id).orElse(null);
		String msj = ""; 
		// lógica de validación
		//if(u==null){ agregar lógica de validación} 
		
		
		JSONResultDTO<ChoferDTO> result =
				new JSONResultDTO<ChoferDTO>(Mapper.convertChoferDTO(c),msj,true);
		
		return  result;
	}
	

}
