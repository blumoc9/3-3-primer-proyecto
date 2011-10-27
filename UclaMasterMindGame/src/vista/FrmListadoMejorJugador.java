package vista;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import bean.TablaPlus;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class FrmListadoMejorJugador extends javax.swing.JFrame {
	private JPanel pndatos;
	private JPanel pnlistado;
	private JLabel lbldificultad;
	private JComboBox cmbdificultad;
	private TablaPlus tbjugadores;
	private JLabel lbllistado;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmListadoMejorJugador inst = new FrmListadoMejorJugador();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmListadoMejorJugador() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("MasterMind/Listado de los Mejores Jugadores");
			this.setResizable(false);
			{
				pndatos = new JPanel();
				getContentPane().add(getPndatos(), BorderLayout.CENTER);
				pndatos.setLayout(null);
				pndatos.setBackground(new java.awt.Color(4,123,173));
				pndatos.setPreferredSize(new java.awt.Dimension(554, 396));
				{
					pnlistado = new JPanel();
					pndatos.add(getPnlistado());
					pnlistado.setBounds(20, 22, 512, 326);
					pnlistado.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					{
						lbllistado = new JLabel();
						pnlistado.add(getLbllistado());
						pnlistado.setLayout(null);
						lbllistado.setText("Listado de los Mejores Jugadores");
						lbllistado.setBounds(128, 15, 295, 40);
						lbllistado.setFont(new java.awt.Font("DialogInput",1,12));
					}
				}
				String [] nombres_columnas = {"Id","Tiempo (Seg)","Intentos","Fecha"};
				tbjugadores = new TablaPlus();
				tbjugadores.setBounds(13, 116, 486, 192);
				pnlistado.add(tbjugadores);
				tbjugadores.setTablaPlus(nombres_columnas);
				tbjugadores.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				{
					cmbdificultad = new JComboBox();
					pnlistado.add(getCmbdificultad());
					cmbdificultad.setBounds(13, 82, 177, 28);
				}
				{
					lbldificultad = new JLabel();
					pnlistado.add(getLbldificultad());
					lbldificultad.setText("Seleccione Dificultad:");
					lbldificultad.setBounds(13, 61, 202, 15);
					lbldificultad.setFont(new java.awt.Font("DialogInput",1,12));
				}
				}
			pack();
			this.setSize(559, 426);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public JPanel getPndatos() {
		return pndatos;
	}
	
	public JPanel getPnlistado() {
		return pnlistado;
	}
	
	public JLabel getLbllistado() {
		return lbllistado;
	}
	
	public TablaPlus getTbjugadores() {
		return tbjugadores;
	}
	
	public JComboBox getCmbdificultad() {
		return cmbdificultad;
	}
	
	public JLabel getLbldificultad() {
		return lbldificultad;
	}
	
	public void AgregarEscuchadores(ActionListener actionlistener){
		this.cmbdificultad.addActionListener(actionlistener);
	}
}
