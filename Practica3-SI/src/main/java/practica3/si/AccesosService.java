package practica3.si;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccesosService {
	
	@Autowired
	private AccesosRepository repositorio;
	
	public List<Accesos> getAccesos(){
		return (List<Accesos>) repositorio.findAll();
	}
	
	public Accesos getAccesos(Integer id){
		return repositorio.findOne(id);
	}

}
