package logica;

import java.util.Date;

public class Lesion {

	private String codigo;
	private String tipo;
	private boolean estado;
	private Date FechaLesion;
	private int RecoveryTime;
	public Lesion(String codigo, String tipo, boolean estado, Date fechaLesion, int recoveryTime) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.estado = estado;
		FechaLesion = fechaLesion;
		RecoveryTime = recoveryTime;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Date getFechaLesion() {
		return FechaLesion;
	}
	public void setFechaLesion(Date fechaLesion) {
		FechaLesion = fechaLesion;
	}
	public int getRecoveryTime() {
		return RecoveryTime;
	}
	public void setRecoveryTime(int recoveryTime) {//En Dias
		RecoveryTime = recoveryTime;
	}
	
	public void recuperacion () {
		long aux = FechaLesion.getTime();
		Date date =new Date();
		long tiempoactual=date.getTime();
		
		if (tiempoactual-aux>=RecoveryTime*60*60*24) {
			setEstado(false);
		}
	}
	
	
	
}
