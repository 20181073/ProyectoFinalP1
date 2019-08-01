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
//	private int CantidadEquipos;
	private ArrayList<Juego> Juegos;
//	private int CantidadJuegos;
//	private ArrayList<Jugador> jugadores;
//	private int CantidadJugadores;
	private static SerieNacional miSerie = null;
	private ArrayList<Temporada> temporadas;
	private int canttemporadas;
	
	public SerieNacional() {
		super();
		Equipos = new ArrayList<Equipo>();
//		CantidadEquipos = cantidadEquipos;
		Juegos = new ArrayList<Juego>();
//		jugadores= new ArrayList<Jugador>();
//		this.CantidadJugadores=CantidadJugadores;
		canttemporadas=0;
		
	}
	 
	public static SerieNacional getInstancia() {
		if(miSerie == null) {
			miSerie = new SerieNacional();
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

	public ArrayList<Juego> getJuegos() {
		return Juegos;
	}

	public void setJuegos(ArrayList<Juego> juegos) {
		Juegos = juegos;
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
	
//	public Equipo buscarequipoByCode(String codigo) {
//		Equipo aux=null;
//		
//		for(int i =0;i<Equipos.size();i++) {
//			if(Equipos.get(i).getCodigo().equals(codigo)) {
//				aux=Equipos.get(i);
//			}
//		}
//		
//		return aux;
//	}
	
	public Equipo buscarequipoByName(String nombre) {
		Equipo aux=null;
		try {
			for(int i =0;i<Equipos.size();i++) {
				if(Equipos.get(i).getNombre().equals(nombre)) {
					aux=Equipos.get(i);
				}
			}
		}catch(NullPointerException e) {
					
		}
		return aux;
	}
	
	
	public int indiceDeEquipo(String Nombre) {
		int aux=-1;
		
		try {
			for(int i =0;i<Equipos.size();i++) {
				if(Equipos.get(i).getNombre().equals(Nombre)) {
					aux=i;
				}
			}
		}catch(NullPointerException e) {
					
		}
		
		return aux;
	}
	
	public Juego buscarJuegoByCode(int codigo) {
		Juego aux=null;
		try {
			for(int i =0;i<Juegos.size();i++) {
				if(Juegos.get(i).getCodigo()==(codigo)) {
					aux=Juegos.get(i);
				}
			}
		}catch(NullPointerException e) {
			
		}
		
		return aux;
	}
	
	public int indiceDeJuego(int codigo) {
		int aux=-1;
		try {
			for(int i =0;i<Juegos.size();i++) {
				if(Juegos.get(i).getCodigo()==(codigo)) {
					aux=i;
				}
			} 
		}catch(NullPointerException e) {
			
		}
		return aux;
	}
	
	public int cantidadDeJugadoresTotales() {
		int aux=0;
		try {
			for(int i =0;i<Equipos.size();i++) { 
				aux=Equipos.get(i).getJugadores().size()+aux;
			}
		}catch(NullPointerException e) {
			
		}
		
		
		return aux;
	}
	
	public Equipo equipodeljugador(String code) {
		Equipo aux = null;
		try {
			for(int i =0; i <Equipos.size() && aux==null;i++) {
				if(Equipos.get(i).existejugador(code)) {
					aux=Equipos.get(i);
				}
			}
		}catch(NullPointerException e) {
			
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
		int aux=-1;
		
		for(int i =0;i<canttemporadas;i++) {
			if(temporadas.get(i).getYear()==(year)) {
				aux=i;
			}
		}
		return aux;
	}
	public boolean existeTemporada(int yearj) {
		boolean aux=false;
		try {	
			for(int i =0;i<temporadas.size()&& aux==false;i++) {
				if(temporadas.get(i).getYear()== yearj) {
					aux=true;
				}
			}
		}catch(NullPointerException e) {
			
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
		
		SerieNacional admi = new SerieNacional();
		
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