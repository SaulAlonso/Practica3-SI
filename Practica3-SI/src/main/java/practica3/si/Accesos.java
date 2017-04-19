package practica3.si;

import javax.persistence.*;

@Entity
public class Accesos {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	private int ida;
	
	@OneToOne (cascade=CascadeType.ALL)
	private Tipo_Recurso tipo_recurso;
	
	@OneToOne (cascade=CascadeType.ALL)
	private Tiempo tiempo;

	public Accesos(int ida, Tipo_Recurso tipo_recurso, Tiempo tiempo) {
		this.ida = ida;
		this.tipo_recurso = tipo_recurso;
		this.tiempo = tiempo;
	}

	public Accesos() {
	}

	public int getIda() {
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
