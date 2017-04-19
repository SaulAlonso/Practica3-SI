package practica3.si;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiempoRepository extends JpaRepository<Tiempo, Long> {
	
	List<Tiempo> findByDia(int dia);
	List<Tiempo> findByAnio(int anio);
	List<Tiempo> findByHora(int hora);
	List<Tiempo> findByMes(int mes);
	

}
