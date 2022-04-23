package upc.ms.fast.beat.service;

import upc.ms.fast.beat.types.ChoferDTO;
import upc.ms.fast.beat.types.JSONResultDTO;

import java.util.List;


public interface IChoferService {

	public JSONResultDTO<List<ChoferDTO>> findAll() ;

	public JSONResultDTO<ChoferDTO> save(ChoferDTO data);
	
	public JSONResultDTO<ChoferDTO> update(ChoferDTO data, int id);
	
	public JSONResultDTO<ChoferDTO> delete(int id);
	
	public JSONResultDTO<ChoferDTO> disabledChofer(int id);
	
	public JSONResultDTO<ChoferDTO> findById(int id);
}
