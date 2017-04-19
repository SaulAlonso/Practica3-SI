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

	@RequestMapping("/")
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
					
					//Una vez extraida la linea actual del fichero log (strLine) utilizamos el metodo split para dividir la linea
					//en diferentes String usando el simbolo "-" para dividirlos
					String[] textoSplit = strLine.split("-");
					
					//Buscamos el simbolo "+" que es el punto donde termina la fecha, siendo el caracter "[" el inicio de la fecha
					//que al haber hecho split con "-" ya tenemos el valor de "[" que seria 0 o 1 entonces la fecha empieza en la
					//posicion siguiente
					int finFecha = strLine.indexOf("+");
					
					//Guardamos en fechaHora tanto la fecha como la hora, la fecha esta entre "/" y la hora entre ":"
					String fechaHora = textoSplit[2].substring(2,finFecha-1);
					
					//Como entre la fecha y la hora hay ":" cogemos el valor para tener un eje en el que movernos entre fecha y hora
					int inicioHora = fechaHora.indexOf(":");
					
					//Desde el eje inicioHora extraemos tanto la fecha como la hora
					String fecha = fechaHora.substring(0,inicioHora);
					String hora = fechaHora.substring(inicioHora+1,fechaHora.length());
					
					//De la variable fecha procedemos a extraer el dia, el mes y el año
					String[] fechaSplit = fecha.split("/");
					String dia = fechaSplit[0];
					String mes = fechaSplit[1];
					String anio = fechaSplit[2];
					
					//De la hora eliminamos los caracteres ":" para obtener un String limpio para convertirlo posteriormente en un int
					hora = hora.replace(":", "");
					
					//Ahora procedemos con el recurso, siendo el inicio el simbolo " (comillas dobles) y el final el tamaño del String
					//en la segunda posicion del array que anteriormente creamos al hacer split de la linea extraida del log
					int inicioRecurso = strLine.indexOf("\"");
					int finRecurso = strLine.indexOf(" ");
					String textoRecurso = textoSplit[2].substring(inicioRecurso+1, finRecurso);
					int finExtension = textoRecurso.lastIndexOf(".");
					String recurso = textoRecurso.substring(finExtension+1,finRecurso);
					
					//Creamos los objetos
					//AQUI HAY UN PROBLEMA POR QUE PARA CREAR LOS OBJETOS POR QUE PARA
					//CREAR LOS OBJETOS EL ENUNCIADO PONE UN ID A CADA UNO DE TIPO INT PERO
					// LA BBDD USA ID TIPO LONG AUTOGENERADA Y NO SE QUE COJONES HACER AQUI
				}

			}
			fstream.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

		return texto;

	}
}
