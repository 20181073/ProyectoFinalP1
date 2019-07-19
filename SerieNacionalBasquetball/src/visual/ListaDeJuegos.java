package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logica.Equipo;
import logica.Juego;
import logica.SerieNacional;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaDeJuegos extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaDeJuegos frame = new ListaDeJuegos();
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
	public ListaDeJuegos(SerieNacional serie,String codigoEQlocal,String codigoEQvisita,Equipo Equipolocal,Equipo EquipoVisita,Juego simulando) {
		setTitle("Juegos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 685, 204);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Estado", "Fecha", "Ganador", "Equipo Visitante", "Equipo local"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JButton btnSimular = new JButton("Simular");
		btnSimular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimulacionJuego ventana=new SimulacionJuego(  serie,  codigoEQlocal, codigoEQvisita,  Equipolocal, EquipoVisita, simulando);
			}
		});
		btnSimular.setBounds(448, 228, 89, 23);
		contentPane.add(btnSimular);
		
		JButton btnEliminarJuego = new JButton("Eliminar Juego");
		btnEliminarJuego.setBounds(547, 228, 118, 23);
		contentPane.add(btnEliminarJuego);
	}

}
