package practica3.si;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Tipo_RecursoRepository extends JpaRepository<TipoRecurso, Long> {
	
	List<TipoRecurso> findByTipo(String tipo);
	List<TipoRecurso> findByIdr(int idr);

}
