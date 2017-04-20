package practica3.si;

import javax.persistence.*;

@Entity
public class Accesos {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)	
	private Integer ida;
	
	@OneToOne 
	private Tipo_Recurso tipo_recurso;
	
	@OneToOne 
	private Tiempo tiempo;

	public Accesos(Tipo_Recurso tipo_recurso, Tiempo tiempo) {
		this.tipo_recurso = tipo_recurso;
		this.tiempo = tiempo;
	}

	public Accesos() {
	}

	public Integer getIda() {
		return ida;
	}

	public void setIda(int ida) {
		this.ida = ida;
	}

	public Tipo_Recurso getTipo_recurso() {
		return tipo_recurso;
	}

	public void setTipo_recurso(Tipo_Recurso tiporecurso) {
		this.tipo_recurso = tiporecurso;
	}

	public Tiempo getTiempo() {
		return tiempo;
	}

	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public String toString() {
		return "Accesos [ida=" + ida + ", tipo_recurso=" + tipo_recurso + ", tiempo=" + tiempo + "]";
	}

}
