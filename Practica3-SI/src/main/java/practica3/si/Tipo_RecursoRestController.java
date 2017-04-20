package practica3.si;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Tipo_RecursoRestController {
	
	@Autowired
	private Tipo_RecursoService tipo_recursoService;

	@RequestMapping(value = "/nitflex/Tipo_Recursos", method = RequestMethod.GET)
	public List<Tipo_Recurso> getTipo_Recurso() {
		return tipo_recursoService.getTipo_Recurso();
	}

	@RequestMapping(value = "/nitflex/Tipo_Recursos/{index}", method = RequestMethod.GET)
	public Tipo_Recurso getTipo_Recurso(@PathVariable("index") int index) {
		return tipo_recursoService.getTipo_Recurso(index);
	}

}
