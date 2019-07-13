package logica;

import java.util.ArrayList;
import java.util.Date;

public class Juego {
	private Date FechaDelJuego;
	private Date TiempoTranscurrido;
	private ArrayList<Equipo> Equipos;
	private int Periodo;
	private ArrayList<String> TipoJugada;
	private int PtsEquipo1;
	private int PtsEquipo2;
	
	public Juego(Date fechaDelJuego, Date tiempoTranscurrido, int periodo,
			 int ptsEquipo1, int ptsEquipo2) {
		super();
		FechaDelJuego = fechaDelJuego;
		TiempoTranscurrido = tiempoTranscurrido;
		Equipos = new ArrayList<Equipo>();
		Periodo = periodo;
		TipoJugada = new ArrayList<String>();
		PtsEquipo1 = ptsEquipo1;
		PtsEquipo2 = ptsEquipo2;
	}
	
	public Date getFechaDelJuego() {
		return FechaDelJuego;
	}
	public void setFechaDelJuego(Date fechaDelJuego) {
		FechaDelJuego = fechaDelJuego;
	}
	public Date getTiempoTranscurrido() {
		return TiempoTranscurrido;
	}
	public void setTiempoTranscurrido(Date tiempoTranscurrido) {
		TiempoTranscurrido = tiempoTranscurrido;
	}
	public ArrayList<Equipo> getEquipos() {
		return Equipos;
	}
	public void setEquipos(ArrayList<Equipo> equipos) {
		Equipos = equipos;
	}
	public int getPeriodo() {
		return Periodo;
	}
	public void setPeriodo(int periodo) {
		Periodo = periodo;
	}
	public ArrayList<String> getTipoJugada() {
		return TipoJugada;
	}
	public void setTipoJugada(ArrayList<String> tipoJugada) {
		TipoJugada = tipoJugada;
	}
	public int getPtsEquipo1() {
		return PtsEquipo1;
	}
	public void setPtsEquipo1(int ptsEquipo1) {
		PtsEquipo1 = ptsEquipo1;
	}
	public int getPtsEquipo2() {
		return PtsEquipo2;
	}
	public void setPtsEquipo2(int ptsEquipo2) {
		PtsEquipo2 = ptsEquipo2;
	}
	
	
	
}
