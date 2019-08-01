package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logica.Equipo;
import logica.Juego;
import logica.SerieNacional;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaDeJuegos extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaDeJuegos frame = new ListaDeJuegos();
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
	public ListaDeJuegos(SerieNacional serie) {
		setTitle("Juegos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 691, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 685, 204);
		contentPane.add(scrollPane);
		
		table = new JTable();
		Object[][] info= new Object[serie.getJuegos().size()][6];
		for(int i =0; i < serie.getJuegos().size();i++) {
			
			info[i][0]=serie.getJuegos().get(i).getCodigo();
		
			info[i][1]=serie.getJuegos().get(i).getEstado();
			
			info[i][2]=serie.getJuegos().get(i).getFechaDelJuego();
			if(serie.getJuegos().get(i).getPtsEquipo1()>serie.getJuegos().get(i).getPtsEquipo2()) {
				info[i][3]=serie.getJuegos().get(i).getEquipos().get(0).getNombre();
			}
			if(serie.getJuegos().get(i).getPtsEquipo1()<serie.getJuegos().get(i).getPtsEquipo2()) {
				info[i][3]=serie.getJuegos().get(i).getEquipos().get(1).getNombre();
			}
			info[i][4]=serie.getJuegos().get(i).getEquipos().get(1).getNombre();
			info[i][6]=serie.getJuegos().get(i).getEquipos().get(0).getNombre();			
			
		}
		table.setModel(new DefaultTableModel(
			info,
			new String[] {
				"Codigo del Juego", "Estado", "Fecha", "Ganador", "Equipo Visitante" , "Equipo local" 
			}
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(110);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JButton btnSimular = new JButton("Simular");
		btnSimular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedColumn()>-1) {
					SimulacionJuego ventana=new SimulacionJuego(  serie,  table.getValueAt(table.getSelectedRow(), 7).toString(), table.getValueAt(table.getSelectedRow(), 5).toString(),  serie.getEquipos().get(serie.indiceDeEquipo(table.getValueAt(table.getSelectedRow(), 7).toString())), serie.getEquipos().get(serie.indiceDeEquipo(table.getValueAt(table.getSelectedRow(), 5).toString())), serie.getJuegos().get(serie.indiceDeJuego(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()))),"Juego comun");
					ventana.setVisible(true);
					dispose();
				}

			}
		});
		btnSimular.setBounds(448, 228, 89, 23);
		contentPane.add(btnSimular);
		
		JButton btnEliminarJuego = new JButton("Eliminar Juego");
		btnEliminarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedColumn()>-1) {
					serie.getJuegos().remove(serie.indiceDeJuego(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString())));
					
					if(serie.getJuegos().size()>0) {
						for(int i =0; i < serie.getJuegos().size();i++) {
							
							info[i][0]=serie.getJuegos().get(i).getCodigo();
						
							info[i][1]=serie.getJuegos().get(i).getEstado();
							
							info[i][2]=serie.getJuegos().get(i).getFechaDelJuego();
							if(serie.getJuegos().get(i).getPtsEquipo1()>serie.getJuegos().get(i).getPtsEquipo2()) {
								info[i][3]=serie.getJuegos().get(i).getEquipos().get(0).getNombre();
							}
							if(serie.getJuegos().get(i).getPtsEquipo1()<serie.getJuegos().get(i).getPtsEquipo2()) {
								info[i][3]=serie.getJuegos().get(i).getEquipos().get(1).getNombre();
							}
							info[i][4]=serie.getJuegos().get(i).getEquipos().get(1).getNombre();
							
							info[i][5]=serie.getJuegos().get(i).getEquipos().get(0).getNombre();
							
							
							
							
							
						}
						table.setModel(new DefaultTableModel(
							info,
							new String[] {
								"Codigo del Juego", "Estado", "Fecha", "Ganador", "Equipo Visitante", "Equipo local" 
							}
						));
					}else {
						table.setModel(new DefaultTableModel(
								new Object[][]{
									null,null,null,null,null,null
								}, 
								new String[] {
									"Codigo del Juego", "Estado", "Fecha", "Ganador", "Equipo Visitante", "Equipo local"
								}
						));
						dispose();
					}
					
				}
			}
		});
		btnEliminarJuego.setBounds(547, 228, 118, 23);
		contentPane.add(btnEliminarJuego);
	}

}
