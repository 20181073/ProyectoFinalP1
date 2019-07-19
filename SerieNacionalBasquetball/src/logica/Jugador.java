package logica;

import java.util.ArrayList;

public class Jugador {
	private String codigo;
	private String nombre;
	private String desempeņo;
	private int numeroCamiseta;
	private ArrayList<Lesion> Lesiones;
	private int cantlesiones;
	private Equipo MiEquipo;
	private int PtsTotalCarrera;
	private int cantasistencias;
	private int cantbloqueo;
	private int cantrobodebalon;
	private float altura;
	private int edad;
	private float peso;

	public Jugador(String codigo, String nombre, String desempeņo, int numeroCamiseta,int cantlesiones, Equipo miEquipo,
			int ptsTotalCarrera, int cantasistencias, int cantbloqueo, int cantrobodebalon,float altura,int edad, float peso) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.desempeņo = desempeņo;
		this.numeroCamiseta = numeroCamiseta;
		Lesiones = new ArrayList<Lesion>();
		this.cantlesiones=cantlesiones;
		MiEquipo = miEquipo;
		PtsTotalCarrera = ptsTotalCarrera;
		this.cantasistencias = cantasistencias;
		this.cantbloqueo = cantbloqueo;
		this.cantrobodebalon = cantrobodebalon;
		this.altura = altura;
		this.edad=edad;
		this.peso=peso;
	}

	public Jugador(String nombreJugador, float peso2, float estatura, String posicion, int numero) {
		// TODO Auto-generated constructor stub
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

	public ArrayList<Lesion> getLesiones() {
		return Lesiones;
	}

	public void setLesiones(ArrayList<Lesion> lesiones) {
		Lesiones = lesiones;
	}
	
	public int getCantlesiones() {
		return cantlesiones;
	}

	public void setCantlesiones(int cantlesiones) {
		this.cantlesiones = cantlesiones;
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

	public int getCantasistencias() {
		return cantasistencias;
	}

	public void setCantasistencias(int cantasistencias) {
		this.cantasistencias = cantasistencias;
	}

	public int getCantbloqueo() {
		return cantbloqueo;
	}

	public void setCantbloqueo(int cantbloqueo) {
		this.cantbloqueo = cantbloqueo;
	}

	public int getCantrobodebalon() {
		return cantrobodebalon;
	}

	public void setCantrobodebalon(int cantrobodebalon) {
		this.cantrobodebalon = cantrobodebalon;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	

}
