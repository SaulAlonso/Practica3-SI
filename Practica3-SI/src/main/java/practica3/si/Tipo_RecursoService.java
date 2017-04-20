package practica3.si;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Tipo_RecursoService {

	@Autowired
	private Tipo_RecursoRepository tipo_recursorepositorio;
	
	public List<Tipo_Recurso> getTipo_Recurso(){
		return (List<Tipo_Recurso>) tipo_recursorepositorio.findAll();
	}
	
	public Tipo_Recurso getTipo_Recurso(Integer idt){
		return tipo_recursorepositorio.findOne(idt);
	}
}
