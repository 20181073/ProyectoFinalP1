package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.ServidorSerie;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VisualServer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ServidorSerie servidor;
	private JPasswordField txtPassConfirmar;
	private JPasswordField txtPassword;
	private JTextField txtUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualServer frame = new VisualServer();
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
	public VisualServer() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagenes/IconoPrincipal.png")));
		servidor = new ServidorSerie();
		setResizable(false);
		setTitle("Servidor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnIniciarServidor = new JButton("Iniciar Servidor");
		btnIniciarServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Thread t = new Thread(servidor);
				t.start();
				JOptionPane.showMessageDialog(null, "Servidor iniciado.", "Aviso", JOptionPane.WARNING_MESSAGE);
				btnIniciarServidor.setEnabled(false);

			}
		});
		btnIniciarServidor.setBounds(148, 279, 147, 23);
		contentPane.add(btnIniciarServidor);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Registrar usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 24, 424, 244);
		contentPane.add(panel);
		panel.setLayout(null);

		txtPassConfirmar = new JPasswordField();
		txtPassConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassConfirmar.setColumns(10);
		txtPassConfirmar.setBounds(187, 121, 227, 20);
		panel.add(txtPassConfirmar);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setColumns(10);
		txtPassword.setBounds(125, 81, 289, 20);
		panel.add(txtPassword);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(125, 37, 289, 20);
		panel.add(txtUsuario);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(10, 42, 126, 14);
		panel.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasea.setBounds(10, 86, 126, 14);
		panel.add(lblContrasea);

		JLabel lblConfirmarContrasea = new JLabel("Confirmar Contrase\u00F1a:");
		lblConfirmarContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfirmarContrasea.setBounds(10, 126, 167, 14);
		panel.add(lblConfirmarContrasea);

		JLabel lblTipoDeUsuario = new JLabel("Tipo de Usuario:");
		lblTipoDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipoDeUsuario.setBounds(10, 170, 167, 14);
		panel.add(lblTipoDeUsuario);

		JComboBox cmbxTipoDeUsuario = new JComboBox();
		cmbxTipoDeUsuario.setModel(new DefaultComboBoxModel(new String[] { "admin", "Anotador" }));
		cmbxTipoDeUsuario.setBounds(125, 169, 289, 20);
		panel.add(cmbxTipoDeUsuario);

		JButton btnRegistrarUsuario = new JButton("Registrar Usuario");
		btnRegistrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = "", pass = "", tipo = "",aux;
				usuario = txtUsuario.getText();
				if (String.valueOf(txtPassword.getPassword()).equals(String.valueOf(txtPassConfirmar.getPassword()))) {
					pass = String.valueOf(txtPassword.getPassword());
					System.out.println("try");
				}
				tipo = cmbxTipoDeUsuario.getSelectedItem().toString();
				
				if (usuario == "" || pass.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ha dejado campos vacíos.", "Aviso",JOptionPane.WARNING_MESSAGE);
				} else {
					if(!servidor.getUsuarios().contains(usuario)) {
						servidor.getUsuarios().add(usuario);
						servidor.getPasswords().add(pass);
						servidor.getTipodeuser().add(tipo);
						servidor.guardardatos();
						JOptionPane.showMessageDialog(null, "Usuario registrado con exito.", "Aviso",JOptionPane.WARNING_MESSAGE);
						txtUsuario.setText("");
						txtPassword.setText("");
						txtPassConfirmar.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Usuario ya existe.", "Aviso",JOptionPane.WARNING_MESSAGE);
						txtUsuario.setText("");
						txtPassword.setText("");
						txtPassConfirmar.setText("");
					}
				}
			}
		});
		btnRegistrarUsuario.setBounds(139, 200, 146, 23);
		panel.add(btnRegistrarUsuario);
	}
}
