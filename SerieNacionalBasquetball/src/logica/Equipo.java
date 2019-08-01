package logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Equipo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<Jugador> jugadores;
	private int juegosganados;
	private int juegosperdidos;
	private ImageIcon logo;
	private File ficherologo;

	public Equipo( String nombre, int juegosganados,
			int juegosperdidos) {
		super();

		this.nombre = nombre;
		jugadores= new ArrayList<Jugador>();
		this.juegosganados = juegosganados;
		this.juegosperdidos = juegosperdidos;
	}
	
	public Equipo(String nombre, File ficherologo) {
		super();
		this.nombre = nombre;
		jugadores= new ArrayList<Jugador>();
		this.ficherologo = ficherologo;
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
	
	public ImageIcon getLogo() {
		return logo;
	}

	public void setLogo(ImageIcon logo) {
		this.logo = logo;
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

	public File getFicherologo() {
		return ficherologo;
	}

	public void setFicherologo(File ficherologo) {
		this.ficherologo = ficherologo;
	}
	
	public int indiceDeJugador(String codigo) {
		int aux=0;
		
		for(int i =0;i<jugadores.size();i++) {
			if(jugadores.get(i).getCodigo().equals(codigo)) {
				aux=i;
			}
		}
		
		return aux;
	}
	public Jugador buscarjugadorByCode(String codigo) {
		Jugador aux=null;
		
		for(int i =0;i<jugadores.size();i++) {
			if(jugadores.get(i).getCodigo().equals(codigo)) {
				aux=jugadores.get(i);
			}
		}
		
		return aux;
	}
	
	public boolean existejugador(String codigo) {
		boolean aux=false;
		
		for(int i =0;i<jugadores.size()&& aux==false;i++) {
			if(jugadores.get(i).getCodigo().equals(codigo)) {
				aux=true;
			}
		}
		
		return aux;
	}
	
	public void guardarLogo() throws IOException, ClassNotFoundException {
		File archivoSalida = new File("src/logoEquipos/" + nombre + ".jpg");
		FileInputStream lector = new FileInputStream(ficherologo);
		FileOutputStream escritor = new FileOutputStream(archivoSalida);
		int unByte;
		// Informa que se está copiando el archivo
		System.out.println("\n\tEl archivo está siendo copiado....");
		// Lee el archivoEntrada y guarda la informacion en el archivoSalida
		try {
			while ((unByte = lector.read()) != -1)
				escritor.write(unByte);

			lector.close();
			escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\tEl archivo ha sido copiado con éxito....\n");
		logo = new ImageIcon(archivoSalida.toString());
	} 


}
