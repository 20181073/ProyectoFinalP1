package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logica.Jugador;
import logica.SerieNacional;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegEquipos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTable TablaJugadores;
	private JTable TablaJugadoresSeleccionados;
	//private static DefaultTableModel model;
	//private String identificador = "";
	//private static Object[] fila;
	//private ArrayList<Jugador> jugadores = new ArrayList<>();

	/*
	public static void main(String[] args) {
		try {
			RegEquipos dialog = new RegEquipos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/

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
		txtNombre.setBounds(101, 30, 135, 20);
		panel.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNombre.setBounds(0, 33, 91, 14);
		panel.add(lblNombre);
		
		JPanel panel_JugadoresSinEquipo = new JPanel();
		panel_JugadoresSinEquipo.setBorder(null);
		panel_JugadoresSinEquipo.setBounds(256, 30, 230, 350);
		panel.add(panel_JugadoresSinEquipo);
		panel_JugadoresSinEquipo.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 230, 350);
		panel_JugadoresSinEquipo.add(scrollPane);
		
		TablaJugadores = new JTable();
		Object[][] JugadoresHelper =new Object[SerieNacional.getInstancia().getCantidadJugadores()][3];
		int auxcountJ=0;
		for(int i =0; i<SerieNacional.getInstancia().getCantidadJugadores();i++,auxcountJ++) {
			
			JugadoresHelper[auxcountJ][0]=SerieNacional.getInstancia().getJugadores().get(i).getNombre();
			JugadoresHelper[auxcountJ][1]=SerieNacional.getInstancia().getJugadores().get(i).getDesempeño();
			JugadoresHelper[auxcountJ][2]=SerieNacional.getInstancia().getJugadores().get(i).getPtsTotalCarrera();
			
		}		
		TablaJugadores.setModel(new DefaultTableModel(
				JugadoresHelper,
			new String[] {
				"Nombre", "Desempeño", "PtsTotal"
			}
		));
		TablaJugadores.setFillsViewportHeight(true);
		scrollPane.setViewportView(TablaJugadores);

		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblLogo.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(10, 96, 236, 230);
		panel.add(lblLogo);
		
		JLabel lblJugadoresSinEquipo = new JLabel("Jugadores sin equipos");
		lblJugadoresSinEquipo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblJugadoresSinEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadoresSinEquipo.setBounds(256, 0, 230, 29);
		panel.add(lblJugadoresSinEquipo);
		
		JButton btnDerecha = new JButton(">>>");
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				if(helper.existequeso(TablaQueso.getValueAt(TablaQueso.getSelectedRow(), 1).toString())==true) {
					System.out.println("Este queso ya fue seleccionado");
				}else {
					helper.getQuesos().add(complejo.BuscarQuesoBycode(TablaQueso.getValueAt(TablaQueso.getSelectedRow(), 1).toString()));
					helper.setCantqueso(helper.getCantqueso()+1);
					
					labelpreciototal.setText(Double.toString(helper.preciototal()));
					int auxcountQuesoSeleccionado=0;
					for(int i =0; i<helper.getCantqueso();i++,auxcountQuesoSeleccionado++) {
						if(complejo.getQuesos().get(i)instanceof Esferico) {
							QuesoHelperSelecionado[auxcountQuesoSeleccionado][0]="Queso Esferico";
						}
						if(complejo.getQuesos().get(i)instanceof Cilindrico) { 
							QuesoHelperSelecionado[auxcountQuesoSeleccionado][0]="Queso Cilindrico";
						}
						if(complejo.getQuesos().get(i)instanceof CilindricoHueco) { 
							QuesoHelperSelecionado[auxcountQuesoSeleccionado][0]="Queso Cilindrico con Hueco";
						}
						QuesoHelperSelecionado[auxcountQuesoSeleccionado][1]=helper.getQuesos().get(i).volumen();
						QuesoHelperSelecionado[auxcountQuesoSeleccionado][2]=helper.getQuesos().get(i).preciototal();
						
						
						
					}
					tableQuesoSeleccionado.setModel(new DefaultTableModel(
							QuesoHelperSelecionado,
						new String[] {
							"Tipo", "Volumen", "Precio"
						}
					));
				}
				*/
			}
		});
		btnDerecha.setBounds(496, 121, 58, 23);
		panel.add(btnDerecha);
		
		JButton btnIzquierda = new JButton("<<<");
		btnIzquierda.setBounds(496, 259, 58, 23);
		panel.add(btnIzquierda);
		
		JButton btnSeleccionarImagen = new JButton("Cargar imagen");
		btnSeleccionarImagen.setIcon(null);
		btnSeleccionarImagen.setSelectedIcon(null);
		btnSeleccionarImagen.setBounds(10, 337, 236, 23);
		panel.add(btnSeleccionarImagen);
		
		JButton btnRegistrarJugador = new JButton("Registrar jugador");
		btnRegistrarJugador.setBounds(62, 62, 135, 23);
		panel.add(btnRegistrarJugador);
		
		JPanel panel_JugadoresSeleccionados = new JPanel();
		panel_JugadoresSeleccionados.setLayout(null);
		panel_JugadoresSeleccionados.setBorder(null);
		panel_JugadoresSeleccionados.setBounds(564, 11, 230, 369);
		panel.add(panel_JugadoresSeleccionados);

		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 230, 369);
		panel_JugadoresSeleccionados.add(scrollPane_1);
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
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				Panel_Inferior.add(btnCancelar);
			}
		}
	}
}
