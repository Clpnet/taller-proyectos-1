package upc.ms.fast.beat.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.ms.fast.beat.service.IChoferService;
import upc.ms.fast.beat.types.ChoferDTO;
import upc.ms.fast.beat.types.JSONResultDTO;

import java.util.List;

@RestController
@RequestMapping("/chofer")
public class ChoferController {

	
	@Autowired
	private IChoferService choferService;
	
	@ApiOperation(value = "Este método devuelve las unidades existentes")
	@GetMapping
	public JSONResultDTO<List<ChoferDTO>> findAll(){
		return choferService.findAll();
	}
	
	@ApiOperation(value = "Este método devuelve las unidades existentes")
	@GetMapping("/{id}")
	public JSONResultDTO<ChoferDTO> findById(@PathVariable("id") int id){
		return choferService.findById(id);
	}
	
	
	
	@ApiOperation(value = "Permite crear las operaciones relacionadas a choferes ")
	@PostMapping
	public JSONResultDTO<ChoferDTO> save(@RequestBody ChoferDTO data){
		return choferService.save(data);
	}
	
	@DeleteMapping("/{id}")
	public JSONResultDTO<ChoferDTO> delete(@PathVariable(value = "id") int id) {
		return choferService.delete(id);
	}
	
	@PutMapping("/{id}")
	public JSONResultDTO<ChoferDTO> update(@PathVariable(value="id") int id, @RequestBody ChoferDTO data ){
		return choferService.update(data, id);
	}
	
	
	@PatchMapping("/{id}/changes")
	public JSONResultDTO<ChoferDTO> disabled(@PathVariable(value="id") int id ){
		return choferService.disabledChofer(id);
	}
	
	
}
