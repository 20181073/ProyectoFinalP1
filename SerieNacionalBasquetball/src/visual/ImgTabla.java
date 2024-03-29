package visual;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class ImgTabla extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
		if (o instanceof JLabel) {
			JLabel lbl = (JLabel)o;
			lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lbl.setBackground(Color.WHITE);
			lbl.setForeground(Color.WHITE);
			lbl.setOpaque(false);
			return lbl;
		}
		
		return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
	}
	
}
