
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Logado extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JButton btJogar;
	private JButton btRanking;
	private JButton btHistorico;
	private JButton btGerenciamento;

	/**
	 * Create the panel.
	 */
	public Logado() {

		initComponents();
		setBounds(100, 100, 450, 280);
		
		this.btJogar = new JButton("Jogar");
		this.btJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela.frame.setContentPane(new Jogar());
				Tela.frame.setVisible(true);
			}
		});
		add(this.btJogar, "flowx,cell 1 2");
		
		this.btRanking = new JButton("Ranking");
		add(this.btRanking, "cell 1 2");
		
		this.btHistorico = new JButton("Histórico");
		add(this.btHistorico, "cell 1 2");
		
		this.btGerenciamento = new JButton("Gerenciamento");
		add(this.btGerenciamento, "cell 1 2");
	}
	
	private void initComponents() {
		setLayout(new MigLayout("", "[grow][][grow]", "[grow][][grow]"));
		
		this.lblNewLabel = new JLabel("Bem-vindo(a)!" + "nome jogador");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(this.lblNewLabel, "cell 1 1");
	}

}
