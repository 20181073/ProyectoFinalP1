package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import logica.Equipo;
import logica.Jugador;
import logica.Lesion;
import logica.SerieNacional;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class LesionarJugador extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		try {
			LesionarJugador dialog = new LesionarJugador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LesionarJugador(Jugador jugador, SerieNacional serie,Equipo equipo) {
		
		setTitle("Lesiones");
		setBounds(100, 100, 481, 280);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 445, 180);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblTipoDeLesion = new JLabel("Tipo de Lesion");
		lblTipoDeLesion.setBounds(25, 97, 112, 14);
		panel.add(lblTipoDeLesion);
		
		JLabel lblTiempoDeRecuperacion = new JLabel("Tiempo de Recuperacion");
		lblTiempoDeRecuperacion.setBounds(284, 97, 134, 14);
		panel.add(lblTiempoDeRecuperacion);
		
		JComboBox<String> cmbxTipoDeLesion = new JComboBox<String>();
		cmbxTipoDeLesion.setModel(new DefaultComboBoxModel<String>(new String[] {"Ruptura", "Torcedura"}));
		cmbxTipoDeLesion.setBounds(25, 122, 112, 20);
		panel.add(cmbxTipoDeLesion);
		
		JSpinner spnDiasDeRecuperacion = new JSpinner();
		spnDiasDeRecuperacion.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnDiasDeRecuperacion.setBounds(284, 122, 134, 20);
		panel.add(spnDiasDeRecuperacion);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(25, 11, 46, 14);
		panel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(25, 36, 119, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblFehcaDeLesion = new JLabel("Fehca De Lesion");
		lblFehcaDeLesion.setBounds(284, 11, 112, 14);
		panel.add(lblFehcaDeLesion);
		
		JSpinner spnFechaDeLesion = new JSpinner();
		spnFechaDeLesion.setModel(new SpinnerDateModel(new Date(1563336000000L), new Date(949204800000L), new Date(1563336000000L), Calendar.DAY_OF_MONTH));
		spnFechaDeLesion.setBounds(284, 36, 134, 20);
		panel.add(spnFechaDeLesion);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(equipo == null) {
							serie.getJugadores().get(serie.indiceDeJugador(jugador.getCodigo())).getLesiones().add(new Lesion(txtCodigo.getText(),cmbxTipoDeLesion.getSelectedItem().toString(),true,(Date)spnFechaDeLesion.getValue(),Integer.parseInt(spnDiasDeRecuperacion.getValue().toString())));
							serie.getJugadores().get(serie.indiceDeJugador(jugador.getCodigo())).setCantlesiones(serie.getJugadores().get(serie.indiceDeJugador(jugador.getCodigo())).getCantlesiones()+1);
						}else {
							serie.getEquipos().get(serie.indiceDeEquipo(equipo.getCodigo())).getJugadores().get(equipo.indiceDeJugador(jugador.getCodigo())).getLesiones().add(new Lesion(txtCodigo.getText(),cmbxTipoDeLesion.getSelectedItem().toString(),true,(Date)spnFechaDeLesion.getValue(),Integer.parseInt(spnDiasDeRecuperacion.getValue().toString())));
							serie.getEquipos().get(serie.indiceDeEquipo(equipo.getCodigo())).getJugadores().get(equipo.indiceDeJugador(jugador.getCodigo())).setCantlesiones(serie.getEquipos().get(serie.indiceDeEquipo(equipo.getCodigo())).getJugadores().get(equipo.indiceDeJugador(jugador.getCodigo())).getCantlesiones()+1);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
