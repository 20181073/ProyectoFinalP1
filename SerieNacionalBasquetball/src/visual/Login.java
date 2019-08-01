package visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import visual.Principal;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private String HOST="127.0.0.1";
	private int PUERTO = 5110;
	private Socket SckCliente;
    private DataInputStream dis;
    private DataOutputStream dos;
	
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
	

	public Login() {
		
		try {
			
			SckCliente =new Socket(HOST,PUERTO);
			System.out.println("Conectado al servidor");
			dos= new DataOutputStream(SckCliente.getOutputStream());
			dis = new DataInputStream(SckCliente.getInputStream());
		
		}catch(IOException e1) {
			System.out.println("Error: "+e1);
			dispose();
		} 
		
		
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
				String user, pass,confirmacion;
				user = txtUsuario.getText();
				pass = String.valueOf(passwordField.getPassword());
				
				if(user.isEmpty() || pass.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ha dejado campos vacíos.","Aviso",JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
						dos.writeUTF(user);
						dos.writeUTF(pass);
						confirmacion=dis.readUTF();
						if (confirmacion.equals("Permiso Consedido")) {
							System.out.println(":"+confirmacion+":");
							Principal ventana = new Principal(dis.readUTF());
							ventana.setVisible(true);
							dis.close();
							dos.close();
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Usuario o contraseña incorreta.","Aviso",JOptionPane.WARNING_MESSAGE);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.println("Error de comunicacion con el servidor :"+e1);
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.setBounds(126, 353, 89, 23);
		panel.add(btnEntrar);
	
	}

}
