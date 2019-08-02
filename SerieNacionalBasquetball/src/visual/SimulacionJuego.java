package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logica.Equipo;
import logica.Juego;
import logica.Jugador;
import logica.SerieNacional;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

public class SimulacionJuego extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableJugadoresLocal;
	private JTable tableJugadoresVisita;
/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego frame = new Juego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	public SimulacionJuego(SerieNacional serie,String nombreEQlocal,String nombreEQvisita,Equipo Equipolocal,Equipo EquipoVisita,Juego simulando,String tipodejuego) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimulacionJuego.class.getResource("/imagenes/IconoPrincipal.png")));
		setResizable(false); 
		
		setTitle("Simular Juego");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 748, 622);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblLocal.setBounds(190, 14, 74, 38);
		contentPane.add(lblLocal);
		
		JLabel lblVisita = new JLabel("Visita");
		lblVisita.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblVisita.setBounds(454, 14, 74, 37);
		contentPane.add(lblVisita);
		
		JLabel lblPuntosLocal = new JLabel("0");
		lblPuntosLocal.setFont(new Font("Lao UI", Font.BOLD, 76));
		lblPuntosLocal.setBounds(185, 176, 88, 72);
		contentPane.add(lblPuntosLocal);
		
		JLabel lblPuntosVisita = new JLabel("0");
		lblPuntosVisita.setFont(new Font("Lao UI", Font.BOLD, 76));
		lblPuntosVisita.setBounds(458, 176, 88, 72);
		contentPane.add(lblPuntosVisita);
		
		JPanel panelLogoLocal = new JPanel();
		panelLogoLocal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelLogoLocal.setBounds(121, 57, 184, 105);
		contentPane.add(panelLogoLocal);
		panelLogoLocal.setLayout(null);
		
		JPanel panelLogoVisita = new JPanel();
		panelLogoVisita.setLayout(null);
		panelLogoVisita.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelLogoVisita.setBounds(426, 57, 184, 105);
		contentPane.add(panelLogoVisita);
		
		JScrollPane scrollPanelTablaLocal = new JScrollPane();
		scrollPanelTablaLocal.setBounds(10, 259, 279, 216);
		contentPane.add(scrollPanelTablaLocal);
		
		Object[][] listalocal=new Object[5][3];
		for (int i=0;i<5;i++) {
			listalocal[i][0]=Equipolocal.getJugadores().get(i).getCodigo();
			listalocal[i][1]=Equipolocal.getJugadores().get(i).getNombre();
			listalocal[i][2]=Equipolocal.getJugadores().get(i).getNumeroCamiseta();
		}
		tableJugadoresLocal = new JTable();
		tableJugadoresLocal.setModel(new DefaultTableModel(
			listalocal,
			new String[] {
				"Codigo", "Nombre", "Numero"
			}
			
		));
		tableJugadoresLocal.setFillsViewportHeight(true);
		scrollPanelTablaLocal.setViewportView(tableJugadoresLocal);
		
		
		JScrollPane scrollpanelTablaVisita = new JScrollPane();
		scrollpanelTablaVisita.setBounds(443, 259, 279, 216);
		contentPane.add(scrollpanelTablaVisita);
		
		Object[][] listavisita=new Object[5][3];
		for (int i=0;i<5;i++) {
			listavisita[i][0]=EquipoVisita.getJugadores().get(i).getCodigo();
			listavisita[i][1]=EquipoVisita.getJugadores().get(i).getNombre();
			listavisita[i][2]=EquipoVisita.getJugadores().get(i).getNumeroCamiseta();
		}
		tableJugadoresVisita = new JTable();
		tableJugadoresVisita.setModel(new DefaultTableModel(
			listavisita,
			new String[] {
				"Codigo", "Nombre", "Numero"
			}
		));
		tableJugadoresVisita.setFillsViewportHeight(true);
		scrollpanelTablaVisita.setViewportView(tableJugadoresVisita);
		
		JButton btnHacerJugada = new JButton("Hacer Jugada");
		btnHacerJugada.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnHacerJugada.setBounds(299, 262, 134, 23);
		contentPane.add(btnHacerJugada);
		
		JRadioButton rdbtnTriple = new JRadioButton("Triple");
		rdbtnTriple.setBounds(316, 307, 109, 23);
		contentPane.add(rdbtnTriple);
		
		JRadioButton rdbtnDoble = new JRadioButton("Doble");
		rdbtnDoble.setBounds(316, 352, 109, 23);
		contentPane.add(rdbtnDoble);
		
		JRadioButton rdbtnTiroLibre = new JRadioButton("Tiro Libre");
		rdbtnTiroLibre.setBounds(316, 398, 109, 23);
		contentPane.add(rdbtnTiroLibre);
		
		JButton btnFalta = new JButton("Falta");
		btnFalta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jugador aux=null;
				
				if (tableJugadoresLocal.getSelectedColumn()>-1) {
					int indexjugador=tableJugadoresLocal.getSelectedRow();
							
					aux=serie.getEquipos().get(serie.indiceDeEquipo(nombreEQlocal)).getJugadores().get(indexjugador);
					Falta ventana = new Falta(aux.getNombre(),aux,serie,nombreEQlocal);
					ventana.setVisible(true);
				}
				if (tableJugadoresVisita.getSelectedColumn()>-1) {
					int indexjugador=tableJugadoresVisita.getSelectedRow();
					
					aux=serie.getEquipos().get(serie.indiceDeEquipo(nombreEQvisita)).getJugadores().get(indexjugador);
					Falta ventana = new Falta(aux.getNombre(),aux,serie,nombreEQvisita);
					ventana.setVisible(true);
				}
				tableJugadoresVisita.clearSelection();
				tableJugadoresLocal.clearSelection();

			}
		});
		btnFalta.setBounds(322, 195, 89, 23);
		contentPane.add(btnFalta);
		
		JButton btnLesion = new JButton("Lesion");
		btnLesion.setBounds(322, 228, 89, 23);
		contentPane.add(btnLesion);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Jugadas complementarias", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(20, 486, 702, 66);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAsistencia = new JButton("Asistencia");
		btnAsistencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jugador aux=null;
				
				if (tableJugadoresLocal.getSelectedColumn()>-1) {
					int indexjugador=serie.buscarequipoByName(nombreEQlocal).indiceDeJugador(tableJugadoresLocal.getValueAt(tableJugadoresLocal.getSelectedRow(), tableJugadoresLocal.getSelectedColumn()).toString());
							
					aux=serie.getEquipos().get(serie.indiceDeEquipo(nombreEQlocal)).getJugadores().get(indexjugador);
					serie.getEquipos().get(serie.indiceDeEquipo(nombreEQlocal)).getJugadores().get(indexjugador).setCantasistencias(aux.getCantasistencias()+1);
				}
				if (tableJugadoresVisita.getSelectedColumn()>-1) {
					int indexjugador=serie.buscarequipoByName(nombreEQvisita).indiceDeJugador(tableJugadoresVisita.getValueAt(tableJugadoresVisita.getSelectedRow(), tableJugadoresVisita.getSelectedColumn()).toString());
					
					aux=serie.getEquipos().get(serie.indiceDeEquipo(nombreEQvisita)).getJugadores().get(indexjugador);
					serie.getEquipos().get(serie.indiceDeEquipo(nombreEQvisita)).getJugadores().get(indexjugador).setCantasistencias(aux.getCantasistencias()+1);
				}
				tableJugadoresVisita.clearSelection();
				tableJugadoresLocal.clearSelection();
			}
		});
		btnAsistencia.setBounds(75, 24, 134, 23);
		panel.add(btnAsistencia);
		
		JButton btnBloqueo = new JButton("Bloqueo");
		btnBloqueo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jugador aux=null;
				
				if (tableJugadoresLocal.getSelectedColumn()>-1) {
					int indexjugador=serie.buscarequipoByName(nombreEQlocal).indiceDeJugador(tableJugadoresLocal.getValueAt(tableJugadoresLocal.getSelectedRow(), tableJugadoresLocal.getSelectedColumn()).toString());
							
					aux=serie.getEquipos().get(serie.indiceDeEquipo(nombreEQlocal)).getJugadores().get(indexjugador);
					serie.getEquipos().get(serie.indiceDeEquipo(nombreEQlocal)).getJugadores().get(indexjugador).setCantbloqueo(aux.getCantbloqueo()+1);
				}
				if (tableJugadoresVisita.getSelectedColumn()>-1) {
					int indexjugador=serie.buscarequipoByName(nombreEQvisita).indiceDeJugador(tableJugadoresVisita.getValueAt(tableJugadoresVisita.getSelectedRow(), tableJugadoresVisita.getSelectedColumn()).toString());
					
					aux=serie.getEquipos().get(serie.indiceDeEquipo(nombreEQvisita)).getJugadores().get(indexjugador);
					serie.getEquipos().get(serie.indiceDeEquipo(nombreEQvisita)).getJugadores().get(indexjugador).setCantbloqueo(aux.getCantbloqueo()+1);
				}
				tableJugadoresVisita.clearSelection();
				tableJugadoresLocal.clearSelection();
			}
		});
		btnBloqueo.setBounds(284, 24, 134, 23);
		panel.add(btnBloqueo);
		
		JButton btnRoboDeBalon = new JButton("Robo de Balon");
		btnRoboDeBalon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jugador aux=null;
				
				if (tableJugadoresLocal.getSelectedColumn()>-1) {
					int indexjugador=serie.buscarequipoByName(nombreEQlocal).indiceDeJugador(tableJugadoresLocal.getValueAt(tableJugadoresLocal.getSelectedRow(), tableJugadoresLocal.getSelectedColumn()).toString());
							
					aux=serie.getEquipos().get(serie.indiceDeEquipo(nombreEQlocal)).getJugadores().get(indexjugador);
					serie.getEquipos().get(serie.indiceDeEquipo(nombreEQlocal)).getJugadores().get(indexjugador).setCantrobodebalon(aux.getCantrobodebalon()+1);
				}
				if (tableJugadoresVisita.getSelectedColumn()>-1) {
					int indexjugador=serie.buscarequipoByName(nombreEQvisita).indiceDeJugador(tableJugadoresVisita.getValueAt(tableJugadoresVisita.getSelectedRow(), tableJugadoresVisita.getSelectedColumn()).toString());
					
					aux=serie.getEquipos().get(serie.indiceDeEquipo(nombreEQvisita)).getJugadores().get(indexjugador);
					serie.getEquipos().get(serie.indiceDeEquipo(nombreEQvisita)).getJugadores().get(indexjugador).setCantrobodebalon(aux.getCantrobodebalon()+1);
				}
				tableJugadoresVisita.clearSelection();
				tableJugadoresLocal.clearSelection();
			}
		});
		btnRoboDeBalon.setBounds(493, 24, 134, 23);
		panel.add(btnRoboDeBalon);
		
		JButton btnCompletar = new JButton("Completar");
		btnCompletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simulando.getEquipos().add(Equipolocal);
				simulando.getEquipos().add(EquipoVisita);
				simulando.setPtsEquipo1(Integer.parseInt(lblPuntosLocal.getText()));
				simulando.setPtsEquipo2(Integer.parseInt(lblPuntosVisita.getText()));
				if(tipodejuego.equals("serieregular")) {
					serie.getJuegos().set(serie.indiceDeJuego(simulando.getCodigo()), simulando);
				}else {
					serie.getTemporadas().get(serie.indiceDeTemporada(simulando.getFechaDelJuego().getYear()+1900)).getJuegos().set(serie.getTemporadas().get(serie.indiceDeTemporada(simulando.getFechaDelJuego().getYear()+1900)).indiceDeJuego(simulando.getCodigo()), simulando);
				}
				
			}
		});
		btnCompletar.setBounds(322, 563, 89, 23);
		contentPane.add(btnCompletar);
