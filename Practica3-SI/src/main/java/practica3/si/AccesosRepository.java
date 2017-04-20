package practica3.si;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AccesosRepository extends CrudRepository<Accesos, Integer> {
	
	List<Accesos> findByIda(Integer ida);
	List<Accesos> findByTiempo(Tiempo tiempo);
	//List<Accesos> findByTiposRecurso(TipoRecurso tiporecurso);      *No consigo solucionar el error*

}
