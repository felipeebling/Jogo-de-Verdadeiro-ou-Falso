
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenu sobre;
	public JMenu getSobre() {
		return sobre;
	}

	public void setSobre(JMenu sobre) {
		this.sobre = sobre;
	}

	static Tela frame;
	private JMenuItem mntmXadastrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		this.menuBar = new JMenuBar();
		setJMenuBar(this.menuBar);
		
		this.mnNewMenu = new JMenu("Sistema");
		this.menuBar.add(this.mnNewMenu);
		
		this.mntmNewMenuItem = new JMenuItem("Login");
		this.mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(new Login());
				setVisible(true);
			}
		});
		this.mnNewMenu.add(this.mntmNewMenuItem);
		
		this.mntmNewMenuItem_1 = new JMenuItem("Logout");
		this.mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sobre.setEnabled(false);
				setContentPane(new Padrao());
				setVisible(true);
			}
		});
		this.mnNewMenu.add(this.mntmNewMenuItem_1);
		
		this.mntmXadastrar = new JMenuItem("Cadastrar");
		this.mntmXadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(new Cadastrar());
				setVisible(true);
			}
		});
		this.mnNewMenu.add(this.mntmXadastrar);
		
		
		
		
		this.sobre = new JMenu("Sobre");
		this.sobre.setEnabled(false);
		this.menuBar.add(this.sobre);

		
		this.setContentPane(new Padrao());
		
		setLocationRelativeTo(null);
	}

}
