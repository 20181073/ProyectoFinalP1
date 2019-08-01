package visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logica.Equipo;
import logica.Jugador;
import logica.SerieNacional;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaDeLesiones extends JFrame {

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
					ListaDeLesiones frame = new ListaDeLesiones();
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
	public ListaDeLesiones(Jugador jugador,SerieNacional serie,Equipo equipo) {
		setTitle("Lesiones del jugador: "+jugador.getNombre());
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 691, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 685, 204);
		contentPane.add(scrollPane);
		Object[][] info= new Object[jugador.getCantlesiones()][6];
		for(int i =0; i < jugador.getCantlesiones();i++) {
			
			info[i][0]=jugador.getLesiones().get(i).getCodigo();
			if(jugador.getLesiones().get(i).isEstado()== false) {
				info[i][1]="Recuperada";
			}
			else {
				info[i][1]="Sin recuperar";
			}
			info[i][2]=jugador.getLesiones().get(i).getTipo();
			info[i][3]=jugador.getLesiones().get(i).getFechaLesion();
			info[i][4]=jugador.getLesiones().get(i).getRecoveryTime();
			if(equipo==null) {
				info[i][5]="";
			}else {
				info[i][5]=equipo.getNombre();
			}
			
			
			
		}
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			info,
			new String[] {
					"Codigo","Estado de la lesion","Tipo",  "Fecha de lesion", "Tiempo de recuperacion","Equipo"
			}
		));
 
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JButton btnVerificarRecuperacion = new JButton("Verificar Recuperacion");
		btnVerificarRecuperacion.setBounds(489, 215, 165, 23);
		contentPane.add(btnVerificarRecuperacion);
		
		JButton btnAgregarLesion = new JButton("Agregar Lesion");
		btnAgregarLesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedColumn()>-1) {
					LesionarJugador ventana = new LesionarJugador(jugador,serie,equipo);
					ventana.setVisible(true);
					dispose();
				}
			}
		});
		btnAgregarLesion.setBounds(358, 215, 121, 23);
		contentPane.add(btnAgregarLesion);
	}

}
