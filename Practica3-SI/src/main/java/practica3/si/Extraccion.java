package practica3.si;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Extraccion {

	@Autowired
	private AccesosRepository accesosrepository;

	@Autowired
	private TipoRecursoRepository tipo_recursorepository;

	@Autowired
	private TiempoRepository tiemporepository;

	@RequestMapping("/nitflex")
	@ResponseBody
	public List<String> extraccion() {
		Accesos acceso;
		Tiempo tiempo;
		Tipo_Recurso tipo_recurso;
		String strLine = "";
		List<String> texto = new ArrayList<>();
		int i = 0;
		try {
			FileInputStream fstream = new FileInputStream("src/main/resources/static/mas-accesos-servidor-nitflex.log");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			while ((strLine = br.readLine()) != null) {
				if (strLine.contains("/nitflex")) {					
					
				}

			}
			fstream.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

		return texto;

	}
}
