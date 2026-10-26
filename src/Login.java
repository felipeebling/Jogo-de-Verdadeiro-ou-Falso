

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField usuario;
	private JTextField senha;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public Login() {

		initComponents();
		setBounds(100, 100, 450, 280);
	}
	
	private void botaoLogin() {
		if(usuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite nome de usuário", "Erro", JOptionPane.ERROR_MESSAGE);
		}else {
			String ape = usuario.getText();
			String ps =  senha.getText();
			
			Arquivo arq = new Arquivo("Usuarios.txt");
			
			String conteudo = arq.ler();
			String[] vetor = conteudo.split("\n");
				
			boolean logou = false;
			
			for (String cadastro : vetor) {
				String[] vetor2 = cadastro.split(";");
				System.out.print("nome= " + ape + " senha= " +ps);
				if(ape.equals(vetor2[1]) && ps.equals(vetor2[2] )) {
					JOptionPane.showMessageDialog(null, "Usuário Logado!", "Login", JOptionPane.PLAIN_MESSAGE);
					Tela.frame.setContentPane(new Logado());
					Tela.frame.setVisible(true);
					Tela.frame.getSobre().setEnabled(false);
					logou = true;
					break;
				}else {
					if(!logou) {
						JOptionPane.showMessageDialog(null, "Usuário ou Senha Incorreto.", "Erro", JOptionPane.ERROR_MESSAGE);
						}
				}
			} 
			
			
		}
	}
	
	private void initComponents() {
		setLayout(new MigLayout("", "[grow][72.00][grow][grow]", "[grow][][][][][][][grow]"));
		
		this.lblNewLabel = new JLabel("Login no Sistema");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(this.lblNewLabel, "cell 1 1 2 1,alignx center");
		
		this.lblNewLabel_1 = new JLabel("Usuário:");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(this.lblNewLabel_1, "cell 1 3,alignx trailing");
		
		this.usuario = new JTextField();
		this.usuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(this.usuario, "cell 2 3,grow");
		this.usuario.setColumns(10);
		
		this.lblNewLabel_2 = new JLabel("Senha:");
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(this.lblNewLabel_2, "cell 1 4,alignx trailing");
		
		this.senha = new JPasswordField();
		this.senha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(this.senha, "cell 2 4,grow");
		
		this.btnNewButton = new JButton("Realizar Login");
		this.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoLogin();
			}
		});
		this.btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(this.btnNewButton, "cell 1 6 2 1,growx");
	}

}
