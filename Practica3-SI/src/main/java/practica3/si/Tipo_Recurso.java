package practica3.si;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipo_Recurso {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer idr;
	
	@Column(length = 20)
	private String tipo;
	
	
	public Tipo_Recurso(String tipo) {
		this.tipo = tipo;
	}


	public Tipo_Recurso() {
	}


	public Integer getIdr() {
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
