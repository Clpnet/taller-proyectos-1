package upc.ms.fast.beat.service;

public interface IGenericService<T>{
	
	public T findAll() ;

	public T save();
	
	public T update(T data, int id);
	
	public T delete(int id);
	
}
