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

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RegEquipos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTable table;
	private JTable table2;
	private static DefaultTableModel model;
	private String identificador = "";
	private static Object[] fila;
	private ArrayList<Jugador> jugadores = new ArrayList<>();

	public static void main(String[] args) {
		try {
			RegEquipos dialog = new RegEquipos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
		txtNombre.setBounds(101, 44, 135, 20);
		panel.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNombre.setBounds(0, 47, 91, 14);
		panel.add(lblNombre);
		
		JPanel panel_JugadoresSinEquipo = new JPanel();
		panel_JugadoresSinEquipo.setBorder(null);
		panel_JugadoresSinEquipo.setBounds(256, 30, 230, 350);
		panel.add(panel_JugadoresSinEquipo);
		panel_JugadoresSinEquipo.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 230, 350);
		panel_JugadoresSinEquipo.add(scrollPane);
		
		String[] header = {"Nombre", "Número", "Poscición"};
		model = new DefaultTableModel(null, header){
			@Override
			public boolean isCellEditable(int filas, int columnas) {
				return false;
			}
		};
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow()>=0){
					//btnBorrar.setEnabled(true);
					int index = table.getSelectedRow();
					identificador = (String)table.getModel().getValueAt(index, 0);
	
				}
			}
		});
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(model);
		cargarTabla();
		scrollPane.setViewportView(table);
		
		JPanel panel_JugadoresSeleccionados = new JPanel();
		panel_JugadoresSeleccionados.setBorder(null);
		panel_JugadoresSeleccionados.setBounds(564, 11, 230, 369);
		panel.add(panel_JugadoresSeleccionados);
		panel_JugadoresSeleccionados.setLayout(null);
		
		String[] header1 = {"Nombre", "Número", "Poscición"};
		model = new DefaultTableModel(null, header1){
			@Override
			public boolean isCellEditable(int filas, int columnas) {
				return false;
			}
		};
		
		table2 = new JTable();
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table2.getSelectedRow()>=0){
					//btnBorrar.setEnabled(true);
					int index = table2.getSelectedRow();
					identificador = (String)table2.getModel().getValueAt(index, 0);
	
				}
			}
		});
		
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table2.setModel(model);
		cargarTabla();
		scrollPane.setViewportView(table2);
		
		JLabel lblLogo = new JLabel("LOGO");
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
				btnCancelar.setActionCommand("Cancel");
				Panel_Inferior.add(btnCancelar);
			}
		}
	}
	
	private void cargarTabla() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < jugadores.size(); i++) {
			fila[0] = jugadores.get(i).getNombre();
			fila[1] = jugadores.get(i).getNumeroCamiseta();
			fila[2] = jugadores.get(i).getDesempeño();
			model.addRow(fila);
		}
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setResizable(false);
		columnModel.getColumn(1).setResizable(false);
		columnModel.getColumn(2).setResizable(false);	
	}
}
