package practica3.si;

import javax.persistence.*;

@Entity
public class Accesos {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	private int ida;
	
	@OneToOne (cascade=CascadeType.ALL)
	private TipoRecurso tipo_recurso;
	
	@OneToOne (cascade=CascadeType.ALL)
	private Tiempo tiempo;

	public Accesos(int ida, TipoRecurso tipo_recurso, Tiempo tiempo) {
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

	public TipoRecurso getTipo_recurso() {
		return tipo_recurso;
	}

	public void setTipo_recurso(TipoRecurso tipo_recurso) {
		this.tipo_recurso = tipo_recurso;
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
