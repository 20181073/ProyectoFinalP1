package visual;

import java.awt.BorderLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class CargarImagen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JFileChooser fileChooser;
	

	public CargarImagen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CargarImagen.class.getResource("/imagenes/IconoPrincipal.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 420);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		fileChooser = new JFileChooser();
		getContentPane().add(fileChooser, BorderLayout.CENTER);
		
	}

}
