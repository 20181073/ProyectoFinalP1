package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Juego;
import logica.SerieNacional;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CambiarFecha extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambiarFecha frame = new CambiarFecha();
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
	public CambiarFecha(int yearj,SerieNacional serie,Juego juego) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagenes/IconoPrincipal.png")));
		setResizable(false);
		setTitle("Cambiar fecha de juego");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 413, 267);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFechaOriginal = new JLabel("Fecha original");
		lblFechaOriginal.setBounds(23, 25, 168, 14);
		contentPane.add(lblFechaOriginal);
		
		JLabel lblHoy = new JLabel("Hoy");
		lblHoy.setText(juego.getFechaDelJuego().toString());
		lblHoy.setBounds(23, 62, 168, 14);
		contentPane.add(lblHoy);
		
		JLabel lblNuevaFecha = new JLabel("Nueva Fecha");
		lblNuevaFecha.setBounds(266, 25, 86, 14);
		contentPane.add(lblNuevaFecha);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date((long)juego.getFechaDelJuego().getTime()), new Date((Long) juego.getFechaDelJuego().getTime()+(7*24*60*60*1000)), new Date(1564632000000L), Calendar.DAY_OF_YEAR));
		spinner.setBounds(265, 59, 118, 20);
		contentPane.add(spinner);
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serie.getTemporadas().get(serie.indiceDeTemporada(yearj)).getJuegos().get(serie.indiceDeJuego(yearj)).setFechaDelJuego((Date) spinner.getValue());
				dispose();
			}
		});
		btnCambiar.setBounds(159, 173, 89, 23);
		contentPane.add(btnCambiar);
		
		JLabel lblEquipo = new JLabel("Equipo1");
		lblEquipo.setText(juego.getEquipos().get(0).getNombre());
		lblEquipo.setBounds(23, 123, 168, 14);
		contentPane.add(lblEquipo);
		
		JLabel lblEquipo2 = new JLabel("Equipo2");
		lblEquipo2.setText((juego.getEquipos().get(1).getNombre()));
		lblEquipo2.setBounds(266, 123, 86, 14);
		contentPane.add(lblEquipo2);
	}
}
