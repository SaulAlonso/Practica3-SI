package practica3.si;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccesosRepository extends JpaRepository<Accesos, Long> {
	
	List<Accesos> findByIda(int ida);
	List<Accesos> findByTiempo(Tiempo tiempo);
	List<Accesos> findByTiposRecurso(TipoRecurso tipo_recurso);

}
