package logica;

public class Jugador {
	private String codigo;
	private String nombre;
	private String desempeņo;
	private int numeroCamiseta;
	private Lesion Lesiones;
	private Equipo MiEquipo;
	private int PtsTotalCarrera;
	
	public Jugador(String codigo, String nombre, String desempeņo, int numeroCamiseta, Lesion lesiones, Equipo miEquipo, int ptsTotalCarrera) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.desempeņo = desempeņo;
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
	public String getDesempeņo() {
		return desempeņo;
	}
	public void setDesempeņo(String desempeņo) {
		this.desempeņo = desempeņo;
	}
	public int getNumeroCamiseta() {
		return numeroCamiseta;
	}
	public void setNumeroCamiseta(int numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}
}
