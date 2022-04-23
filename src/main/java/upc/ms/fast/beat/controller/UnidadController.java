package upc.ms.fast.beat.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import upc.ms.fast.beat.service.IUnidadService;
import upc.ms.fast.beat.types.JSONResultDTO;
import upc.ms.fast.beat.types.UnidadDTO;

import java.util.List;


@RestController
@RequestMapping("/unidades")
public class UnidadController {

	@Autowired
	private IUnidadService unidadService;
	
	@ApiOperation(value = "Este método devuelve las unidades existentes")
	@GetMapping
	public JSONResultDTO<List<UnidadDTO>> findAll(){
		return unidadService.findAll();
	}
	
	@ApiOperation(value = "Este método devuelve las unidades existentes")
	@GetMapping("/{id}")
	public JSONResultDTO<UnidadDTO> findById(@PathVariable(value = "id")int id){
		return unidadService.findById(id);
	}
	
	@ApiOperation(value = "Permite crear las operaciones relacionadas a unidades")
	@PostMapping
	public JSONResultDTO<UnidadDTO> save(@RequestBody UnidadDTO data){
		return unidadService.save(data);
	}
	
	@DeleteMapping
	public JSONResultDTO<UnidadDTO> delete(@PathVariable(value = "id") int id) {
		return unidadService.delete(id);
	}
	
	@PutMapping
	public JSONResultDTO<UnidadDTO> update(@PathVariable(value="id") int id, @RequestBody UnidadDTO data ){
		return unidadService.update(data, id);
	}
	
	
	
}
