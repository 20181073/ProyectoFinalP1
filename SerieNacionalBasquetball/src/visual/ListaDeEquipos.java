package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logica.Equipo;
import logica.SerieNacional;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ListaDeEquipos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	
	//private String identificador = "";
	
	//private JButton btnVer;

	public ListaDeEquipos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaDeEquipos.class.getResource("/imagenes/IconoPrincipal.png")));
		setTitle("Lista de equipos");
		setResizable(false);
		setBounds(100, 100, 790, 496);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					table = new JTable();

					table.setFont(new Font("Tahoma", Font.PLAIN, 18));
					table.setDefaultRenderer(Object.class, new ImgTabla());
					String[] header = {"Logo","Nombre"};
					
					model = new DefaultTableModel(null, header){
						@Override
						public boolean isCellEditable(int filas, int columnas) {
								return false;
						}
					};
			
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setRowHeight(40);
					table.setModel(model);
					table.setOpaque(false);
					cargarTabla();
					scrollPane.setViewportView(table);
					scrollPane.setOpaque(false);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				/*{
					btnVer = new JButton("Ver");
					btnVer.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(!identificador.equalsIgnoreCase("")){
								//VerEquipo ver = new VerEquipo(buscarEquipoPorNombre(identificador));
								ver.setModal(true);
								ver.setVisible(true);
							}
							
							cargarTabla();
						}
					});
					btnVer.setEnabled(false);
					buttonPane.add(btnVer);
				}*/
				{
					JButton btnEliminarEquipo = new JButton("Eliminar Equipo");
					btnEliminarEquipo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(table.getSelectedColumn()>-1 && table.getValueAt(table.getSelectedRow(), 0).equals("")==false) {	
								SerieNacional.getInstancia().getEquipos().remove(table.getSelectedRow());
								SerieNacional.getInstancia().Guardar(SerieNacional.getInstancia());
								JOptionPane.showMessageDialog(null, "Eliminación de equipo exitoso", "Aviso", JOptionPane.INFORMATION_MESSAGE);
								cargarTabla();
							}
						}
					});
					btnEliminarEquipo.setEnabled(false);
					buttonPane.add(btnEliminarEquipo);
					
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(table.getSelectedRow()>=0){
								btnEliminarEquipo.setEnabled(true);
								//int index = table.getSelectedRow();
								//identificador = (String)table.getModel().getValueAt(index, 1);
							}
						}
					});
				}
				{
					JButton btnAgregarEquipo = new JButton("Agregar Equipo");
					btnAgregarEquipo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegEquipos regE = new RegEquipos();
							regE.setModal(true);
							regE.setVisible(true);
							cargarTabla();
						}
					});
					buttonPane.add(btnAgregarEquipo);
				}
				buttonPane.add(btnSalir);
			}
		}
		
	}
	
	protected Equipo buscarEquipoPorNombre(String identificador2) {
		Equipo aux = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < SerieNacional.getInstancia().getEquipos().size()) {
			if(SerieNacional.getInstancia().getEquipos().get(i).getNombre().equalsIgnoreCase(identificador2)) {
				encontrado = true;
				aux = SerieNacional.getInstancia().getEquipos().get(i);
			}
			i++;
		}
		return aux;
	}

	private void cargarTabla() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < SerieNacional.getInstancia().getEquipos().size(); i++) {
			//
					//.getImage().getScaledInstance(ColumnConst, lblLogoequipo11.getHeight(), Image.SCALE_DEFAULT));
			Icon icono111 = new ImageIcon(SerieNacional.getInstancia().getEquipos().get(i).getLogo().getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			//JLabel log = ;
			fila[0]=new JLabel(icono111);
			fila[1] = SerieNacional.getInstancia().getEquipos().get(i).getNombre();
			model.addRow(fila);
			
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.getTableHeader().setReorderingAllowed(false);
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setResizable(false);
			columnModel.getColumn(1).setResizable(false);
		}
		
		
	}
	
}
