package practica3.si;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipo_Recurso {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;

	private int idr;
	private String tipo;
	
	
	public Tipo_Recurso(int idr, String tipo) {
		this.idr = idr;
		this.tipo = tipo;
	}


	public Tipo_Recurso() {
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
