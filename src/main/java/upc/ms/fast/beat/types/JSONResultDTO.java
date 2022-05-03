package upc.ms.fast.beat.types;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JSONResultDTO<T> {

	public T data;
	public String msj;
	public boolean status;



	public JSONResultDTO(String msj, boolean status) {
		this.msj = msj;
		this.status = status;
	}
	
	
	

	
	
	
}