//		tableJugadoresVisita.edit
		
		btnHacerJugada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Jugador aux=null;
				
				if (tableJugadoresLocal.getSelectedRow()>-1) {
					int indexjugador=tableJugadoresLocal.getSelectedRow();
					
					aux=serie.getEquipos().get(serie.indiceDeEquipo(nombreEQlocal)).getJugadores().get(indexjugador);
					if(rdbtnTiroLibre.isSelected()) {
						lblPuntosLocal.setText(Integer.toString(Integer.parseInt(lblPuntosLocal.getText())+1));
						serie.getEquipos().get(serie.indiceDeEquipo(nombreEQlocal)).getJugadores().get(indexjugador).setPtsTotalCarrera(aux.getPtsTotalCarrera()+1);
						simulando.getTipoJugada().add("Tiro Libre");
					}
					if(rdbtnDoble.isSelected()) {
						lblPuntosLocal.setText(Integer.toString(Integer.parseInt(lblPuntosLocal.getText())+2));
						serie.getEquipos().get(serie.indiceDeEquipo(nombreEQlocal)).getJugadores().get(indexjugador).setPtsTotalCarrera(aux.getPtsTotalCarrera()+2);
						simulando.getTipoJugada().add("Doble");
					}
					if(rdbtnTriple.isSelected()) {
						lblPuntosLocal.setText(Integer.toString(Integer.parseInt(lblPuntosLocal.getText())+3));
						serie.getEquipos().get(serie.indiceDeEquipo(nombreEQlocal)).getJugadores().get(indexjugador).setPtsTotalCarrera(aux.getPtsTotalCarrera()+3);
						simulando.getTipoJugada().add("Triple"); 
					}
					
				}
				if (tableJugadoresVisita.getSelectedRow()>-1) {
					int indexjugador=tableJugadoresVisita.getSelectedRow();
					
					aux=serie.getEquipos().get(serie.indiceDeEquipo(nombreEQvisita)).getJugadores().get(indexjugador);
					if(rdbtnTiroLibre.isSelected()) {
						lblPuntosVisita.setText(Integer.toString(Integer.parseInt(lblPuntosVisita.getText())+1));
						serie.getEquipos().get(serie.indiceDeEquipo(nombreEQvisita)).getJugadores().get(indexjugador).setPtsTotalCarrera(aux.getPtsTotalCarrera()+1);
					}
					if(rdbtnDoble.isSelected()) {
						lblPuntosVisita.setText(Integer.toString(Integer.parseInt(lblPuntosVisita.getText())+2));
						serie.getEquipos().get(serie.indiceDeEquipo(nombreEQvisita)).getJugadores().get(indexjugador).setPtsTotalCarrera(aux.getPtsTotalCarrera()+2);
					}
					if(rdbtnTriple.isSelected()) {
						lblPuntosVisita.setText(Integer.toString(Integer.parseInt(lblPuntosVisita.getText())+3));
						serie.getEquipos().get(serie.indiceDeEquipo(nombreEQvisita)).getJugadores().get(indexjugador).setPtsTotalCarrera(aux.getPtsTotalCarrera()+3);
					}
				}
				rdbtnTiroLibre.setSelected(false);
				rdbtnDoble.setSelected(false);
				rdbtnTriple.setSelected(false);
				tableJugadoresVisita.clearSelection();
				tableJugadoresLocal.clearSelection();

			}
		});
		
		rdbtnTiroLibre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnDoble.setSelected(false);
				rdbtnTriple.setSelected(false);
			}
		});
		
		rdbtnDoble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnTiroLibre.setSelected(false);
				rdbtnTriple.setSelected(false);
			}
		});
		
		rdbtnTriple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnDoble.setSelected(false);
				rdbtnTiroLibre.setSelected(false);
			}
		});
		tableJugadoresLocal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableJugadoresVisita.clearSelection();
			}
		});
		tableJugadoresVisita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableJugadoresLocal.clearSelection();
			}
		});
		btnLesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jugador aux=null;
				
				if (tableJugadoresLocal.getSelectedColumn()>-1) {
					int indexjugador=serie.buscarequipoByName(nombreEQlocal).indiceDeJugador(tableJugadoresLocal.getValueAt(tableJugadoresLocal.getSelectedRow(), tableJugadoresLocal.getSelectedColumn()).toString());
							
					aux=serie.getEquipos().get(serie.indiceDeEquipo(nombreEQlocal)).getJugadores().get(indexjugador);
					LesionarJugador ventana = new LesionarJugador(aux,serie,Equipolocal);
					ventana.setVisible(true);
				}
				if (tableJugadoresVisita.getSelectedColumn()>-1) {
					int indexjugador=serie.buscarequipoByName(nombreEQvisita).indiceDeJugador(tableJugadoresVisita.getValueAt(tableJugadoresVisita.getSelectedRow(), tableJugadoresVisita.getSelectedColumn()).toString());
					
					aux=serie.getEquipos().get(serie.indiceDeEquipo(nombreEQvisita)).getJugadores().get(indexjugador);
					LesionarJugador ventana = new LesionarJugador(aux,serie,EquipoVisita);
					ventana.setVisible(true);
				}
	
				tableJugadoresVisita.clearSelection();
				tableJugadoresLocal.clearSelection();

			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				simulando.getEquipos().add(Equipolocal);
				simulando.getEquipos().add(EquipoVisita);
				simulando.setPtsEquipo1(Integer.parseInt(lblPuntosLocal.getText()));
				simulando.setPtsEquipo2(Integer.parseInt(lblPuntosVisita.getText()));
				if(tipodejuego.equals("serieregular")) {
					serie.getTemporadas().get(serie.indiceDeTemporada(simulando.getFechaDelJuego().getYear()+1900)).getJuegos().set(serie.getTemporadas().get(serie.indiceDeTemporada(simulando.getFechaDelJuego().getYear()+1900)).indiceDeJuego(simulando.getCodigo()), simulando);
				}else {
					serie.getJuegos().set(serie.indiceDeJuego(simulando.getCodigo()), simulando);
				}
			}
		});
	}
	
}
