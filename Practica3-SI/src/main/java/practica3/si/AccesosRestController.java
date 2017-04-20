package practica3.si;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccesosRestController {

	@Autowired
	private AccesosService accesosService;
	
	@RequestMapping(value="/nitflex", method= RequestMethod.GET)
	public List<Accesos> getAccesos(){
		return accesosService.getAccesos();
	}
	
	@RequestMapping(value="/nitflex/{index}", method= RequestMethod.GET)
	public Accesos getAccesos(@PathVariable("index") int index){
		return accesosService.getAccesos(index);
	}
}
