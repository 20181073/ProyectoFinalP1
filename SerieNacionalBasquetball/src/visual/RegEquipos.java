package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class RegEquipos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;

	public RegEquipos() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(RegEquipos.class.getResource("/imagenes/IconoPrincipal.png")));
		setResizable(false);
		setTitle("Registrar Equipo");
		setBounds(100, 100, 549, 345);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 523, 257);
		contentPanel.add(panel);
		panel.setLayout(null);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(91, 63, 176, 20);
		panel.add(txtNombre);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNombre.setBounds(10, 65, 71, 14);
		panel.add(lblNombre);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblLogo.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(277, 11, 236, 235);
		panel.add(lblLogo);

		JButton btnSeleccionarImagen = new JButton("Cargar imagen");
		btnSeleccionarImagen.setIcon(null);
		btnSeleccionarImagen.setSelectedIcon(null);
		btnSeleccionarImagen.setBounds(27, 146, 240, 23);
		panel.add(btnSeleccionarImagen);

		JPanel Panel_Inferior = new JPanel();
		Panel_Inferior.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Panel_Inferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(Panel_Inferior, BorderLayout.SOUTH);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnRegistrar.setActionCommand("OK");
		Panel_Inferior.add(btnRegistrar);
		getRootPane().setDefaultButton(btnRegistrar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setActionCommand("Cancel");
		Panel_Inferior.add(btnCancelar);

	}
}
