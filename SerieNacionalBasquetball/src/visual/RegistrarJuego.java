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
	Object[][] infolocal;
	Object[][] info;

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
		Equipo local=new Equipo("",0,0);
		Equipo visita=new Equipo("",0,0);
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
		
		Object[] helperlocal={serie.getEquipos().get(0).getNombre()};
		cmbxLocal.setModel(new DefaultComboBoxModel(helperlocal));
		for (int i =1;i<serie.getEquipos().size();i++) {
			cmbxLocal.addItem(serie.getEquipos().get(i).getNombre());
		}
		cmbxLocal.setBounds(10, 32, 150, 20);
		panelEquipoLocal.add(cmbxLocal);
		
		JScrollPane scrollpanelTablaLocal = new JScrollPane();
		scrollpanelTablaLocal.setBounds(170, 15, 293, 169);
		panelEquipoLocal.add(scrollpanelTablaLocal);
		
		tableLocal = new JTable();
		infolocal= new Object[serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJugadores().size()][2];
		for(int i =0; i < serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJugadores().size();i++) {
			
			infolocal[i][0]=serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJugadores().get(i).getCodigo();
			infolocal[i][1]=serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJugadores().get(i).getNombre();		
			
		}
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
		Object[] helper= {serie.getEquipos().get(0).getNombre()};
		cmbxVisitante.setModel(new DefaultComboBoxModel(helper));
		cmbxVisitante.setBounds(10, 32, 150, 20);
		panelEquipoVisita.add(cmbxVisitante);
		for (int i =1;i<serie.getEquipos().size();i++) {
			cmbxVisitante.addItem(serie.getEquipos().get(i).getNombre());
		}
		
		JButton btnConfirmarVisita = new JButton("Confirmar Equipo");
		btnConfirmarVisita.setBounds(10, 97, 150, 23);
		panelEquipoVisita.add(btnConfirmarVisita);
		
		JScrollPane scrollPaneEquipoVisita = new JScrollPane();
		scrollPaneEquipoVisita.setBounds(170, 15, 293, 169);
		panelEquipoVisita.add(scrollPaneEquipoVisita);
		
		tableEquipoVisita = new JTable();
		info= new Object[serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJugadores().size()][2];
		for(int i =0; i < serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJugadores().size();i++) {
			
			info[i][0]=serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJugadores().get(i).getCodigo();
			info[i][1]=serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJugadores().get(i).getNombre();		
			
		}
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
		txtCodigo.setText("0");
		try {
			if(serie.getJuegos().size()>0) {
				txtCodigo.setText(Integer.toString(serie.getJuegos().get(serie.getJuegos().size()-1).getCodigo()+1));
			}
		}catch(NullPointerException e) {
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
		
		local.setFicherologo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getFicherologo());
		local.setLogo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getLogo());
		local.setNombre(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getNombre());
		local.setJuegosganados((serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJuegosganados()));
		local.setJuegosperdidos(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJuegosperdidos());
		visita.setFicherologo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getFicherologo());
		visita.setLogo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getLogo());
		visita.setJuegosganados(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJuegosganados());
		visita.setJuegosperdidos(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJuegosperdidos());
		visita.setNombre(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getNombre());
		
		
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
//					for(int p=0;p<local.getJugadores().size();p++) {
//						if(tableLocalJuego.getValueAt(i, 0).equals(tableEquipoVisitaJuego.getValueAt(p, 0))) {
//							verif=false;
//						}
//					}
				}
				
				if(visita.getNombre().equals(local.getNombre())) {
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
//					for(int p=0;p<local.getJugadores().size();p++) {
//						if(tableEquipoVisitaJuego.getValueAt(i, 0).equals(tableLocalJuego.getValueAt(p, 0))) {
//							verif=false;
//						}
//					}
				}
				
				if(visita.getNombre().equals(local.getNombre())) {
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
				
				if(visita.getJugadores().size()<5&&tableEquipoVisita.getSelectedColumn()>-1) {
					local.setFicherologo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getFicherologo());
					local.setLogo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getLogo());
					local.setNombre(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getNombre());
					local.setJuegosganados((serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJuegosganados()));
					local.setJuegosperdidos(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJuegosperdidos());
					visita.setFicherologo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getFicherologo());
					visita.setLogo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getLogo());
					visita.setJuegosganados(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJuegosganados());
					visita.setJuegosperdidos(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJuegosperdidos());
					visita.setNombre(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getNombre());
					
					visita.getJugadores().add(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJugadores().get(tableEquipoVisita.getSelectedRow()));
					Object[][] auxiliar= new Object[visita.getJugadores().size()][2];
					for(int i =0; i < visita.getJugadores().size();i++) {
						
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
				if(local.getJugadores().size()<5 && tableLocal.getSelectedColumn()>-1) {
					local.setFicherologo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getFicherologo());
					local.setLogo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getLogo());
					local.setNombre(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getNombre());
					local.setJuegosganados((serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJuegosganados()));
					local.setJuegosperdidos(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJuegosperdidos());
					visita.setFicherologo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getFicherologo());
					visita.setLogo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getLogo());
					visita.setJuegosganados(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJuegosganados());
					visita.setJuegosperdidos(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJuegosperdidos());
					visita.setNombre(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getNombre());
					
					local.getJugadores().add(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString()))
							.getJugadores().get(tableLocal.getSelectedRow()));
					Object[][] auxiliar= new Object[local.getJugadores().size()][2];
					for(int i =0; i < local.getJugadores().size();i++) {
						
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
		cmbxLocal.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				local.setFicherologo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getFicherologo());
				local.setLogo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getLogo());
				local.setNombre(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getNombre());
				local.setJuegosganados((serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJuegosganados()));
				local.setJuegosperdidos(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJuegosperdidos());
				visita.setFicherologo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getFicherologo());
				visita.setLogo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getLogo());
				visita.setJuegosganados(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJuegosganados());
				visita.setJuegosperdidos(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJuegosperdidos());
				visita.setNombre(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getNombre());
				
				infolocal = new Object[serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJugadores().size()][2];
				
				for(int i =0; i < serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJugadores().size();i++) {
					
					infolocal[i][0]=serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJugadores().get(i).getCodigo();
					infolocal[i][1]=serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJugadores().get(i).getNombre();		
					
				}
				tableLocal.setModel(new DefaultTableModel(
						infolocal,
						new String[] {
							"Codigo", "Nombre"
						}
				));
				
			}
		});

		cmbxVisitante.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				local.setFicherologo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getFicherologo());
				local.setLogo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getLogo());
				local.setNombre(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getNombre());
				local.setJuegosganados((serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJuegosganados()));
				local.setJuegosperdidos(serie.getEquipos().get(serie.indiceDeEquipo(cmbxLocal.getSelectedItem().toString())).getJuegosperdidos());
				visita.setFicherologo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getFicherologo());
				visita.setLogo(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getLogo());
				visita.setJuegosganados(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJuegosganados());
				visita.setJuegosperdidos(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJuegosperdidos());
				visita.setNombre(serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getNombre());
					
					info= new Object[serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJugadores().size()][2];
					for(int i =0; i < serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJugadores().size();i++) {
						
						info[i][0]=serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJugadores().get(i).getCodigo();
						info[i][1]=serie.getEquipos().get(serie.indiceDeEquipo(cmbxVisitante.getSelectedItem().toString())).getJugadores().get(i).getNombre();		
						
					}
				
				tableEquipoVisita.setModel(new DefaultTableModel(
						info,
						new String[] {
							"Codigo", "Nombre"
						}
				));
				
			}
		});
		
	}
	
}
