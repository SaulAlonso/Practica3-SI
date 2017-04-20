package practica3.si;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tiempo {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	
	private int dia;
	private int mes;
	private int anio;
	private int hora;

	public Tiempo(int dia, int mes, int anio, int hora) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
		this.hora = hora;
	}

	public Tiempo() {
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Tiempo [dia=" + dia + ", mes=" + mes + ", anio=" + anio + ", hora=" + hora + "]";
	}

}
