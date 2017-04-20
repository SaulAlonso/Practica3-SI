package practica3.si;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TiempoRepository extends CrudRepository<Tiempo, Integer> {
	
	List<Tiempo> findByDia(int dia);
	List<Tiempo> findByAnio(int anio);
	List<Tiempo> findByHora(int hora);
	List<Tiempo> findByMes(int mes);
	

}
