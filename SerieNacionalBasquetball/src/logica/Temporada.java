package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Temporada implements Serializable {

	private static final long serialVersionUID = 1L;
	private String codigo;
	private ArrayList<Equipo> equipos;// max 27
	private int CantidadEquipos;
	private ArrayList<Juego> juegos;
	private int cantjuegos;
	private int year;

	public Temporada( ArrayList<Equipo> equipos, int CantidadEquipos, int year) {
		super();
		this.equipos =new ArrayList<Equipo>();
		this.equipos = equipos;
		this.CantidadEquipos = CantidadEquipos;
		int aux=0;
		for (int i = 0; i < (CantidadEquipos - 1) * 2; i++) {
			for (int a = i + 1; a < (CantidadEquipos - 1) * 2; a++) {
				 aux++;
			}
		}
		cantjuegos = aux*2;
		this.year = year;
		juegos=new ArrayList<Juego>() ;
	}

	public String getCodigo() {
		return codigo; 
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}

	public int getCantidadEquipos() {
		return CantidadEquipos;
	}

	public void setCantidadEquipos(int cantidadEquipos) {
		CantidadEquipos = cantidadEquipos;
	}

	public ArrayList<Juego> getJuegos() {
		return juegos;
	}

	public void setJuegos(ArrayList<Juego> juegos) {
		this.juegos = juegos;
	}

	public int getCantjuegos() {
		return cantjuegos;
	}

	public void setCantjuegos(int cantjuegos) {
		this.cantjuegos = cantjuegos;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void RegistrarJuegos(int yearj) {

		int codigo = 0;
		for (int i = 0; i < equipos.size(); i++) {
			Date date = new Date();
			date.setMonth(0); 
			date.setYear(yearj);
			for (int a = i + 1; a < equipos.size(); a++, codigo++) {
				if(a-i-1!=0) {
//					date.setTime((date.getTime()) + (((7 * (a - i - 1)) * 24) * 60 * 60 * 1000));
//				}else {
					date.setTime((date.getTime()) + (7 * a * 24 * 60 * 60 * 1000));
				}
				juegos.add(new Juego(date, 0, 0, "No Juagado", codigo));
				juegos.get(codigo).getEquipos().add(equipos.get(i));
				juegos.get(codigo).getEquipos().add(equipos.get(a));
			}
		}
		for (int i = 0; i < equipos.size(); i++) {
			Date date = new Date();
			date.setMonth(0); 
			date.setYear(yearj);
			date.setTime((date.getTime())+ (7  * 24 * 60 * 60 * 1000*2*(equipos.size())-1));
			for (int a = i + 1; a < equipos.size(); a++, codigo++) {
				if(a-i-1!=0) {
//					date.setTime((date.getTime()) + (((7 * (a - i - 1)) * 24) * 60 * 60 * 1000));
//				}else {
					date.setTime((date.getTime())  + (7 * a * 24 * 60 * 60 * 1000) );
				}
				juegos.add(new Juego(date, 0, 0, "No Juagado", codigo));
				juegos.get(codigo).getEquipos().add(equipos.get(i));
				juegos.get(codigo).getEquipos().add(equipos.get(a));
			}
		}

	}
	
	public Juego buscarJuegoByCode(int codigo) {
		Juego aux=null;
		
		for(int i =0;i<cantjuegos;i++) {
			if(juegos.get(i).getCodigo()==(codigo)) {
				aux=juegos.get(i);
			}
		}
		
		return aux;
	}
	
	public int indiceDeJuego(int codigo) {
		int aux=-1;
		
		for(int i =0;i<cantjuegos;i++) {
			if(juegos.get(i).getCodigo()==(codigo)) {
				aux=i;
			}
		}
		
		return aux;
	}
	
	public ArrayList<Equipo> GanadordelaTemporada(){
		ArrayList<Equipo> aux = new ArrayList<Equipo>();
		int [] helper = new int[CantidadEquipos];
		int valormax=0;
		
		for(int i =0; i<cantjuegos;i++) {
			if(juegos.get(i).getPtsEquipo1()>juegos.get(i).getPtsEquipo2()){
				helper[indiceDeEquipo(juegos.get(i).getEquipos().get(0).getNombre())]+=2;
			}
			if(juegos.get(i).getPtsEquipo1()<juegos.get(i).getPtsEquipo2()){
				helper[indiceDeEquipo(juegos.get(i).getEquipos().get(1).getNombre())]+=1;
			}
		}
		for(int i=0;i<CantidadEquipos;i++) {
			if(helper[i]==valormax ) {
				aux.add(equipos.get(i));
			}
			if(helper[i]>valormax ) {
				valormax =helper[i];
				aux.clear();
				aux.add(equipos.get(i));
			}
			
		}
		
		int[] desision= new int[aux.size()];
		for(int i =0; i < aux.size();i++) {
			desision[i]=0;
		}
		
		if(aux.size()>1) {
			for(int i=0;i<aux.size();i++) {
				for(int a=i+1;a<aux.size();i++) {
					if(coeficientedepuntos(aux.get(i),aux.get(a))>0) {
						desision[i]++;
					}
					if(coeficientedepuntos(aux.get(i),aux.get(a))<0) {
						desision[a]++;
					}
				}
			}
		}
		ArrayList<Equipo> clon =aux;
		int valorverif=0;
		for(int i=0;i<aux.size();i++) {
			if(desision[i]==valorverif) {
				clon.add(aux.get(i));
			}
			if(desision[i]>valorverif) {
				valorverif=desision[i];
				clon.clear();
				clon.add(aux.get(i));
			}
			
		}
		
		return clon;
	}
	
	
	public int coeficientedepuntos(Equipo eq1,Equipo eq2) {
		int aux=0;
		for(int i=0;i<cantjuegos;i++){
			if(  (juegos.get(i).getEquipos().get(0)== eq1 || juegos.get(i).getEquipos().get(0)== eq2) && (juegos.get(i).getEquipos().get(1)== eq1 || juegos.get(i).getEquipos().get(1)== eq2)) {
				aux+=juegos.get(i).getPtsEquipo1()-juegos.get(i).getPtsEquipo2();
			}
		}
		return aux;
	}
	
	public int indiceDeEquipo(String Nombre) {
		int aux=-1;
		
		try {
			for(int i =0;i<equipos.size();i++) {
				if(equipos.get(i).getNombre().equals(Nombre)) {
					aux=i;
				}
			}
		}catch(NullPointerException e) {
					
		}
		
		return aux;
	}	
}