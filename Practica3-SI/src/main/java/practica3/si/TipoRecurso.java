package practica3.si;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoRecurso {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;

	private int idr;
	private String tipo;
	
	
	public TipoRecurso(int idr, String tipo) {
		this.idr = idr;
		this.tipo = tipo;
	}


	public TipoRecurso() {
	}


	public int getIdr() {
		return idr;
	}


	public void setIdr(int idr) {
		this.idr = idr;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "Recurso [idr=" + idr + ", tipo=" + tipo + "]";
	}
	
}
