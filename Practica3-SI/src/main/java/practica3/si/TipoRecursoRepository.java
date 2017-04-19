package practica3.si;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRecursoRepository extends JpaRepository<Tipo_Recurso, Long> {
	
	List<Tipo_Recurso> findByTipo(String tipo);
	List<Tipo_Recurso> findByIdr(int idr);

}
