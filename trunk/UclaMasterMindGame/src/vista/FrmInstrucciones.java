package vista;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;


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
public class FrmInstrucciones extends javax.swing.JFrame {
	private JPanel pndatos;
	private JTextArea txtarea;
	private JButton btaceptar;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmInstrucciones inst = new FrmInstrucciones();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmInstrucciones() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setBackground(new java.awt.Color(255,255,255));
			this.setTitle("MasterMind/Instrucciones");
			this.setResizable(false);
			{
				pndatos = new JPanel();
				getContentPane().add(getPndatos(), BorderLayout.CENTER);
				pndatos.setLayout(null);
				pndatos.setBackground(new java.awt.Color(4,123,173));
				pndatos.setPreferredSize(new java.awt.Dimension(781, 222));
				{
					txtarea = new JTextArea();
					pndatos.add(txtarea);
					txtarea.setBounds(26, 19, 640, 155);
					txtarea.setText("Existen 3 niveles de dificultad donde el jugador puede seleccionar que nivel desea jugar.\nEl primer nivel es el Basico donde hay 4 combinaciones de colores donde el jugador\ntiene en cada partida 12 intentos errados para poder conseguir la combinacion correcta.\nEl segundo nivel es el Intermedio que tiene 5 combinaciones de colores donde el \njugador  tiene en cada partida 13 intentos errados para poder conseguir la combinacion\ncorrecta. El tercer nivel es el Avanzado donde hay 6 combinaciones de colores donde \nel jugador tiene en cada partida 14 intentos errados para poder conseguir la combinacion\n correcta. El color verde representa un color y una posicion acertada y el color negro un \ncolor correcto, mas no en la posicion.");
					txtarea.setBackground(new java.awt.Color(4,123,173));
					txtarea.setFont(new java.awt.Font("DialogInput",1,12));
					txtarea.setEnabled(false);
				}
				{
					btaceptar = new JButton();
					pndatos.add(getBtaceptar());
					btaceptar.setText("Aceptar");
					btaceptar.setBounds(270, 180, 138, 30);
					btaceptar.setBackground(new java.awt.Color(4,123,173));
					btaceptar.setFont(new java.awt.Font("DialogInput",1,14));
					btaceptar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
					btaceptar.setForeground(new java.awt.Color(255,255,255));
					btaceptar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("iconos/accept.png")));
				}
			}
			pack();
			this.setSize(693, 248);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public JPanel getPndatos() {
		return pndatos;
	}

	public JTextArea getTxtarea() {
		return txtarea;
	}

	public JButton getBtaceptar() {
		return btaceptar;
	}

	public void AgregarEscuchadores(ActionListener actionlistener){
		this.btaceptar.addActionListener(actionlistener);
	}

}
