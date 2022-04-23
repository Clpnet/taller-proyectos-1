package upc.ms.fast.beat.types;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class JSONResultDTO<T> {

	public T data;
	public String msj;
	public boolean status;
	
	public JSONResultDTO(String msj, boolean status) {
		super();
		this.msj = msj;
		this.status = status;
	}
	
	
	

	
	
	
}
