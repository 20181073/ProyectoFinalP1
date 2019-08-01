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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaDeJugadores.class.getResource("/imagenes/IconoPrincipal.png")));
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
		table.setFillsViewportHeight(true);
		CargarTabla();
		scrollPane.setViewportView(table);
		
		JButton btnVerLesiones = new JButton("Ver lesiones");
		btnVerLesiones.setEnabled(false);
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
		btnVerLesiones.setBounds(208, 235, 122, 23);
		contentPane.add(btnVerLesiones);
		
		JButton btnEliminarJugador = new JButton("Eliminar jugador");
		btnEliminarJugador.setEnabled(false);
		btnEliminarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedColumn()>-1 && table.getValueAt(table.getSelectedRow(), 0).equals("")==false) {
					
					SerieNacional.getInstancia().getEquipos().get(SerieNacional.getInstancia().indiceDeEquipo(table.getValueAt(table.getSelectedRow(), 4).toString())).getJugadores().remove(SerieNacional.getInstancia().getEquipos().get(SerieNacional.getInstancia().indiceDeEquipo(table.getValueAt(table.getSelectedRow(), 4).toString())).indiceDeJugador(table.getValueAt(table.getSelectedRow(), 0).toString()));
				
					CargarTabla();
				}
			} 
		}); 
		btnEliminarJugador.setBounds(43, 235, 122, 23); 
		contentPane.add(btnEliminarJugador);
		
		JButton btnAgregarJugador = new JButton("Agregar Jugador");
		btnAgregarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirJugador a = new AñadirJugador();
				a.setModal(true);
				a.setVisible(true);
				CargarTabla();
			}
		});
		btnAgregarJugador.setBounds(375, 235, 122, 23);
		contentPane.add(btnAgregarJugador);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(540, 235, 122, 23);
		contentPane.add(btnSalir);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow()>=0){
					btnVerLesiones.setEnabled(true);
					btnEliminarJugador.setEnabled(true);
				}
				else {
					btnVerLesiones.setEnabled(false);
					btnEliminarJugador.setEnabled(false);
				}
			}
		});
	}
	private void CargarTabla() {
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
				 "Código", "Nombre", "Numero de Camiseta", "Lesiones totales", "Equipo", "Posicion"
			}
		));
	}
}
