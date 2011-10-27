package vista;
import bean.Cronometro;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
public class FrmPartida extends javax.swing.JFrame {
	private JPanel pndatos;
	private JPanel pnpaletacolor;
	private JLabel lbljugador;
	private JLabel lblrespuesta;
	private JScrollPane jScrollPane1;
	private JLabel lbtiempo;
	private Cronometro crtiempo;
	private JPanel pncombinacionrespuesta;
	private JPanel pnrespuesta;
	private JButton btprobar;
	private JPanel pncombinacion;
	private JPanel pncombinaciones;
	private JLabel lbljugador2;
	private JOptionPane mensaje;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmPartida inst = new FrmPartida();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmPartida() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("MasterMind");
			{
				pndatos = new JPanel();
				getContentPane().add(pndatos, BorderLayout.CENTER);
				pndatos.setLayout(null);
				pndatos.setPreferredSize(new java.awt.Dimension(930, 595));
				pndatos.setBackground(new java.awt.Color(4,123,173));
				{
					this.crtiempo= new Cronometro();
					pndatos.add(crtiempo.getLblTiempo());
					crtiempo.getLblTiempo().setBounds(424, 43, 53, 14);
					crtiempo.getLblTiempo().setForeground(Color.WHITE);
				}
				{
					lbljugador = new JLabel();
					pndatos.add(getLbljugador());
					lbljugador.setText("Jugador:");
					lbljugador.setBounds(12, 22, 72, 15);
					lbljugador.setFont(new java.awt.Font("DialogInput",1,12));
					lbljugador.setForeground(new java.awt.Color(255,255,255));
				}
				{
					lbljugador2 = new JLabel();
					pndatos.add(lbljugador2);
					lbljugador2.setBounds(83, 19, 222, 31);
					lbljugador2.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					lbljugador2.setForeground(new java.awt.Color(255,255,255));
					lbljugador2.setFont(new java.awt.Font("DialogInput",1,12));
				}
				{
					pncombinaciones = new JPanel();
					pncombinaciones.setLayout(null);
					pndatos.add(getPncombinaciones());
					pncombinaciones.setBounds(251, 79, 421, 531);
					pncombinaciones.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				}
				{
					pncombinacion = new JPanel();
					pncombinacion.setLayout(null);
					pndatos.add(getPncombinacion());
					pncombinacion.setBounds(71, 642, 145, 27);
					pncombinacion.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
				}
				{
					btprobar = new JButton();
					pndatos.add(getBtprobar());
					btprobar.setText("Probar");
					btprobar.setBounds(71, 675, 145, 28);
					btprobar.setBackground(new java.awt.Color(4,123,173));
					btprobar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
					btprobar.setFont(new java.awt.Font("DialogInput",1,12));
					btprobar.setForeground(new java.awt.Color(255,255,255));
					btprobar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("iconos/accept.png")));
					btprobar.setEnabled(false);
				}
				{
					pnpaletacolor = new JPanel();
					pndatos.add(pnpaletacolor);
					pnpaletacolor.setLayout(null);
					pnpaletacolor.setBounds(71, 79, 145, 531);
					pnpaletacolor.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));	
				}
				{
					pnrespuesta = new JPanel();
					pndatos.add(getPnrespuesta());
					pndatos.add(getLbtiempo());
					pnrespuesta.setBounds(251, 642, 421, 61);
					pnrespuesta.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
					pnrespuesta.setLayout(null);
					{
						lblrespuesta = new JLabel();
						pnrespuesta.add(getLblrespuesta());
						lblrespuesta.setText("Respuesta:");
						lblrespuesta.setBounds(8, 20, 104, 28);
						lblrespuesta.setFont(new java.awt.Font("Dialog",1,16));
					}
					{
						pncombinacionrespuesta = new JPanel();
						pncombinacionrespuesta.setLayout(null);
						pnrespuesta.add(getPncombinacionrespuesta());
						pncombinacionrespuesta.setBounds(112, 20, 162, 28);
						pncombinacionrespuesta.setVisible(false);
					}
				}
		}
			//pack();
			this.setSize(787, 766);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public JPanel getPndatos() {
		return pndatos;
	}
	
	public JPanel getPnpaletacolor() {
		return pnpaletacolor;
	}
	
	public JLabel getLbljugador() {
		return lbljugador;
	}
	
	public JPanel getPncombinaciones() {
		return pncombinaciones;
	}
	
	public JPanel getPncombinacion() {
		return pncombinacion;
	}
	
	public JButton getBtprobar() {
		return btprobar;
	}
	
	public JPanel getPnrespuesta() {
		return pnrespuesta;
	}
	
	public JLabel getLblrespuesta() {
		return lblrespuesta;
	}
	
	public JPanel getPncombinacionrespuesta() {
		return pncombinacionrespuesta;
	}

	public JLabel getLbljugador2() {
		return lbljugador2;
	}
	
	public JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public JOptionPane getMensaje() {
		return mensaje;
	}

	public Cronometro getCrtiempo() {
		if(crtiempo == null) {
			crtiempo = new Cronometro();
		}
		return crtiempo;
	}
	
	private JLabel getLbtiempo() {
		if(lbtiempo == null) {
			lbtiempo = new JLabel();
			lbtiempo.setText("Segundos");
			lbtiempo.setBounds(486, 36, 71, 14);
			lbtiempo.setForeground(new java.awt.Color(255,255,255));
			lbtiempo.setFont(new java.awt.Font("DialogInput",1,12));
		}
		return lbtiempo;
	}

}
