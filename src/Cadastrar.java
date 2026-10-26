
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

public class Cadastrar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField usuario;
	private JTextField senha;
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;
	private JTextField apelido;

	/**
	 * Create the panel.
	 */
	public Cadastrar() {

		initComponents();
		setBounds(100, 100, 450, 280);
	}
	
	private void botaoCadastro() {
		Usuario user = new Usuario();
		
		if(usuario.getText().isEmpty() || apelido.getText().isEmpty() || senha.getText().isEmpty() ) {
			JOptionPane.showMessageDialog(null, "Digite nome de usuário", "Erro", JOptionPane.ERROR_MESSAGE);
		}else {
			String nome = usuario.getText();
			String se = senha.getText();	
			String ap = apelido.getText();
			
			
			user.setApelido(ap);
			user.setNome(nome);
			user.setSenha(se);
			
			if(user.UsuarioSalvo(user)) {
				JOptionPane.showMessageDialog(null, "Usuário Cadastrado!", "Login", JOptionPane.PLAIN_MESSAGE);
				Tela.frame.setContentPane(new Padrao());
				Tela.frame.setVisible(true);
				Tela.frame.getSobre().setEnabled(true);
			}else {
				JOptionPane.showMessageDialog(null, "Deu erro!", "Login", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void initComponents() {
		setLayout(new MigLayout("", "[grow][72.00][grow][grow]", "[grow][][][][][][][grow]"));
		
		this.lblNewLabel = new JLabel("Cadastre-se o Sistema");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(this.lblNewLabel, "cell 1 1 2 1,alignx center");
		
		this.lblNewLabel_3 = new JLabel("Apelido:");
		this.lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(this.lblNewLabel_3, "cell 1 2,alignx trailing");
		
		this.apelido = new JTextField();
		this.apelido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.apelido.setColumns(10);
		add(this.apelido, "cell 2 2,growx");
		
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
		
		this.btnNewButton = new JButton("Realizar Cadastro");
		this.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botaoCadastro();
			}
		});
		this.btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(this.btnNewButton, "cell 1 6 2 1,growx");
	}

}
