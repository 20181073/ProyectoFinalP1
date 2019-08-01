package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

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
import logica.Juego;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagenes/IconoPrincipal.png")));
		Equipo local;
		Equipo visita;
		setResizable(false);
		setTitle("Registrar Juego");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		Object[][] infolocal= new Object[serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getCantjugador()][2];
		for(int i =0; i < serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getCantjugador();i++) {
			
			infolocal[i][0]=serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getCodigo();
			infolocal[i][1]=serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getNombre();		
			
		}
		cmbxLocal.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Object[][] infolocal= new Object[serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getCantjugador()][2];
				for(int i =0; i < serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getCantjugador();i++) {
					
					infolocal[i][0]=serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getCodigo();
					infolocal[i][1]=serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getNombre();		
					
				}
				tableLocal.setModel(new DefaultTableModel(
						infolocal,
						new String[] {
							"Codigo", "Nombre"
						}
				));
				
			}
		});
		Object[] helperlocal={serie.getEquipos().get(0).getCodigo()};
		cmbxLocal.setModel(new DefaultComboBoxModel(helperlocal));
		for (int i =1;i<serie.getEquipos().size();i++) {
			cmbxLocal.addItem(serie.getEquipos().get(i).getCodigo());
		}
		cmbxLocal.setBounds(10, 32, 150, 20);
		panelEquipoLocal.add(cmbxLocal);
		
		JScrollPane scrollpanelTablaLocal = new JScrollPane();
		scrollpanelTablaLocal.setBounds(170, 15, 293, 169);
		panelEquipoLocal.add(scrollpanelTablaLocal);
		
		tableLocal = new JTable();
		tableLocal.setModel(new DefaultTableModel(
			infolocal,
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
		for (int i =1;i<serie.getEquipos().size();i++) {
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
		if(serie.getJuegos().size()>0) {
			txtCodigo.setText(Integer.toString(serie.getJuegos().get(serie.getJuegos().size()-1).getCodigo()+1));
		}else {
			txtCodigo.setText("0");
		}
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
								
				int auxrowcount=0;
				boolean verif=true;
				for(int i =0;i<auxrowcount;i++) {
					for(int p=0;p<=i;p++) {
						if(tableLocalJuego.getValueAt(i, 0).equals(tableLocalJuego.getValueAt(p, 0))) {
							verif=false;
						}
					}
					for(int p=0;p<local.getCantjugador();p++) {
						if(tableLocalJuego.getValueAt(i, 0).equals(tableEquipoVisitaJuego.getValueAt(p, 0))) {
							verif=false;
						}
					}
				}
				
				if(visita.getCodigo().equals(local.getCodigo())) {
					verif = false;
				}
				
				if(verif==false) {

					local.setJugadores(new ArrayList<Jugador>());
					tableLocalJuego.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Codigo", "Nombre"
						}
					));					
					
				}
				else {
					confirmarlocal=true;
				}
				if (confirmarlocal==true && confirmarvisita==true) {
					btnConfiramarJuego.setEnabled(true);
					btnConfirmarEquipo.setEnabled(false);
				}
				
				
			}
		});
		btnConfirmarVisita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				int auxrowcount=0;
				boolean verif=true;
				for(int i =0;i<auxrowcount;i++) {
					for(int p=0;p<=i;p++) {
						if(tableEquipoVisitaJuego.getValueAt(i, 0).equals(tableEquipoVisitaJuego.getValueAt(p, 0))) {
							verif=false;
						}
					}
					for(int p=0;p<local.getCantjugador();p++) {
						if(tableEquipoVisitaJuego.getValueAt(i, 0).equals(tableLocalJuego.getValueAt(p, 0))) {
							verif=false;
						}
					}
				}
				
				if(visita.getCodigo().equals(local.getCodigo())) {
					verif = false;
				}
				
				if(verif==false) {
//					for(int i=0;i<5;i++) {
//						visita.getJugadores().add(serie.buscarjugadorByCode(tableEquipoVisitaJuego.getValueAt(i, 0).toString()));
//					}
					visita.setJugadores(new ArrayList<Jugador>());
					tableEquipoVisitaJuego.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Codigo", "Nombre"
						}
					));
					
					
				}
				else {
					confirmarvisita=true;
				}
				
				if (confirmarlocal==true && confirmarvisita==true) {
					btnConfiramarJuego.setEnabled(true);
					btnConfirmarVisita.setEnabled(false);
				}
				
				
			}
		});
		
		btnSeleccionarJugadorVisita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(visita.getCantjugador()<5&&tableEquipoVisita.getSelectedColumn()>-1) {
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
		
		btnSeleccionarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(local.getCantjugador()<5 && tableLocal.getSelectedColumn()>-1) {
					local.getJugadores().add(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJugadores().get(Integer.parseInt(tableLocal.getValueAt(tableLocal.getSelectedRow(), 0).toString())));
					local.setCantjugador(local.getCantjugador()+1);
					Object[][] auxiliar= new Object[local.getCantjugador()][2];
					for(int i =0; i < local.getCantjugador();i++) {
						
						auxiliar[i][0]=local.getJugadores().get(i).getCodigo();
						auxiliar[i][1]=	local.getJugadores().get(i).getNombre();
						
					}
					tableLocalJuego.setModel(new DefaultTableModel(
						auxiliar,
						new String[] {
							"Codigo", "Nombre"
						}
					));
					
				}
			
			}
		});
		btnConfiramarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Juego juegonuevo =new Juego( (Date) spnFechaDelJuego.getValue(), 0, 0, "No Jugado", Integer.parseInt(txtCodigo.getText()));
				juegonuevo.getEquipos().add(local);
				juegonuevo.getEquipos().add(visita);
				serie.getJuegos().add(juegonuevo);
				dispose();
			}
		});
		
	}
}
