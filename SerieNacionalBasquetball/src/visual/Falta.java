package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Jugador;
import logica.SerieNacional;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Falta extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		try {
			Falta dialog = new Falta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Falta(String nombre,Jugador jugador, SerieNacional serie,String codigoEQseleccionado) {
		setTitle("Confirmar Falta");
		setBounds(100, 100, 524, 187);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDeseaConfirmarFalta = new JLabel("Desea confirmar falta del jugador: "+nombre+"?");
			lblDeseaConfirmarFalta.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblDeseaConfirmarFalta.setBounds(10, 14, 488, 88);
			contentPanel.add(lblDeseaConfirmarFalta);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						serie.getEquipos().get(serie.indiceDeEquipo(codigoEQseleccionado)).getJugadores().get(serie.getEquipos().get(serie.indiceDeEquipo(codigoEQseleccionado)).indiceDeJugador(jugador.getCodigo())).setCantfaltas(jugador.getCantfaltas()+1);
						dispose();
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
