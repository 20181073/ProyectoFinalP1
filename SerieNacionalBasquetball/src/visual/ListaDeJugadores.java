package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class ListaDeJugadores extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaDeJugadores frame = new ListaDeJugadores();
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
	public ListaDeJugadores() {
		setResizable(false);
		setTitle("Jugadores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 307);
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
			},
			new String[] {
					"Codigo", "Nombre","Numero de Camiseta",  "Lesiones actuales", "Equipo", "Posicion"
			}
		));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JButton btnVerLesiones = new JButton("Ver lesiones");
		btnVerLesiones.setBounds(280, 235, 122, 23);
		contentPane.add(btnVerLesiones);
		
		JButton btnEliminarJugador = new JButton("Eliminar jugador");
		btnEliminarJugador.setBounds(79, 235, 122, 23);
		contentPane.add(btnEliminarJugador);
		
		JButton btnAgregarJugador = new JButton("Agregar Jugador");
		btnAgregarJugador.setBounds(481, 235, 122, 23);
		contentPane.add(btnAgregarJugador);
	}
}
