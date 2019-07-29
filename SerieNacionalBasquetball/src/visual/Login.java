package visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	public Login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setBackground(new Color(255, 69, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imagenes/IconoPrincipal.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 380, 456);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 102, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 354, 405);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(41, 242, 265, 20);
		panel.add(txtUsuario);
		
		JLabel label = new JLabel("Contrase\u00F1a:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(41, 273, 173, 30);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(41, 201, 173, 30);
		panel.add(label_1);
	
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(41, 305, 265, 20);
		passwordField.setColumns(10);
		panel.add(passwordField);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Login.class.getResource("/imagenes/if_user_173122.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(85, 52, 173, 160);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Iniciar Sesi\u00F3n");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(85, 11, 173, 30);
		panel.add(label_3);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user, pass;
				user = txtUsuario.getText();
				pass = String.valueOf(passwordField.getPassword());
				
				if(user.isEmpty() || pass.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ha dejado campos vacíos.","Aviso",JOptionPane.WARNING_MESSAGE);
				}
				else if(user.contentEquals("admin")  && pass.contentEquals("admin")){
					JOptionPane.showMessageDialog(null, "Sesión iniciada con éxito.","Información",JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "El usuario o contraseña es incorrecto.","Aviso",JOptionPane.WARNING_MESSAGE);
					JOptionPane.showMessageDialog(null, "User: "+user+"Pass: "+pass,"Aviso",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.setBounds(126, 353, 89, 23);
		panel.add(btnEntrar);
	}

}
