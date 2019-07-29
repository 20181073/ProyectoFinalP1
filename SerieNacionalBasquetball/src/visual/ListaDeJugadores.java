package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
	public ListaDeJugadores(SerieNacional serie) {
		setResizable(false);
		setTitle("Jugadores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 691, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 685, 204);
		contentPane.add(scrollPane);
		
		table = new JTable();
		Object[][] info= new Object[serie.cantidadDeJugadoresTotales()][7];
		for(int i = 0, aux=0; i<serie.getCantidadEquipos();i++) {
		
			for(int a =0; a < serie.getEquipos().get(i).getCantjugador();a++,aux++) {
				
				info[aux][0]=serie.getEquipos().get(i).getJugadores().get(a).getCodigo();
				info[aux][1]=serie.getEquipos().get(i).getJugadores().get(a).getNombre();
				info[aux][2]=serie.getEquipos().get(i).getJugadores().get(a).getNumeroCamiseta();
				info[aux][3]=serie.getEquipos().get(i).getJugadores().get(a).getCantlesiones();
				info[aux][4]=serie.getEquipos().get(i).getNombre();
				info[aux][5]=serie.getEquipos().get(i).getCodigo();
				info[aux][6]=serie.getEquipos().get(i).getJugadores().get(a).getDesempeño();			
				
			}
		
		}
		table.setModel(new DefaultTableModel(
			info,
			new String[] {
				"Codigo", "Nombre", "Numero de Camiseta", "Lesiones totales", "Equipo", "Codigo del equipo", "Posicion"
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
					
					ListaDeLesiones ventana = new ListaDeLesiones(serie.getEquipos().get(serie.indiceDeEquipo(table.getValueAt(table.getSelectedRow(), 5).toString())).getJugadores().get(serie.getEquipos().get(serie.indiceDeEquipo(table.getValueAt(table.getSelectedRow(), 5).toString())).indiceDeJugador(table.getValueAt(table.getSelectedRow(), 0).toString())),serie,serie.equipodeljugador(table.getValueAt(table.getSelectedRow(), 0).toString()));
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
//					if(table.getValueAt(table.getSelectedRow(), 5).equals("")) {
//						serie.getJugadores().remove(serie.indiceDeJugador(table.getValueAt(table.getSelectedRow(), 0).toString()));
//						serie.setCantidadJugadores(serie.getCantidadJugadores()-1);
//					}else {
//						serie.getEquipos().get(serie.indiceDeEquipo(table.getValueAt(table.getSelectedRow(), 5).toString())).getJugadores().remove(serie.indiceDeJugador(table.getValueAt(table.getSelectedRow(), 0).toString()));
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
