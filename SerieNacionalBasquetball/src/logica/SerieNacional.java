package logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class SerieNacional implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Equipo> Equipos;
	private int CantidadEquipos;
	private ArrayList<Juego> Juegos;
	private int CantidadJuegos;
//	private ArrayList<Jugador> jugadores;
//	private int CantidadJugadores;
	private static SerieNacional miSerie = null;
	private ArrayList<Temporada> temporadas;
	private int canttemporadas;
	
	public SerieNacional( int cantidadEquipos,
			int cantidadJuegos) {
		super();
		Equipos = new ArrayList<Equipo>();
		CantidadEquipos = cantidadEquipos;
		Juegos = new ArrayList<Juego>();
		CantidadJuegos = cantidadJuegos;
//		jugadores= new ArrayList<Jugador>();
//		this.CantidadJugadores=CantidadJugadores;
		canttemporadas=0;
		
	}
	
	public static SerieNacional getInstancia() {
		if(miSerie == null) {
			miSerie = new SerieNacional(0,0);
		}
		return miSerie;
	}
	
	public static void setSerieNacional(SerieNacional miSerie) {
		SerieNacional.miSerie = miSerie;
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
	
	public ArrayList<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(ArrayList<Temporada> temporadas) {
		this.temporadas = temporadas;
	}

	public int getCanttemporadas() {
		return canttemporadas;
	}

	public void setCanttemporadas(int canttemporadas) {
		this.canttemporadas = canttemporadas;
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
		for(int i =0;i<CantidadEquipos;i++) {
			aux=Equipos.get(i).getCantjugador()+aux;
		}
		
		return aux;
	}
	public Equipo equipodeljugador(String code) {
		Equipo aux = null;
		for(int i =0; i <CantidadEquipos && aux==null;i++) {
			if(Equipos.get(i).existejugador(code)) {
				aux=Equipos.get(i);
			}
		}
		return aux;
	}
	
	public Juego buscarTemporadaByYear(int year) {
		Juego aux=null;
		
		for(int i =0;i<canttemporadas;i++) {
			if(temporadas.get(i).getYear()==(year)) {
				aux=Juegos.get(i);
			}
		}
		
		return aux;
	}
	
	public int indiceDeTemporada(int year) {
		int aux=0;
		
		for(int i =0;i<canttemporadas;i++) {
			if(temporadas.get(i).getYear()==(year)) {
				aux=i;
			}
		}
		return aux;
	}

	public void Guardar(SerieNacional admi) {
		File f = new File("DataSerieNacional.dat");
		
		try {
			FileOutputStream datos = new FileOutputStream(f);
			ObjectOutputStream obj = new ObjectOutputStream(datos);
			obj.writeObject(admi);
			obj.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public SerieNacional Cargar() {
		
		SerieNacional admi = null;
		
		try {
			FileInputStream f = new FileInputStream("DataSerieNacional.dat");
			ObjectInputStream obj = new ObjectInputStream(f);
			admi = (SerieNacional) obj.readObject();
			obj.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return admi;
	}
	
}