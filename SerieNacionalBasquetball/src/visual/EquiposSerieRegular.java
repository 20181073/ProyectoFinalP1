package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Equipo;
import logica.SerieNacional;
import logica.Temporada;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class EquiposSerieRegular extends JFrame {

	private JPanel contentPane;
	private JTable tableEquipos;
	private JTable tableSeleccion;
	private ArrayList<Equipo> seleccion;
	private int cantseleccion;
		
	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquiposSerieRegular frame = new EquiposSerieRegular();
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
	public EquiposSerieRegular(int yearj,SerieNacional serie ) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EquiposSerieRegular.class.getResource("/imagenes/IconoPrincipal.png")));
		setTitle("Generar Temporada"+yearj);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		seleccion = new ArrayList<Equipo>();
		setBounds(100, 100, 631, 361);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEquipos = new JLabel("Equipos ");
		lblEquipos.setBounds(88, 17, 88, 14);
		contentPane.add(lblEquipos);
		
		JLabel lblSeleccionParaLa = new JLabel("Seleccion para la serie");
		lblSeleccionParaLa.setBounds(415, 17, 116, 14);
		contentPane.add(lblSeleccionParaLa);
		
		JScrollPane scrollPaneSeleccion = new JScrollPane();
		scrollPaneSeleccion.setBounds(385, 42, 220, 270);
		contentPane.add(scrollPaneSeleccion);
		
		tableSeleccion = new JTable(); 
		tableSeleccion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableEquipos.clearSelection();
			}
		});
		Object[][] infoSel = new Object[26][2];
		tableSeleccion.setModel(new DefaultTableModel(
			infoSel,
			new String[] {
				 "Nombre", "Jugadores"
			}
		));
		tableSeleccion.setFillsViewportHeight(true);
		scrollPaneSeleccion.setViewportView(tableSeleccion);
		
		JScrollPane scrollPaneEquipos = new JScrollPane();
		scrollPaneEquipos.setBounds(10, 42, 220, 270);
		contentPane.add(scrollPaneEquipos);
		
		tableEquipos = new JTable();
		tableEquipos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableSeleccion.clearSelection();
			}
		});
		Object[][] infoEquip = new Object[serie.getEquipos().size()][2];
		for(int i=0; i<serie.getEquipos().size();i++) {
			infoEquip[i][0]=serie.getEquipos().get(i).getNombre();
			infoEquip[i][1]=serie.getEquipos().get(i).getJugadores().size();
		}
		tableEquipos.setModel(new DefaultTableModel(
			infoEquip,
			new String[] {
				"Nombre", "Jugadores"
			}
		));
		tableEquipos.setFillsViewportHeight(true);
		scrollPaneEquipos.setViewportView(tableEquipos);
		
		JButton btnSeleccionar = new JButton(">>");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cantseleccion<27 && tableEquipos.getSelectedRow()>-1) {
					seleccion.add(serie.buscarequipoByName(tableEquipos.getValueAt(tableEquipos.getSelectedRow(), 0).toString()));
					cantseleccion++; 
					((DefaultTableModel) tableSeleccion.getModel()).addRow(new Object[] {tableEquipos.getValueAt(tableEquipos.getSelectedRow(), 0),tableEquipos.getValueAt(tableEquipos.getSelectedRow(), 1)});;
					((DefaultTableModel) tableEquipos.getModel()).removeRow(tableEquipos.getSelectedRow());
				}
				
			}
		});
		btnSeleccionar.setBounds(241, 63, 134, 23);
		contentPane.add(btnSeleccionar);
		
		JButton btnDeseleccionar = new JButton("<<");
		btnDeseleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cantseleccion>0 && tableSeleccion.getSelectedRow()>-1) {
					seleccion.remove(serie.buscarequipoByName(tableSeleccion.getValueAt(tableSeleccion.getSelectedRow(), 0).toString()));
					cantseleccion--;
					((DefaultTableModel) tableSeleccion.getModel()).removeRow(tableSeleccion.getSelectedRow());
					((DefaultTableModel) tableEquipos.getModel()).addRow(new Object[] {tableSeleccion.getValueAt(tableSeleccion.getSelectedRow(), 0),tableSeleccion.getValueAt(tableSeleccion.getSelectedRow(), 1)});
				}
			}
		});
		btnDeseleccionar.setBounds(241, 149, 134, 23);
		contentPane.add(btnDeseleccionar);
		
		JButton btnConfirmarSeleccion = new JButton("Confirmar Seleccion");
		btnConfirmarSeleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cantseleccion>4 && cantseleccion%2==0) {
					
					serie.getTemporadas().add(new Temporada(seleccion,cantseleccion,yearj));
					serie.setCanttemporadas(serie.getCanttemporadas()+1); 
					serie.getTemporadas().get(serie.getTemporadas().size()).RegistrarJuegos(yearj);;
					
					dispose();
				}
			}
		});
		btnConfirmarSeleccion.setBounds(240, 235, 135, 23);
		contentPane.add(btnConfirmarSeleccion);
	}
}
