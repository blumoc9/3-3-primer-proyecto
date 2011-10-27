package vista;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javabean.JPanelImagen;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
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
public class FrmHome extends javax.swing.JFrame {
	private JPanelImagen pndatos;
	private JButton btintrucciones;
	private JButton btlista;
	private JButton btregistrarjugador;
	private JButton btjugar;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrmHome inst = new FrmHome();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrmHome() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("MasterMind");
			{
				pndatos = new JPanelImagen();
				getContentPane().add(pndatos, BorderLayout.CENTER);
				((JPanelImagen) pndatos).setRutaImagen("/imagen/logo13.png");
				pndatos.setPreferredSize(new java.awt.Dimension(778, 331));
				{
					btintrucciones = new JButton();
					pndatos.add(btintrucciones);
					btintrucciones.setText("Intrucciones de Juego");
					btintrucciones.setBounds(23, 153, 274, 44);
					btintrucciones.setFont(new java.awt.Font("DialogInput",1,16));
					btintrucciones.setBackground(new java.awt.Color(4,123,173));
					btintrucciones.setForeground(new java.awt.Color(255,255,255));
					btintrucciones.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
					btintrucciones.setIcon(new ImageIcon(getClass().getClassLoader().getResource("iconos/accept_page.png")));
				}
				{
					btjugar = new JButton();
					pndatos.add(getBtjugar());
					btjugar.setText("Jugar");
					btjugar.setBounds(23, 37, 274, 41);
					btjugar.setForeground(new java.awt.Color(255,255,255));
					btjugar.setFont(new java.awt.Font("DialogInput",1,16));
					btjugar.setBackground(new java.awt.Color(4,123,173));
					btjugar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
					btjugar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("iconos/joystick.png")));
				}
				{
					btregistrarjugador = new JButton();
					pndatos.add(getBtregistrarjugador());
					btregistrarjugador.setText("Registrar Jugador");
					btregistrarjugador.setBounds(23, 97, 274, 41);
					btregistrarjugador.setBackground(new java.awt.Color(4,123,173));
					btregistrarjugador.setFont(new java.awt.Font("DialogInput",1,16));
					btregistrarjugador.setForeground(new java.awt.Color(255,255,255));
					btregistrarjugador.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
					btregistrarjugador.setIcon(new ImageIcon(getClass().getClassLoader().getResource("iconos/add_male_user.png")));
				}
				{
					btlista = new JButton();
					pndatos.add(getBtlista());
					btlista.setText("Listado Mejor Jugador");
					btlista.setBounds(23, 214, 274, 40);
					btlista.setBackground(new java.awt.Color(4,123,173));
					btlista.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
					btlista.setFont(new java.awt.Font("DialogInput",1,16));
					btlista.setForeground(new java.awt.Color(255,255,255));
					btlista.setIcon(new ImageIcon(getClass().getClassLoader().getResource("iconos/full_page.png")));
				}
			}
			pack();
			this.setSize(688, 440);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public JPanel getPndatos() {
		return pndatos;
	}
	
	public JButton getBtjugar() {
		return btjugar;
	}
	
	public JButton getBtregistrarjugador() {
		return btregistrarjugador;
	}

	public void Agregarescuchador(ActionListener actionlistener){
		this.btregistrarjugador.addActionListener(actionlistener);
		this.btjugar.addActionListener(actionlistener);
		this.btintrucciones.addActionListener(actionlistener);
		this.btlista.addActionListener(actionlistener);
	}
	
	public JButton getBtlista() {
		return btlista;
	}
}
