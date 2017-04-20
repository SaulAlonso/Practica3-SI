package practica3.si;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiempoService {

	@Autowired
	private TiempoRepository tiemporepositorio;
	
	public List<Tiempo> getTiempo(){
		return (List<Tiempo>) tiemporepositorio.findAll();
	}
	
	public Tiempo getTiempo(Integer idt){
		return tiemporepositorio.findOne(idt);
	}
}
