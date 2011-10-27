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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;

import bean.JTextFieldValidator;


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
public class FrmNuevaPartida extends javax.swing.JFrame {
	private JPanel pndatos;
	private JPanel pnnuevapartida;
	private JComboBox cmbdificultad;
	private JButton btcancelar;
	private JButton btaceptar;
	private JLabel lbldificultad;
	private JTextFieldValidator txtidjugador;
	private JLabel lblid;
	private JOptionPane mensaje;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmNuevaPartida inst = new FrmNuevaPartida();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmNuevaPartida() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("MasterMind/Nueva Partida");
			this.setResizable(false);
			{
				pndatos = new JPanel();
				getContentPane().add(getPndatos(), BorderLayout.CENTER);
				pndatos.setLayout(null);
				pndatos.setBackground(new java.awt.Color(4,123,173));
				{
					pnnuevapartida = new JPanel();
					pndatos.add(getPnnuevapartida());
					pnnuevapartida.setBounds(21, 19, 395, 128);
					pnnuevapartida.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					pnnuevapartida.setLayout(null);
					pnnuevapartida.setBackground(new java.awt.Color(225,225,225));
					{
						lblid = new JLabel();
						pnnuevapartida.add(getLblid());
						lblid.setText("Id Jugador:");
						lblid.setBounds(14, 20, 84, 29);
						lblid.setFont(new java.awt.Font("DialogInput",1,12));
					}
					{
						txtidjugador = new JTextFieldValidator();
						pnnuevapartida.add(getTxtidjugador());
						txtidjugador.setBounds(98, 21, 189, 32);
						txtidjugador.setTipoCaracteresPermitidos(JTextFieldValidator.SOLO_LETRAS);
					}
					{
						lbldificultad = new JLabel();
						pnnuevapartida.add(getLbldificultad());
						lbldificultad.setText("Dificultad:");
						lbldificultad.setBounds(11, 62, 81, 29);
						lbldificultad.setFont(new java.awt.Font("DialogInput",1,12));
					}
					{
						cmbdificultad = new JComboBox();
						pnnuevapartida.add(getCmbdificultad());
						cmbdificultad.setBounds(98, 65, 189, 22);
					}
				}
				{
					btcancelar = new JButton();
					pndatos.add(getBtcancelar());
					btcancelar.setText("Cancelar");
					btcancelar.setBounds(276, 153, 138, 30);
					btcancelar.setBackground(new java.awt.Color(4,123,173));
					btcancelar.setFont(new java.awt.Font("DialogInput",1,14));
					btcancelar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
					btcancelar.setForeground(new java.awt.Color(255,255,255));
					btcancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("iconos/delete.png")));
				}
				{
					btaceptar = new JButton();
					pndatos.add(getBtaceptar());
					btaceptar.setText("Aceptar");
					btaceptar.setBounds(133, 153, 138, 30);
					btaceptar.setBackground(new java.awt.Color(4,123,173));
					btaceptar.setFont(new java.awt.Font("DialogInput",1,14));
					btaceptar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
					btaceptar.setForeground(new java.awt.Color(255,255,255));
					btaceptar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("iconos/accept.png")));
				}
			}
			pack();
			this.setSize(449, 224);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public JPanel getPndatos() {
		return pndatos;
	}
	
	public JPanel getPnnuevapartida() {
		return pnnuevapartida;
	}
	
	public JLabel getLblid() {
		return lblid;
	}
	
	public JTextField getTxtidjugador() {
		return txtidjugador;
	}
	
	public JLabel getLbldificultad() {
		return lbldificultad;
	}
	
	public JComboBox getCmbdificultad() {
		return cmbdificultad;
	}
	
	public JButton getBtcancelar() {
		return btcancelar;
	}
	
	public JButton getBtaceptar() {
		return btaceptar;
	}

	public JOptionPane getMensaje() {
		return mensaje;
	}

	public void AgregarEscuchadores(ActionListener actionlistener){
		this.btaceptar.addActionListener(actionlistener);
		this.btcancelar.addActionListener(actionlistener);
	}
}
