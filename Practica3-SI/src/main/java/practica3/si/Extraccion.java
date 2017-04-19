package practica3.si;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Extraccion {
	
	@Autowired
	private AccesosRepository accesosrepository;
	
	@Autowired
	private Tipo_RecursoRepository tipo_recursorepository;
	
	@Autowired
	private TiempoRepository tiemporepository;

}
