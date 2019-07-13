package logica;

import java.util.ArrayList;

public class SerieNacional {
	private String Codigo;
	private ArrayList<Equipo> Equipos;
	private int CantidadEquipos;
	private ArrayList<Juego> Juegos;
	private int CantidadJuegos;
	
	public SerieNacional(String codigo, int cantidadEquipos,
			int cantidadJuegos) {
		super();
		Codigo = codigo;
		Equipos = new ArrayList<Equipo>();
		CantidadEquipos = cantidadEquipos;
		Juegos = new ArrayList<Juego>();
		CantidadJuegos = cantidadJuegos;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public ArrayList<Equipo> getEquipos() {
		return Equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		Equipos = equipos;
	}

	public int getCantidadEquipos() {
		return CantidadEquipos;
	}

	public void setCantidadEquipos(int cantidadEquipos) {
		CantidadEquipos = cantidadEquipos;
	}

	public ArrayList<Juego> getJuegos() {
		return Juegos;
	}

	public void setJuegos(ArrayList<Juego> juegos) {
		Juegos = juegos;
	}

	public int getCantidadJuegos() {
		return CantidadJuegos;
	}

	public void setCantidadJuegos(int cantidadJuegos) {
		CantidadJuegos = cantidadJuegos;
	}
	
	
}
