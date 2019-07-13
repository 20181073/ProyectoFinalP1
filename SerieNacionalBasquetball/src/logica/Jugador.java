package logica;

public class Jugador {

	private String nombre;
	private String codigo;
	private Lesion Lesiones;
	private Equipo MiEquipo;
	private int PtsTotalCarrera;

	public Jugador(String nombre, String codigo, Lesion lesiones, Equipo miEquipo, int ptsTotalCarrera) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
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

}
