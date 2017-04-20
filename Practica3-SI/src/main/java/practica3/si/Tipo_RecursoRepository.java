package practica3.si;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface Tipo_RecursoRepository extends CrudRepository<Tipo_Recurso, Integer> {
	
	List<Tipo_Recurso> findByTipo(String tipo);
	List<Tipo_Recurso> findByIdr(Integer idr);

}
