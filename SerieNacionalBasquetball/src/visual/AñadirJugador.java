package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import logica.Equipo;
import logica.Jugador;
import logica.SerieNacional;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;

public class AñadirJugador extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	private JTextField txtNombreJugador;
	private JTextField txtPeso;
	private JTextField txtEstatura;
	private JComboBox<String> cbxPosicion;
	private JComboBox<String> cbxEquipo;
	private JSpinner spnNumero;
	private JButton btnRegistrar;
	//private JLabel lblError;
	
	private int ubica = 1;
	private boolean noponer = true;
	//private int index;

	public AñadirJugador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AñadirJugador.class.getResource("/imagenes/IconoPrincipal.png")));
		//this.index = index;
		setTitle("Registrar jugador");
		setResizable(false);
		setBounds(100, 100, 379, 235);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n del jugador:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JLabel lblNombreDelJugador = new JLabel("Nombre:");
			lblNombreDelJugador.setBounds(10, 27, 62, 14);
			panel.add(lblNombreDelJugador);
		}
		{
			txtNombreJugador = new JTextField();
			txtNombreJugador.setColumns(10);
			txtNombreJugador.setBounds(76, 24, 276, 20);
			panel.add(txtNombreJugador);
			
		}
		{
			JLabel lblPeso = new JLabel("Peso (Kg):");
			lblPeso.setBounds(10, 76, 62, 14);
			panel.add(lblPeso);
		}
		{
			txtPeso = new JTextField();
			txtPeso.setBounds(76, 73, 62, 20);
			panel.add(txtPeso);
			txtPeso.setColumns(10);
		}
		{
			JLabel lblPosicin = new JLabel("Posici\u00F3n:");
			lblPosicin.setBounds(148, 101, 54, 14);
			panel.add(lblPosicin);
		}
		{
			txtEstatura = new JTextField();
			txtEstatura.setBounds(237, 73, 115, 20);
			panel.add(txtEstatura);
			txtEstatura.setColumns(10);
		}
		{
			JLabel lblEstatura = new JLabel("Estatura (m):");
			lblEstatura.setBounds(148, 76, 86, 14);
			panel.add(lblEstatura);
		}
		{
			JLabel lblNmero = new JLabel("N\u00FAmero:");
			lblNmero.setBounds(10, 101, 54, 14);
			panel.add(lblNmero);
		}
		
		spnNumero = new JSpinner();
		spnNumero.setModel(new SpinnerNumberModel(1, 1, 99, 1));
		spnNumero.setBounds(76, 98, 62, 20);
		panel.add(spnNumero);
		
		cbxPosicion = new JComboBox<String>();
		cbxPosicion.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Base" , "Escolta", "Alero" ,"Ala-Pivot", "Pivot"} ) );
		cbxPosicion.setBounds(237, 98, 115, 20);
		panel.add(cbxPosicion);
		
		JLabel lblEquipo = new JLabel("Equipo:");
		lblEquipo.setBounds(10, 129, 62, 14);
		panel.add(lblEquipo);
		
		cbxEquipo = new JComboBox<String>();
		//cbxEquipo.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>"}));
		//String[] cbxEqui = {"<Seleccione>"};
		cbxEquipo.setBounds(76, 126, 158, 20);
		panel.add(cbxEquipo);
		{
			JLabel lblError = new JLabel("");
			lblError.setHorizontalAlignment(SwingConstants.LEFT);
			lblError.setForeground(Color.RED);
			lblError.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblError.setBounds(76, 45, 176, 20);
			panel.add(lblError);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnRegistrar = new JButton("Registrar");
			buttonPane.add(btnRegistrar);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnCancelar.setActionCommand("Cancel");
			buttonPane.add(btnCancelar);
			
		}
		
		txtPeso.addKeyListener(new KeyAdapter() {
			@Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (ubica!=1) {
		          ubica=1;
		          noponer=true;
		        }
		        if (!Character.isDigit(c) && (!(c==46) || noponer!=true)) {
		          e.consume();
		        }
		        if ((c==46)) {
		          noponer=false;
		        }
		      }
		});
		
		txtEstatura.addKeyListener(new KeyAdapter() {
		      @Override
		      public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (ubica!=2) {
		          ubica=2;
		          noponer=true;
		        }
		        if (!Character.isDigit(c) && (!(c==46) || noponer!=true)) {
		          e.consume();
		        }
		        if ((c==46)) {
		          noponer=false;
		        }
		      }
		    });
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ready = false;
				String nombreJugador = txtNombreJugador.getText();
				
				float peso = 0;
				if(!txtPeso.getText().equalsIgnoreCase("")){
					peso = (float) Double.parseDouble(txtPeso.getText());
					ready = true;
				}else {
					ready = false;
				}
									
				float estatura = 0;
				if(!txtEstatura.getText().equalsIgnoreCase("")) {
					estatura = (float) Double.parseDouble(txtEstatura.getText());
					ready = true;
				}else {
					ready = false;
				}
				
				String posicion = cbxPosicion.getSelectedItem().toString();
				String equipo = cbxEquipo.getSelectedItem().toString();
				
				Equipo MiEquipo = SerieNacional.getInstancia().buscarequipoByName(equipo);
				
				int numero = Integer.parseInt(spnNumero.getValue().toString());
				
				if(!nombreJugador.equalsIgnoreCase("") && !posicion.equalsIgnoreCase("<Seleccione>") && !equipo.equalsIgnoreCase("") && ready && !checkNumero(numero)) {
					Jugador aux = new Jugador(nombreJugador, peso, estatura, posicion, numero, MiEquipo );
					SerieNacional.getInstancia().getEquipos().get(cbxEquipo.getSelectedIndex()).getJugadores().add(aux);
					SerieNacional.getInstancia().Guardar(SerieNacional.getInstancia());
					JOptionPane.showMessageDialog(null, "Registro del jugador exitoso.", "Información", JOptionPane.INFORMATION_MESSAGE);
					//dispose();
					
					txtNombreJugador.setText("");
					txtEstatura.setText("");
					txtPeso.setText("");
					spnNumero.setValue(1);
					cbxPosicion.setSelectedIndex(0);
					cbxEquipo.setSelectedIndex(0);
					
				}else if(checkNumero(numero)) {
					JOptionPane.showMessageDialog(null, "El número del jugador ya está en uso.", "Revise los campos", JOptionPane.WARNING_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Llene correctamente los campos.", "Revise los campos", JOptionPane.WARNING_MESSAGE);
				}
			}

			private boolean checkNumero(int numero) {
				boolean encontrado = false;
				
				for (Jugador player : SerieNacional.getInstancia().getEquipos().get(cbxEquipo.getSelectedIndex()).getJugadores()) {
					if(player.getNumeroCamiseta() == numero) {
						encontrado = true;
					}
				}
				
				return encontrado;
			}
		});
		loadEquipo();
	}
	private void loadEquipo() {
		cbxEquipo.removeAllItems();
		for (int i = 0; i < SerieNacional.getInstancia().getEquipos().size(); i++) {
			cbxEquipo.addItem(new String(SerieNacional.getInstancia().getEquipos().get(i).getNombre()));
		}
		//cbxEquipo.insertItemAt(new String("<Seleccione>"), 0);
		cbxEquipo.setSelectedIndex(0);
		
	}
}