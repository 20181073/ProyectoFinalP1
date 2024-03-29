package visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.SerieNacional;
import rsbuttom.RSButtonMetro;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
					//log.setModal(true);
					log.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	public Principal(String tipodeuser) {
		SerieNacional LaSerie = SerieNacional.getInstancia().Cargar();
		
		SerieNacional.setSerieNacional(LaSerie);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagenes/IconoPrincipal.png")));
		setTitle("Serie Nacional de Basquetball");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_superior = new JPanel();
		panel_superior.setBackground(new Color(255, 165, 0));
		panel_superior.setBounds(5, 5, 1323, 50);
		contentPane.add(panel_superior);
		
		JPanel panelRegistrar = new JPanel();
		panelRegistrar.setBackground(SystemColor.controlHighlight);
		panelRegistrar.setBounds(5, 62, 220, 593);
		contentPane.add(panelRegistrar);
		panelRegistrar.setLayout(null);
		
		JPanel panelGestion = new JPanel();
		panelGestion.setBackground(SystemColor.controlHighlight);
		panelGestion.setBounds(5, 62, 220, 593);
		contentPane.add(panelGestion);
		panelGestion.setLayout(null);
		
		RSButtonMetro btnRegistrar = new RSButtonMetro();
		btnRegistrar.setColorTextNormal(Color.BLACK);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelGestion.setVisible(false);
				panelRegistrar.setVisible(true);
				
				Animacion.Animacion.mover_izquierda(0, -188, 2, 2, panelRegistrar);
				try {
					Thread.sleep(150);
				}
				catch(InterruptedException e1){
					System.out.println("Thread Interrupted");
				}
				Animacion.Animacion.mover_derecha(-188, 0, 2, 2, panelRegistrar);
			}
		});
		btnRegistrar.setBounds(10, 0, 100, 50);
		btnRegistrar.setColorNormal(new Color(255, 165, 0));
		btnRegistrar.setColorPressed(new Color(204, 102, 0));
		btnRegistrar.setColorHover(new Color(204, 102, 0));
		btnRegistrar.setForeground(new Color(0, 0, 0));
		btnRegistrar.setText("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegistrar.setBackground(new Color(255, 165, 0));
		
		//Mola
		RSButtonMetro btnGestionar = new RSButtonMetro();
		btnGestionar.setColorTextNormal(Color.BLACK);
		btnGestionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRegistrar.setVisible(false);
				panelGestion.setVisible(true);
				
				Animacion.Animacion.mover_izquierda(0, -188, 2, 2, panelGestion);
				try {
					Thread.sleep(150);
				}
				catch(InterruptedException e1){
					System.out.println("Thread Interrupted");
				}
				Animacion.Animacion.mover_derecha(-188, 0, 2, 2, panelGestion);
			}
		});
		btnGestionar.setBounds(116, 0, 100, 50);
		btnGestionar.setColorNormal(new Color(255, 165, 0));
		btnGestionar.setColorPressed(new Color(204, 102, 0));
		btnGestionar.setColorHover(new Color(204, 102, 0));
		btnGestionar.setForeground(new Color(0, 0, 0));
		btnGestionar.setBackground(new Color(255, 165, 0));
		btnGestionar.setText("Gestionar");
		btnGestionar.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_superior.setLayout(null);
		panel_superior.add(btnRegistrar);
		panel_superior.add(btnGestionar);
		
		RSButtonMetro btnmtrCalendario = new RSButtonMetro();
		btnmtrCalendario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalendarioRegular a = new CalendarioRegular(SerieNacional.getInstancia());
				//a.setModal(true);
				a.setVisible(true);
			}
		});
		btnmtrCalendario.setText("Calendario");
		btnmtrCalendario.setForeground(Color.BLACK);
		btnmtrCalendario.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnmtrCalendario.setColorTextNormal(Color.BLACK);
		btnmtrCalendario.setColorPressed(new Color(204, 102, 0));
		btnmtrCalendario.setColorNormal(new Color(255, 165, 0));
		btnmtrCalendario.setColorHover(new Color(204, 102, 0));
		btnmtrCalendario.setBackground(new Color(255, 165, 0));
		btnmtrCalendario.setBounds(240, 0, 100, 50);
		panel_superior.add(btnmtrCalendario);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				if( tipodeuser.equalsIgnoreCase("Anotador")  ) {
					
					panelRegistrar.setVisible(false);
					btnRegistrar.setVisible(false);
					btnmtrCalendario.setVisible(false);
					btnGestionar.setVisible(false);
				}
				//System.out.println(tipodeuser);
				
			}
		});
		
		RSButtonMetro btnmtrCerrarSesin = new RSButtonMetro();
		btnmtrCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnmtrCerrarSesin.setText("Cerrar Sesi\u00F3n");
		btnmtrCerrarSesin.setForeground(Color.BLACK);
		btnmtrCerrarSesin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnmtrCerrarSesin.setColorTextNormal(Color.BLACK);
		btnmtrCerrarSesin.setColorPressed(new Color(204, 102, 0));
		btnmtrCerrarSesin.setColorNormal(new Color(255, 165, 0));
		btnmtrCerrarSesin.setColorHover(new Color(204, 102, 0));
		btnmtrCerrarSesin.setBackground(new Color(255, 165, 0));
		btnmtrCerrarSesin.setBounds(350, 0, 160, 50);
		panel_superior.add(btnmtrCerrarSesin);
		
		JLabel lblRegistrar = new JLabel("Registrar");
		lblRegistrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrar.setBounds(10, 24, 200, 28);
		panelRegistrar.add(lblRegistrar);
		
		RSButtonMetro btnmtrJugador = new RSButtonMetro();
		btnmtrJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A�adirJugador a = new A�adirJugador();
				a.setModal(true);
				a.setVisible(true);
			}
		});
		btnmtrJugador.setColorPressed(Color.GRAY);
		btnmtrJugador.setColorTextNormal(Color.BLACK);
		btnmtrJugador.setColorNormal(SystemColor.controlHighlight);
		btnmtrJugador.setColorHover(SystemColor.controlShadow);
		btnmtrJugador.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/if_user-add_216490.png")));
		btnmtrJugador.setText("Jugador");
		btnmtrJugador.setForeground(Color.BLACK);
		btnmtrJugador.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnmtrJugador.setBackground(SystemColor.controlHighlight);
		btnmtrJugador.setBounds(0, 180, 220, 35);
		panelRegistrar.add(btnmtrJugador);
		
		RSButtonMetro btnmtrEquipo = new RSButtonMetro();
		btnmtrEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEquipos regE = new RegEquipos();
				regE.setModal(true);
				regE.setVisible(true);
			}
		});
		btnmtrEquipo.setColorPressed(Color.GRAY);
		btnmtrEquipo.setColorTextNormal(Color.BLACK);
		btnmtrEquipo.setColorNormal(SystemColor.controlHighlight);
		btnmtrEquipo.setColorHover(SystemColor.controlShadow);
		btnmtrEquipo.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/if_88_171447.png")));
		btnmtrEquipo.setText("Equipo");
		btnmtrEquipo.setForeground(Color.BLACK);
		btnmtrEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnmtrEquipo.setBackground(SystemColor.controlHighlight);
		btnmtrEquipo.setBounds(0, 105, 220, 35);
		panelRegistrar.add(btnmtrEquipo);
		
		RSButtonMetro btnmtrJuego = new RSButtonMetro();
		btnmtrJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarJuego simu = new RegistrarJuego(SerieNacional.getInstancia());
				//simu.setModal(true);
				simu.setVisible(true);
			}
		});
		btnmtrJuego.setColorPressed(Color.GRAY);
		btnmtrJuego.setColorTextNormal(Color.BLACK);
		btnmtrJuego.setColorNormal(SystemColor.controlHighlight);
		btnmtrJuego.setColorHover(SystemColor.controlShadow);
		btnmtrJuego.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/67083.png")));
		btnmtrJuego.setText("Juego");
		btnmtrJuego.setForeground(Color.BLACK);
		btnmtrJuego.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnmtrJuego.setBackground(SystemColor.controlHighlight);
		btnmtrJuego.setBounds(0, 260, 220, 35);
		panelRegistrar.add(btnmtrJuego);
		
		JLabel lblGestionar = new JLabel("Gestionar");
		lblGestionar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGestionar.setBounds(10, 24, 200, 28);
		panelGestion.add(lblGestionar);
		
		RSButtonMetro btnmtrJugadores = new RSButtonMetro();
		btnmtrJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(LaSerie.cantidadDeJugadoresTotales()> 0) {
					ListaDeJugadores listj = new ListaDeJugadores(tipodeuser);
					//listj.setModal(true);
					listj.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "A�n no hay jugadores creados.");
				}
			}
		});
		btnmtrJugadores.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/if_88_171447.png")));
		btnmtrJugadores.setText("Jugadores");
		btnmtrJugadores.setForeground(Color.BLACK);
		btnmtrJugadores.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnmtrJugadores.setColorTextNormal(Color.BLACK);
		btnmtrJugadores.setColorPressed(Color.GRAY);
		btnmtrJugadores.setColorNormal(SystemColor.controlHighlight);
		btnmtrJugadores.setColorHover(SystemColor.controlShadow);
		btnmtrJugadores.setBackground(SystemColor.controlHighlight);
		btnmtrJugadores.setBounds(0, 180, 220, 35);
		panelGestion.add(btnmtrJugadores);
		
		RSButtonMetro btnmtrEquipos = new RSButtonMetro();
		btnmtrEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SerieNacional.getInstancia().getEquipos().size() != 0) {
					ListaDeEquipos listE = new ListaDeEquipos(tipodeuser);
					listE.setModal(true);
					listE.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "A�n no hay equipos creados.");
				}
			}
		});
		btnmtrEquipos.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Equipo.png")));
		btnmtrEquipos.setText("Equipos");
		btnmtrEquipos.setForeground(Color.BLACK);
		btnmtrEquipos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnmtrEquipos.setColorTextNormal(Color.BLACK);
		btnmtrEquipos.setColorPressed(Color.GRAY);
		btnmtrEquipos.setColorNormal(SystemColor.controlHighlight);
		btnmtrEquipos.setColorHover(SystemColor.controlShadow);
		btnmtrEquipos.setBackground(SystemColor.controlHighlight);
		btnmtrEquipos.setBounds(0, 105, 220, 35);
		panelGestion.add(btnmtrEquipos);
		
		RSButtonMetro btnmtrJuegos = new RSButtonMetro();
		btnmtrJuegos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaDeJuegos listjuegos = new ListaDeJuegos(SerieNacional.getInstancia());
				//listjuegos.setModal(true);
				listjuegos.setVisible(true);
			}
		});
		btnmtrJuegos.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/67083.png")));
		btnmtrJuegos.setText("Juegos");
		btnmtrJuegos.setForeground(Color.BLACK);
		btnmtrJuegos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnmtrJuegos.setColorTextNormal(Color.BLACK);
		btnmtrJuegos.setColorPressed(Color.GRAY);
		btnmtrJuegos.setColorNormal(SystemColor.controlHighlight);
		btnmtrJuegos.setColorHover(SystemColor.controlShadow);
		btnmtrJuegos.setBackground(SystemColor.controlHighlight);
		btnmtrJuegos.setBounds(0, 260, 220, 35);
		panelGestion.add(btnmtrJuegos);
		
		JPanel panelDeInformacion1 = new JPanel();
		panelDeInformacion1.setBackground(SystemColor.controlHighlight);
		panelDeInformacion1.setBounds(233, 62, 535, 284);
		contentPane.add(panelDeInformacion1);
		panelDeInformacion1.setLayout(null);
		
		JLabel lblTopJugadoresDestacados = new JLabel("Top jugadores destacados");
		lblTopJugadoresDestacados.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopJugadoresDestacados.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTopJugadoresDestacados.setBounds(160, 11, 220, 28);
		panelDeInformacion1.add(lblTopJugadoresDestacados);
		
		JPanel panelDeInformacion2 = new JPanel();
		panelDeInformacion2.setBackground(SystemColor.controlHighlight);
		panelDeInformacion2.setBounds(233, 355, 535, 300);
		contentPane.add(panelDeInformacion2);
		panelDeInformacion2.setLayout(null);
		
		JLabel lblRankingEquipos = new JLabel("Ranking equipos");
		lblRankingEquipos.setHorizontalAlignment(SwingConstants.CENTER);
		lblRankingEquipos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRankingEquipos.setBounds(160, 11, 200, 28);
		panelDeInformacion2.add(lblRankingEquipos);
		
		JPanel panelDeInformacion3 = new JPanel();
		panelDeInformacion3.setBackground(SystemColor.controlHighlight);
		panelDeInformacion3.setBounds(778, 62, 550, 284);
		contentPane.add(panelDeInformacion3);
		panelDeInformacion3.setLayout(null);
		
		JLabel lblltimosJuegosRealizados = new JLabel("\u00DAltimos juegos realizados");
		lblltimosJuegosRealizados.setHorizontalAlignment(SwingConstants.CENTER);
		lblltimosJuegosRealizados.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblltimosJuegosRealizados.setBounds(170, 11, 215, 28);
		panelDeInformacion3.add(lblltimosJuegosRealizados);
		
		JPanel panelDeInformacion4 = new JPanel();
		panelDeInformacion4.setBackground(SystemColor.controlHighlight);
		panelDeInformacion4.setBounds(778, 355, 550, 300);
		contentPane.add(panelDeInformacion4);
		panelDeInformacion4.setLayout(null);
		
		JLabel lblFechasDePrximos = new JLabel("Fechas de pr\u00F3ximos juegos");
		lblFechasDePrximos.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechasDePrximos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFechasDePrximos.setBounds(160, 11, 246, 28);
		panelDeInformacion4.add(lblFechasDePrximos);
		
	}
}
