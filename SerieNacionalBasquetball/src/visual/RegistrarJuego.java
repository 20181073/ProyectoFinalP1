package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.CardLayout;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logica.Equipo;
import logica.Jugador;
import logica.SerieNacional;

import javax.swing.JButton;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarJuego extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTable tableLocal;
	private JTable tableLocalJuego;
	private JTable tableEquipoVisita;
	private JTable tableEquipoVisitaJuego;
	private int paneles=-1;//-1 local & 1Visita
	private boolean confirmarlocal=false;
	private boolean confirmarvisita=false;

	/**
	 * Launch the application.
	 * 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarJuego frame = new RegistrarJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrarJuego(SerieNacional serie) {
		Equipo local;
		Equipo visita;
		setResizable(false);
		setTitle("Registrar Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelEquipos = new JPanel();
		panelEquipos.setBounds(10, 73, 776, 191);
		contentPane.add(panelEquipos);
		panelEquipos.setLayout(new CardLayout(0, 0));
		
		JPanel panelEquipoLocal = new JPanel();
		panelEquipos.add(panelEquipoLocal, "name_50081921538735");
		panelEquipoLocal.setLayout(null);
		
		JLabel lblEquipoLocal = new JLabel("Equipo Local");
		lblEquipoLocal.setBounds(10, 11, 128, 14);
		panelEquipoLocal.add(lblEquipoLocal);
		
		JComboBox cmbxLocal = new JComboBox();
		cmbxLocal.setModel(new DefaultComboBoxModel(new String[] {"-"}));
		cmbxLocal.setBounds(10, 32, 150, 20);
		panelEquipoLocal.add(cmbxLocal);
		
		JScrollPane scrollpanelTablaLocal = new JScrollPane();
		scrollpanelTablaLocal.setBounds(170, 15, 293, 169);
		panelEquipoLocal.add(scrollpanelTablaLocal);
		
		tableLocal = new JTable();
		tableLocal.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Codigo", "Nombre"
			}
		));
		tableLocal.setFillsViewportHeight(true);
		scrollpanelTablaLocal.setViewportView(tableLocal);
		
		JScrollPane scrollPaneLocalJuego = new JScrollPane();
		scrollPaneLocalJuego.setBounds(473, 77, 293, 107);
		panelEquipoLocal.add(scrollPaneLocalJuego);
		
		tableLocalJuego = new JTable();
		tableLocalJuego.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre"
			}
		));
		tableLocalJuego.setFillsViewportHeight(true);
		scrollPaneLocalJuego.setViewportView(tableLocalJuego);
		
		JLabel lblSeleccionados = new JLabel("Seleccionados:");
		lblSeleccionados.setBounds(473, 52, 102, 14);
		panelEquipoLocal.add(lblSeleccionados);
		
		JButton btnSeleccionarJugador = new JButton("Seleccionar Jugador");
		btnSeleccionarJugador.setBounds(473, 11, 164, 23);
		panelEquipoLocal.add(btnSeleccionarJugador);
		
		JButton btnConfirmarEquipo = new JButton("Confirmar Equipo");
		
		btnConfirmarEquipo.setBounds(10, 97, 150, 23);
		panelEquipoLocal.add(btnConfirmarEquipo);
		
		JLabel labelNombreLocal = new JLabel("Nombre");
		labelNombreLocal.setBounds(10, 63, 128, 14);
		panelEquipoLocal.add(labelNombreLocal);
		
		JPanel panelEquipoVisita = new JPanel();
		panelEquipos.add(panelEquipoVisita, "name_50094556177866");
		panelEquipoVisita.setLayout(null);
		
		JLabel lblEquipoVisitante = new JLabel("Equipo Visitante");
		lblEquipoVisitante.setBounds(10, 11, 128, 14);
		panelEquipoVisita.add(lblEquipoVisitante);
		
		JComboBox cmbxVisitante = new JComboBox();
		Object[][] info= new Object[serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getCantjugador()][2];
		for(int i =0; i < serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getCantjugador();i++) {
			
			info[i][0]=serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getCodigo();
			info[i][1]=serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getNombre();		
			
		}
		cmbxVisitante.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				Object[][] info= new Object[serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getCantjugador()][2];
				for(int i =0; i < serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getCantjugador();i++) {
					
					info[i][0]=serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getCodigo();
					info[i][1]=serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getNombre();		
					
				}
				tableEquipoVisita.setModel(new DefaultTableModel(
						info,
						new String[] {
							"Codigo", "Nombre"
						}
					));
				
			}
		});
		Object[] helper= {serie.getEquipos().get(0).getCodigo()};
		cmbxVisitante.setModel(new DefaultComboBoxModel(helper));
		cmbxVisitante.setBounds(10, 32, 128, 20);
		panelEquipoVisita.add(cmbxVisitante);
		for (int i =1;i<serie.getCantidadEquipos();i++) {
			cmbxVisitante.addItem(serie.getEquipos().get(i).getCodigo());
		}
		
		JButton btnConfirmarVisita = new JButton("Confirmar Equipo");
		btnConfirmarVisita.setBounds(10, 97, 150, 23);
		panelEquipoVisita.add(btnConfirmarVisita);
		
		JScrollPane scrollPaneEquipoVisita = new JScrollPane();
		scrollPaneEquipoVisita.setBounds(170, 15, 293, 169);
		panelEquipoVisita.add(scrollPaneEquipoVisita);
		
		tableEquipoVisita = new JTable();
		tableEquipoVisita.setModel(new DefaultTableModel(
			info,
			new String[] {
				"Codigo", "Nombre"
			}
		));
		tableEquipoVisita.setFillsViewportHeight(true);
		scrollPaneEquipoVisita.setViewportView(tableEquipoVisita);
		
		JButton btnSeleccionarJugadorVisita = new JButton("Seleccionar Jugador");
		btnSeleccionarJugadorVisita.setBounds(473, 11, 164, 23);
		panelEquipoVisita.add(btnSeleccionarJugadorVisita);
		
		JLabel label = new JLabel("Seleccionados:");
		label.setBounds(473, 52, 102, 14);
		panelEquipoVisita.add(label);
		
		JScrollPane scrollPaneEquipoVisitaJuego = new JScrollPane();
		scrollPaneEquipoVisitaJuego.setBounds(473, 77, 293, 107);
		panelEquipoVisita.add(scrollPaneEquipoVisitaJuego);
		
		tableEquipoVisitaJuego = new JTable();
		tableEquipoVisitaJuego.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre"
			}
		));
		tableEquipoVisitaJuego.setFillsViewportHeight(true);
		scrollPaneEquipoVisitaJuego.setViewportView(tableEquipoVisitaJuego);
		
		JLabel lblNombreVisita = new JLabel("Nombre");
		lblNombreVisita.setBounds(10, 63, 128, 14);
		panelEquipoVisita.add(lblNombreVisita);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(176, 11, 128, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(176, 36, 128, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JSpinner spnFechaDelJuego = new JSpinner();
		spnFechaDelJuego.setModel(new SpinnerDateModel(new Date(1563508800000L), new Date(1563508800000L), new Date(1910923200000L), Calendar.DAY_OF_YEAR));
		spnFechaDelJuego.setBounds(480, 36, 128, 20);
		contentPane.add(spnFechaDelJuego);
		
		JLabel lblFechaDelJuego = new JLabel("Fecha del Juego");
		lblFechaDelJuego.setBounds(480, 11, 128, 14);
		contentPane.add(lblFechaDelJuego);
		
		JButton btnConfiramarJuego = new JButton("Confiramar Juego");
		btnConfiramarJuego.setEnabled(false);
		btnConfiramarJuego.setBounds(320, 24, 150, 23);
		contentPane.add(btnConfiramarJuego);
		
		JButton btnCambiarEquipo = new JButton("Cambiar Equipo");
		btnCambiarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(paneles==-1) {
					panelEquipos.removeAll();
					panelEquipos.add(panelEquipoVisita);
					panelEquipos.repaint();
					panelEquipos.revalidate();
					paneles=1;
				}
				else {
					panelEquipos.removeAll();
					panelEquipos.add(panelEquipoLocal);
					panelEquipos.repaint();
					panelEquipos.revalidate();
					paneles=-1;
				}

			}
		});
		btnCambiarEquipo.setBounds(10, 24, 128, 23);
		contentPane.add(btnCambiarEquipo);
		
		local=serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString()));
		local.setJugadores(new ArrayList<Jugador>());
		visita=serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString()));
		visita.setJugadores(new ArrayList<Jugador>());
		
		btnConfirmarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (confirmarlocal==true && confirmarvisita==true) {
					btnConfiramarJuego.setEnabled(true);
				}
			}
		});
		btnConfirmarVisita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (confirmarlocal==true && confirmarvisita==true) {
					btnConfiramarJuego.setEnabled(true);
				}
			}
		});
		
		btnSeleccionarJugadorVisita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(visita.getCantjugador()<5) {
					visita.getJugadores().add(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJugadores().get(Integer.parseInt(tableEquipoVisita.getValueAt(tableEquipoVisita.getSelectedRow(), 0).toString())));
					visita.setCantjugador(visita.getCantjugador()+1);
					Object[][] auxiliar= new Object[visita.getCantjugador()][2];
					for(int i =0; i < visita.getCantjugador();i++) {
						
						auxiliar[i][0]=visita.getJugadores().get(i).getCodigo();
						auxiliar[i][1]=	visita.getJugadores().get(i).getNombre();
						
					}
					tableEquipoVisitaJuego.setModel(new DefaultTableModel(
						auxiliar,
						new String[] {
							"Codigo", "Nombre"
						}
					));
					
				}
				
			}
		});
		
	}
}