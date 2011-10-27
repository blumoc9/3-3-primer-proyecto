package vista;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
public class FrmRegistrarJugador extends javax.swing.JFrame {
	private JPanel pndatos;
	private JLabel lblid;
	private JTextFieldValidator txtnombre;
	private JLabel lblnombre;
	private JTextFieldValidator txtid;
	private JPanel pndatosjugador;
	private JButton btcancelar;
	private JButton btaceptar;
	private JOptionPane mensaje;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmRegistrarJugador inst = new FrmRegistrarJugador();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmRegistrarJugador() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("MasterMind/Registrar Jugador");
			this.setResizable(false);
			{
				pndatos = new JPanel();
				getContentPane().add(getPndatos(), BorderLayout.CENTER);
				pndatos.setLayout(null);
				pndatos.setBackground(new java.awt.Color(4,123,173));
				pndatos.setPreferredSize(new java.awt.Dimension(355, 270));
				{
					pndatosjugador = new JPanel();
					pndatos.add(getPndatosjugador());
					pndatosjugador.setBounds(21, 21, 325, 124);
					pndatosjugador.setLayout(null);
					pndatosjugador.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					{
						lblid = new JLabel();
						pndatosjugador.add(getLblid());
						lblid.setText("Id:");
						lblid.setBounds(43, 13, 23, 32);
						lblid.setFont(new java.awt.Font("DialogInput",1,12));
					}
					{
						txtid = new JTextFieldValidator();
						pndatosjugador.add(getTxtid());
						txtid.setBounds(72, 13, 191, 34);
						txtid.setTipoCaracteresPermitidos(JTextFieldValidator.SOLO_LETRAS);
					}
					{
						lblnombre = new JLabel();
						pndatosjugador.add(getLblnombre());
						lblnombre.setText("Nombre:");
						lblnombre.setBounds(13, 69, 53, 15);
						lblnombre.setFont(new java.awt.Font("DialogInput",1,12));
					}
					{
						txtnombre = new JTextFieldValidator();
						pndatosjugador.add(getTxtnombre());
						txtnombre.setBounds(72, 60, 191, 34);
						txtnombre.setTipoCaracteresPermitidos(JTextFieldValidator.SOLO_LETRAS);
					}
					{
						btcancelar = new JButton();
						pndatos.add(getBtcancelar());
						btcancelar.setText("Cancelar");
						btcancelar.setBounds(208, 151, 138, 30);
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
						btaceptar.setBounds(64, 151, 138, 30);
						btaceptar.setBackground(new java.awt.Color(4,123,173));
						btaceptar.setFont(new java.awt.Font("DialogInput",1,14));
						btaceptar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
						btaceptar.setForeground(new java.awt.Color(255,255,255));
						btaceptar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("iconos/accept.png")));
					}
				}
			}
			pack();
			this.setSize(379, 231);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public JPanel getPndatos() {
		return pndatos;
	}
	
	public JPanel getPndatosjugador() {
		return pndatosjugador;
	}
	
	public JLabel getLblid() {
		return lblid;
	}
	
	public JTextField getTxtid() {
		return txtid;
	}
	
	public JLabel getLblnombre() {
		return lblnombre;
	}
	
	public JTextField getTxtnombre() {
		return txtnombre;
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
