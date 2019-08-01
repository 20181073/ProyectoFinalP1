package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logica.SerieNacional;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class CalendarioRegular extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarioRegular frame = new CalendarioRegular();
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
	public CalendarioRegular(SerieNacional serie) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagenes/IconoPrincipal.png")));
		setTitle("Calendario para la serie regular");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 631, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 595, 365);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(2019), new Integer(1990), null, new Integer(1)));
		spinner.setBounds(42, 51, 103, 20);
		panel.add(spinner);
		
		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setBounds(42, 27, 103, 14);
		panel.add(lblAo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 575, 173);
		panel.add(scrollPane);
		
		table = new JTable();
		Object[][] info= new Object[serie.getJuegos().size()][8];
		for(int i =0; i < serie.getJuegos().size();i++) { 
			
			info[i][0]=serie.getTemporadas().get(serie.indiceDeTemporada(Integer.parseInt(spinner.getValue().toString()))).getJuegos().get(i).getCodigo();
		
			info[i][1]=serie.getTemporadas().get(serie.indiceDeTemporada(Integer.parseInt(spinner.getValue().toString()))).getJuegos().get(i).getEstado();
			
			info[i][2]=serie.getTemporadas().get(serie.indiceDeTemporada(Integer.parseInt(spinner.getValue().toString()))).getJuegos().get(i).getFechaDelJuego();
			if(serie.getTemporadas().get(serie.indiceDeTemporada(Integer.parseInt(spinner.getValue().toString()))).getJuegos().get(i).getPtsEquipo1()>serie.getTemporadas().get(serie.indiceDeTemporada(Integer.parseInt(spinner.getValue().toString()))).getJuegos().get(i).getPtsEquipo2()) {
				info[i][3]=serie.getTemporadas().get(serie.indiceDeTemporada(Integer.parseInt(spinner.getValue().toString()))).getJuegos().get(i).getEquipos().get(0).getNombre();
			}
			if(serie.getTemporadas().get(serie.indiceDeTemporada(Integer.parseInt(spinner.getValue().toString()))).getJuegos().get(i).getPtsEquipo1()<serie.getTemporadas().get(serie.indiceDeTemporada(Integer.parseInt(spinner.getValue().toString()))).getJuegos().get(i).getPtsEquipo2()) {
				info[i][3]=serie.getTemporadas().get(serie.indiceDeTemporada(Integer.parseInt(spinner.getValue().toString()))).getJuegos().get(i).getEquipos().get(1).getNombre();
			}
			info[i][4]=serie.getTemporadas().get(serie.indiceDeTemporada(Integer.parseInt(spinner.getValue().toString()))).getJuegos().get(i).getEquipos().get(1).getNombre();
			info[i][5]=serie.getTemporadas().get(serie.indiceDeTemporada(Integer.parseInt(spinner.getValue().toString()))).getJuegos().get(i).getEquipos().get(1).getCodigo();
			info[i][6]=serie.getTemporadas().get(serie.indiceDeTemporada(Integer.parseInt(spinner.getValue().toString()))).getJuegos().get(i).getEquipos().get(0).getNombre();
			info[i][7]=serie.getTemporadas().get(serie.indiceDeTemporada(Integer.parseInt(spinner.getValue().toString()))).getJuegos().get(i).getEquipos().get(0).getCodigo();
			
		}
		table.setModel(new DefaultTableModel(
			info,
			new String[] {
				"Codigo del Juego", "Estado", "Fecha", "Ganador", "Equipo Visitante", "Codigo de la visita", "Equipo local", "Codigo del local"
			}
		));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JButton btnGenerarCalendarioPara = new JButton("Generar calendario para la temporada seleccionada");
		btnGenerarCalendarioPara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if(true) {
					
//				}
				EquiposSerieRegular ventana = new EquiposSerieRegular(Integer.parseInt(spinner.getValue().toString()),serie);
				ventana.setVisible(true);
				dispose();
			}
		});
		btnGenerarCalendarioPara.setEnabled(false);
		btnGenerarCalendarioPara.setBounds(286, 50, 299, 23);
		panel.add(btnGenerarCalendarioPara);
		
		JButton btnCambiarFechaDe = new JButton("Cambiar Fecha de juego");
		btnCambiarFechaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CambiarFecha ventana = new CambiarFecha(Integer.parseInt(spinner.getValue().toString()),serie,serie.getJuegos().get(serie.indiceDeJuego(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()))));
				ventana.setVisible(true);
			}
		});
		btnCambiarFechaDe.setBounds(83, 295, 173, 23);
		panel.add(btnCambiarFechaDe);
		
		JButton btnSimularJuego = new JButton("Simular Juego");
		btnSimularJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimulacionJuego ventana=new SimulacionJuego(  serie,  table.getValueAt(table.getSelectedRow(), 7).toString(), table.getValueAt(table.getSelectedRow(), 5).toString(),  serie.getEquipos().get(serie.indiceDeEquipo(table.getValueAt(table.getSelectedRow(), 7).toString())), serie.getEquipos().get(serie.indiceDeEquipo(table.getValueAt(table.getSelectedRow(), 5).toString())), serie.getJuegos().get(serie.indiceDeJuego(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()))),"serieregular");
				ventana.setVisible(true);
				dispose();
			}
		});
		btnSimularJuego.setBounds(339, 295, 173, 23);
		panel.add(btnSimularJuego);
	}
}
