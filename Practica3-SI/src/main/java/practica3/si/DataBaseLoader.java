package practica3.si;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataBaseLoader {

	@Autowired
	private AccesosRepository accesosrepository;

	@Autowired
	private Tipo_RecursoRepository tipo_recursorepository;

	@Autowired
	private TiempoRepository tiemporepository;

	//@RequestMapping("/")
	//@ResponseBody
	@PostConstruct
	public void initDatabase() {
		String strLine = "";
		String[] textoSplit;
		String[] fechaSplit;
		String[] textoRecurso;
		String[] textoRecursoSplitEspacios;
		try {
			FileInputStream fstream = new FileInputStream("src/main/resources/static/mas-accesos-servidor-nitflex.log");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			while ((strLine = br.readLine()) != null) {
				if (strLine.contains("/nitflex")) {
					System.out.println(strLine);
					//Una vez extraida la linea actual del fichero log (strLine) utilizamos el metodo split para dividir la linea
					//en diferentes String usando el simbolo "-" para dividirlos
					textoSplit = strLine.split("\"-\"");
					
					//Buscamos el simbolo "+" que es el punto donde termina la fecha, siendo el caracter "[" el inicio de la fecha
					//que al haber hecho split con "-" ya tenemos el valor de "[" que seria 0 o 1 entonces la fecha empieza en la
					//posicion siguiente
					int finFecha = textoSplit[0].indexOf("+");
					int inicioFecha = textoSplit[0].indexOf("[");
					//Guardamos en fechaHora tanto la fecha como la hora, la fecha esta entre "/" y la hora entre ":"
					String fechaHora = textoSplit[0].substring(inicioFecha+1,finFecha-1);
					
					//Como entre la fecha y la hora hay ":" cogemos el valor para tener un eje en el que movernos entre fecha y hora
					int inicioHora = fechaHora.indexOf(":");
					
					//Desde el eje inicioHora extraemos tanto la fecha como la hora
					String fecha = fechaHora.substring(0,inicioHora);
					String horaString = fechaHora.substring(inicioHora+1,fechaHora.length());
					
					//De la variable fecha procedemos a extraer el dia, el mes y el año
					fechaSplit = fecha.split("/");
					String diaString = fechaSplit[0];
					String mesString = fechaSplit[1];
					String anioString = fechaSplit[2];
					
					//De la hora eliminamos los caracteres ":" para obtener un String limpio para convertirlo posteriormente en un int
					horaString = horaString.replace(":", "");
					
					//Ahora procedemos con el recurso, siendo el inicio el simbolo " (comillas dobles) y el final el tamaño del String
					//en la segunda posicion del array que anteriormente creamos al hacer split de la linea extraida del log
					textoRecurso = textoSplit[0].split("] \"");
					textoRecursoSplitEspacios = textoRecurso[1].split(" ");		
					int finExtension = textoRecursoSplitEspacios[1].lastIndexOf(".");
					String recurso = textoRecursoSplitEspacios[1].substring(finExtension,textoRecursoSplitEspacios[1].length());
					
					//Cambiamos los tipos de datos de tiempo
					int dia = Integer.parseInt(diaString);
					int mes = 3;
					int anio = Integer.parseInt(anioString);
					int hora = Integer.parseInt(horaString);
					
					//Creamos los diferentes objetos extraidos y los introducimos en la BBDD
					Tiempo tiempo = new Tiempo(dia, mes, anio, hora);
					tiemporepository.save(tiempo);
					
					Tipo_Recurso tipo_recurso = new Tipo_Recurso(recurso);
					tipo_recursorepository.save(tipo_recurso);
					
					Accesos accesos = new Accesos(tipo_recurso, tiempo);
					accesosrepository.save(accesos);
				}

			}
			fstream.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
