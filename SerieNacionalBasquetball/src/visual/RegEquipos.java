package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import javax.swing.filechooser.FileNameExtensionFilter;

import logica.SerieNacional;
import logica.Equipo;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.awt.Image;
import java.awt.event.KeyAdapter;

public class RegEquipos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JLabel lblError;
	private File ficheroLogo = null;

	public RegEquipos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegEquipos.class.getResource("/imagenes/IconoPrincipal.png")));
		setResizable(false);
		setTitle("Registrar Equipo");
		setBounds(100, 100, 549, 375);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 523, 287);
		contentPanel.add(panel);
		panel.setLayout(null);

		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				escribirSoloLetrasYEspacios(e, lblError);
			}
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(45, 139, 176, 20);
		panel.add(txtNombre);

		JLabel lblNombre = new JLabel("Nombre del equipo");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombre.setBounds(45, 105, 176, 23);
		panel.add(lblNombre);

		JLabel lblLogo = new JLabel("IMAGEN");
		lblLogo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblLogo.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(277, 11, 236, 235);
		panel.add(lblLogo);

		JButton btnSeleccionarImagen = new JButton("Cargar imagen");
		btnSeleccionarImagen.setIcon(null);
		btnSeleccionarImagen.setSelectedIcon(null);
		btnSeleccionarImagen.setBounds(277, 253, 236, 23);
		panel.add(btnSeleccionarImagen);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setHorizontalAlignment(SwingConstants.LEFT);
		lblError.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblError.setBounds(45, 170, 176, 23);
		panel.add(lblError);

		JPanel Panel_Inferior = new JPanel();
		Panel_Inferior.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Panel_Inferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(Panel_Inferior, BorderLayout.SOUTH);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setActionCommand("OK");
		Panel_Inferior.add(btnRegistrar);
		getRootPane().setDefaultButton(btnRegistrar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setActionCommand("Cancel");
		Panel_Inferior.add(btnCancelar);
		
		btnSeleccionarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resultado = 0;
				CargarImagen ventana = new CargarImagen();
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG", "jpg");
				ventana.fileChooser.setFileFilter(filtro);
				resultado = ventana.fileChooser.showOpenDialog(null);
				
				if( JFileChooser.APPROVE_OPTION == resultado ) {
					ficheroLogo = ventana.fileChooser.getSelectedFile();
					try {
						ImageIcon imagenfichero = new ImageIcon( ficheroLogo.toString() );
						Icon icono = new ImageIcon( imagenfichero.getImage().getScaledInstance(lblLogo.getWidth(), 
								lblLogo.getHeight(), Image.SCALE_DEFAULT));
						lblLogo.setText(null);
						lblLogo.setIcon(icono);
						
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Error al abrir la imagen" + ex);
					}
				}
			}
		});
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreEquipo = txtNombre.getText();
				
				if( !nombreEquipo.equalsIgnoreCase("") && !validarSiExisteEquipo(nombreEquipo) && lblLogo.getText() == null ) {
					Equipo aux = new Equipo(nombreEquipo, ficheroLogo );
					
					try {
						aux.guardarLogo();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					SerieNacional.getInstancia().getEquipos().add(aux);
					SerieNacional.getInstancia().Guardar(SerieNacional.getInstancia());
					JOptionPane.showMessageDialog(null, "Registro de equipo exitoso", "Aviso", JOptionPane.INFORMATION_MESSAGE);

					txtNombre.setText("");
					lblLogo.setIcon(null);
					lblLogo.setText("IMAGEN");
					ficheroLogo = null;
				
				}else if(validarSiExisteEquipo(nombreEquipo)) {
					JOptionPane.showMessageDialog(null, "Ya existe un equipo con el mismo nombre.", "Revise los campos", JOptionPane.WARNING_MESSAGE);
				}else if( !nombreEquipo.equalsIgnoreCase("") && lblLogo.getText() == null ) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una imagen.", "Revise la imagen", JOptionPane.WARNING_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Llene correctamente los campos.", "Revise los campos", JOptionPane.WARNING_MESSAGE);
				}
			}
			
			private boolean validarSiExisteEquipo(String nombreEquipo) {
				boolean encontrado = false;
				
				for (Equipo team : SerieNacional.getInstancia().getEquipos() ) {
					if(team.getNombre().equalsIgnoreCase(nombreEquipo)) {
						encontrado = true;
					}
				}
				return encontrado;
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
	/**
	 * Restringe el texto solo a letras y espacios. Escribe el aviso en el JLabel pasado.
	 * @param evt Evento
	 * @param etiquetaError JLabel donde se imprime el error  
	 */
	public static void escribirSoloLetrasYEspacios(KeyEvent evt, JLabel etiquetaError){
	    if(!Character.isLetter(evt.getKeyChar()) &&!(evt.getKeyChar()==KeyEvent.VK_SPACE) && 
	    		!(evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)){
	        evt.consume();
	        etiquetaError.setText("Escribe solo letras");
	    }else{
	        etiquetaError.setText("");
	    }
	}
}
