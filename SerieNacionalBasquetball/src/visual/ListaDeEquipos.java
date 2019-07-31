package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logica.SerieNacional;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ListaDeEquipos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public static DefaultTableModel model;
	public static Object[] fila;
	private JButton btnEliminar;
	private int index;

	/*
	public static void main(String[] args) {
		try {
			ListaDeEquipos dialog = new ListaDeEquipos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/

	public ListaDeEquipos() {
		setTitle("Lista de equipos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagenes/IconoPrincipal.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		{
			String[] header = {"Logo", "Nombre"};
			model = new DefaultTableModel();
			model.setColumnIdentifiers(header);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(table.getSelectedRow()>=0){
						btnEliminar.setEnabled(true);
						index = table.getSelectedRow();
					}
				}
			});
			table.setModel(model);
			scrollPane.setViewportView(table);
			loadTable();
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(SerieNacional.getInstancia().getEquipos().size() == 0 || table.getSelectedRow() < 0) {
							JOptionPane.showMessageDialog(null, "No hay elementos seleccionados.","Aviso",JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							int input = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar el equipo?","Confirmación",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
							
							if(input == 0) {
								SerieNacional.getInstancia().getEquipos().remove(index);
								SerieNacional.getInstancia().Guardar(SerieNacional.getInstancia());
								JOptionPane.showMessageDialog(null, "El equipo ha sido eliminado.","Información",JOptionPane.INFORMATION_MESSAGE);
								loadTable();
							}
						}
					}
				});
				btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
				buttonPane.add(btnEliminar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	public static void loadTable() {
		model.setRowCount(0);
		
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < SerieNacional.getInstancia().getEquipos().size(); i++) {
			
			fila[0] = SerieNacional.getInstancia().getEquipos().get(i).getFicherologo();
			fila[1] = SerieNacional.getInstancia().getEquipos().get(i).getNombre();
			File imgEquip = new File("src/logoEquipos/" + SerieNacional.getInstancia().getEquipos().get(i).getNombre() + ".jpg");
			fila[2] = imgEquip;
			
			model.addRow(fila);
		}
		
		
		
		
		
	}
}
