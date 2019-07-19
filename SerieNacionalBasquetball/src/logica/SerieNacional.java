package logica;

import java.util.ArrayList;

public class SerieNacional {

	private ArrayList<Equipo> Equipos;
	private int CantidadEquipos;
	private ArrayList<Juego> Juegos;
	private int CantidadJuegos;
	private ArrayList<Jugador> jugadores;
	private int CantidadJugadores;
	
	public SerieNacional( int cantidadEquipos,
			int cantidadJuegos,int CantidadJugadores) {
		super();
		Equipos = new ArrayList<Equipo>();
		CantidadEquipos = cantidadEquipos;
		Juegos = new ArrayList<Juego>();
		CantidadJuegos = cantidadJuegos;
		jugadores= new ArrayList<Jugador>();
		this.CantidadJugadores=CantidadJugadores;
		
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

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public int getCantidadJugadores() {
		return CantidadJugadores;
	}

	public void setCantidadJugadores(int cantidadJugadores) {
		CantidadJugadores = cantidadJugadores;
	}
	
	public Jugador buscarjugadorByCode(String codigo) {
		Jugador aux=null;
		
		for(int i =0;i<CantidadJugadores;i++) {
			if(jugadores.get(i).getCodigo().equals(codigo)) {
				aux=jugadores.get(i);
			}
		}
		
		return aux;
	}
	
	public Equipo buscarequipoByCode(String codigo) {
		Equipo aux=null;
		
		for(int i =0;i<CantidadEquipos;i++) {
			if(Equipos.get(i).getCodigo().equals(codigo)) {
				aux=Equipos.get(i);
			}
		}
		
		return aux;
	}
	
	public int indiceDeJugador(String codigo) {
		int aux=0;
		
		for(int i =0;i<CantidadJugadores;i++) {
			if(jugadores.get(i).getCodigo().equals(codigo)) {
				aux=i;
			}
		}
		
		return aux;
	}
	
	public int indiceDeEquipo(String codigo) {
		int aux=0;
		
		for(int i =0;i<CantidadEquipos;i++) {
			if(Equipos.get(i).getCodigo().equals(codigo)) {
				aux=i;
			}
		}
		
		return aux;
	}
	
	public Juego buscarJuegoByCode(int codigo) {
		Juego aux=null;
		
		for(int i =0;i<CantidadJuegos;i++) {
			if(Juegos.get(i).getCodigo()==(codigo)) {
				aux=Juegos.get(i);
			}
		}
		
		return aux;
	}
	
	public int indiceDeJuego(int codigo) {
		int aux=0;
		
		for(int i =0;i<CantidadJuegos;i++) {
			if(Juegos.get(i).getCodigo()==(codigo)) {
				aux=i;
			}
		}
		
		return aux;
	}
	
	public int cantidadDeJugadoresTotales() {
		int aux=0;
		aux=CantidadJugadores;
		for(int i =0;i<CantidadEquipos;i++) {
			aux=Equipos.get(i).getCantjugador()+aux;
		}
		
		return aux;
	}
	
}