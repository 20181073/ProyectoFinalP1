package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Juego extends JFrame {

	private JPanel contentPane;
	private JTable tableJugadoresLocal;
	private JTable tableJugadoresVisita;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Juego() {
		setTitle("Simular Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 524);
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
		
		JLabel lblPuntosLocal = new JLabel("00");
		lblPuntosLocal.setFont(new Font("Lao UI", Font.BOLD, 76));
		lblPuntosLocal.setBounds(185, 176, 88, 72);
		contentPane.add(lblPuntosLocal);
		
		JLabel lblPuntosVisita = new JLabel("00");
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
		
		tableJugadoresLocal = new JTable();
		tableJugadoresLocal.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Numero"
			}
		));
		tableJugadoresLocal.setFillsViewportHeight(true);
		scrollPanelTablaLocal.setViewportView(tableJugadoresLocal);
		
		JScrollPane scrollpanelTablaVisita = new JScrollPane();
		scrollpanelTablaVisita.setBounds(443, 259, 279, 216);
		contentPane.add(scrollpanelTablaVisita);
		
		tableJugadoresVisita = new JTable();
		tableJugadoresVisita.setModel(new DefaultTableModel(
			new Object[][] {
			},
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
		btnFalta.setBounds(322, 195, 89, 23);
		contentPane.add(btnFalta);
		
		JButton btnLesion = new JButton("Lesion");
		btnLesion.setBounds(322, 228, 89, 23);
		contentPane.add(btnLesion);
//		tableJugadoresVisita.edit
	}
}
