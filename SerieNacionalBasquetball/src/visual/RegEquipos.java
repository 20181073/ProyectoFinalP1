package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import java.awt.Font;

public class RegEquipos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCodigo;

	public static void main(String[] args) {
		try {
			RegEquipos dialog = new RegEquipos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RegEquipos() {
		setResizable(false);
		setTitle("Registrar Equipo");
		setBounds(100, 100, 840, 486);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 804, 392);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(101, 61, 135, 20);
		panel.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNombre.setBounds(0, 64, 91, 14);
		panel.add(lblNombre);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCodigo.setBounds(0, 33, 91, 14);
		panel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(101, 30, 105, 20);
		panel.add(txtCodigo);
		
		JPanel panel_JugadoresSinEquipo = new JPanel();
		panel_JugadoresSinEquipo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_JugadoresSinEquipo.setBounds(256, 30, 230, 350);
		panel.add(panel_JugadoresSinEquipo);
		
		JPanel panel_JugadoresSeleccionados = new JPanel();
		panel_JugadoresSeleccionados.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_JugadoresSeleccionados.setBounds(564, 11, 230, 369);
		panel.add(panel_JugadoresSeleccionados);
		
		JPanel panel_Logo = new JPanel();
		panel_Logo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_Logo.setBounds(10, 96, 236, 230);
		panel.add(panel_Logo);
		
		JLabel lblJugadoresSinEquipo = new JLabel("Jugadores sin equipos");
		lblJugadoresSinEquipo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblJugadoresSinEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadoresSinEquipo.setBounds(256, 0, 230, 29);
		panel.add(lblJugadoresSinEquipo);
		
		JButton btnDerecha = new JButton(">>>");
		btnDerecha.setBounds(496, 121, 58, 23);
		panel.add(btnDerecha);
		
		JButton btnIzquierda = new JButton("<<<");
		btnIzquierda.setBounds(496, 259, 58, 23);
		panel.add(btnIzquierda);
		
		JButton btnSeleccionarImagen = new JButton("Seleccionar imagen");
		btnSeleccionarImagen.setBounds(10, 337, 236, 23);
		panel.add(btnSeleccionarImagen);
		{
			JPanel Panel_Inferior = new JPanel();
			Panel_Inferior.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			Panel_Inferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(Panel_Inferior, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setActionCommand("OK");
				Panel_Inferior.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				Panel_Inferior.add(btnCancelar);
			}
		}
	}
}
