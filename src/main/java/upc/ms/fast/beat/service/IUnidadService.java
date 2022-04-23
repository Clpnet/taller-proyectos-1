package upc.ms.fast.beat.service;

import upc.ms.fast.beat.types.JSONResultDTO;
import upc.ms.fast.beat.types.UnidadDTO;

import java.util.List;

public interface IUnidadService {
	
	public JSONResultDTO<List<UnidadDTO>> findAll() ;

	public JSONResultDTO<UnidadDTO> findById(int id);
	
	public JSONResultDTO<UnidadDTO> save(UnidadDTO data) ;
	
	public JSONResultDTO<UnidadDTO> update(UnidadDTO data, int id);
	
	public JSONResultDTO<UnidadDTO> delete(int id);
	
	public JSONResultDTO<UnidadDTO> disabledUnity(int id) ;
}
