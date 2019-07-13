package logica;

import java.io.File;
import java.util.ArrayList;

public class Equipo {

	private String codigo;
	private String nombre;
	private ArrayList<Jugador> jugadores;
	private int cantjugador;
	private int juegosganados;
	private int juegosperdidos;
	private File logo;

	public Equipo(String codigo, String nombre, int cantjugador, int juegosganados,
			int juegosperdidos, File logo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		jugadores= new ArrayList<Jugador>();
		this.cantjugador = cantjugador;
		this.juegosganados = juegosganados;
		this.juegosperdidos = juegosperdidos;
		this.logo = logo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public int getCantjugador() {
		return cantjugador;
	}

	public void setCantjugador(int cantjugador) {
		this.cantjugador = cantjugador;
	}

	public int getJuegosganados() {
		return juegosganados;
	}

	public void setJuegosganados(int juegosganados) {
		this.juegosganados = juegosganados;
	}

	public int getJuegosperdidos() {
		return juegosperdidos;
	}

	public void setJuegosperdidos(int juegosperdidos) {
		this.juegosperdidos = juegosperdidos;
	}

	public File getLogo() {
		return logo;
	}

	public void setLogo(File logo) {
		this.logo = logo;
	}


}
