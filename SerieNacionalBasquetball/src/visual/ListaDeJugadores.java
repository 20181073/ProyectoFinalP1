package visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logica.SerieNacional;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaDeJugadores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaDeJugadores frame = new ListaDeJugadores();
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
	public ListaDeJugadores() {
		setResizable(false);
		setTitle("Jugadores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 691, 307);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 685, 204);
		contentPane.add(scrollPane);
		
		table = new JTable();
		Object[][] info= new Object[SerieNacional.getInstancia().cantidadDeJugadoresTotales()][6];
		for(int i = 0, aux=0; i<SerieNacional.getInstancia().getEquipos().size();i++) {
		
			for(int a =0; a < SerieNacional.getInstancia().getEquipos().get(i).getJugadores().size();a++,aux++) {
				
				info[aux][0]=SerieNacional.getInstancia().getEquipos().get(i).getJugadores().get(a).getCodigo();
				info[aux][1]=SerieNacional.getInstancia().getEquipos().get(i).getJugadores().get(a).getNombre();
				info[aux][2]=SerieNacional.getInstancia().getEquipos().get(i).getJugadores().get(a).getNumeroCamiseta();
				info[aux][3]=SerieNacional.getInstancia().getEquipos().get(i).getJugadores().get(a).getCantlesiones();
				info[aux][4]=SerieNacional.getInstancia().getEquipos().get(i).getNombre();
				info[aux][5]=SerieNacional.getInstancia().getEquipos().get(i).getJugadores().get(a).getDesempeño();			
				
			}
		
		}
		table.setModel(new DefaultTableModel(
			info,
			new String[] {
				"Codigo", "Nombre", "Numero de Camiseta", "Lesiones totales", "Equipo", "Posicion"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(111);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(108);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JButton btnVerLesiones = new JButton("Ver lesiones");
		btnVerLesiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedColumn()>-1 && table.getValueAt(table.getSelectedRow(), 0).equals("")==false) {
					
					ListaDeLesiones ventana = new ListaDeLesiones(SerieNacional.getInstancia().getEquipos().
							get(SerieNacional.getInstancia().indiceDeEquipo(table.getValueAt(table.getSelectedRow(),4).
								toString())).getJugadores().get(SerieNacional.getInstancia().getEquipos().
										get(SerieNacional.getInstancia().indiceDeEquipo(table.getValueAt(table.getSelectedRow(), 4).
										toString())).indiceDeJugador(table.getValueAt(table.getSelectedRow(), 0).toString())),
											SerieNacional.getInstancia(),SerieNacional.getInstancia().
												equipodeljugador(table.getValueAt(table.getSelectedRow(), 0).toString()));
					ventana.setVisible(true);
					
				}
				
			}
		}); 
		btnVerLesiones.setBounds(280, 235, 122, 23);
		contentPane.add(btnVerLesiones);
		
		JButton btnEliminarJugador = new JButton("Eliminar jugador");
		btnEliminarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedColumn()>-1 && table.getValueAt(table.getSelectedRow(), 0).equals("")==false) {
//					if(table.getValueAt(table.getSelectedRow(), 4).equals("")) {
//						serie.getJugadores().remove(serie.indiceDeJugador(table.getValueAt(table.getSelectedRow(), 0).toString()));
//						serie.setCantidadJugadores(serie.getCantidadJugadores()-1);
//					}else {
					SerieNacional.getInstancia().getEquipos().get(SerieNacional.getInstancia().indiceDeEquipo(table.getValueAt(table.getSelectedRow(), 4).toString())).getJugadores().remove(SerieNacional.getInstancia().getEquipos().
							get(SerieNacional.getInstancia().indiceDeEquipo(table.getValueAt(table.getSelectedRow(), 4).
							toString())).indiceDeJugador(table.getValueAt(table.getSelectedRow(), 0).toString()));
//						serie.setCantidadJugadores(serie.getCantidadJugadores()-1);
//					}
				}
			} 
		}); 
		btnEliminarJugador.setBounds(79, 235, 122, 23); 
		contentPane.add(btnEliminarJugador);
		
		JButton btnAgregarJugador = new JButton("Agregar Jugador");
		btnAgregarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregarJugador.setBounds(481, 235, 122, 23);
		contentPane.add(btnAgregarJugador);
	}
}
