package practica3.si;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TiempoRestController {
	
	@Autowired
	private TiempoService tiempoService;

	@RequestMapping(value = "/intento/Tiempo", method = RequestMethod.GET)
	public List<Tiempo> getIntento() {
		return tiempoService.getTiempo();
	}

	@RequestMapping(value = "/intento/Tiempo/{index}", method = RequestMethod.GET)
	public Tiempo getIntento(@PathVariable("index") int index) {
		return tiempoService.getTiempo(index);
	}

}
