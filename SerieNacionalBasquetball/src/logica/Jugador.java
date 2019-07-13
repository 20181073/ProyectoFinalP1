package logica;

public class Jugador {
	private String codigo;
	private String nombre;
	private String desempe�o;
	private int numeroCamiseta;
	private Lesion Lesiones;
	private Equipo MiEquipo;
	private int PtsTotalCarrera;
	
	public Jugador(String codigo, String nombre, String desempe�o, int numeroCamiseta, Lesion lesiones, Equipo miEquipo, int ptsTotalCarrera) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.desempe�o = desempe�o;
		this.numeroCamiseta = numeroCamiseta;
		Lesiones = lesiones;
		MiEquipo = miEquipo;
		PtsTotalCarrera = ptsTotalCarrera;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Lesion getLesiones() {
		return Lesiones;
	}
	public void setLesiones(Lesion lesiones) {
		Lesiones = lesiones;
	}
	public Equipo getMiEquipo() {
		return MiEquipo;
	}
	public void setMiEquipo(Equipo miEquipo) {
		MiEquipo = miEquipo;
	}
	public int getPtsTotalCarrera() {
		return PtsTotalCarrera;
	}
	public void setPtsTotalCarrera(int ptsTotalCarrera) {
		PtsTotalCarrera = ptsTotalCarrera;
	}
	public String getDesempe�o() {
		return desempe�o;
	}
	public void setDesempe�o(String desempe�o) {
		this.desempe�o = desempe�o;
	}
	public int getNumeroCamiseta() {
		return numeroCamiseta;
	}
	public void setNumeroCamiseta(int numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}
}
