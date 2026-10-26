
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

public class Inicial extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtBemVindoJogador;

	/**
	 * Create the panel.
	 */
	public Inicial() {

		createContents();
	}
	private void createContents() {
		setLayout(new MigLayout("", "[][grow][grow][grow]", "[grow][][grow]"));
		
		this.txtBemVindoJogador = new JTextField();
		this.txtBemVindoJogador.setEditable(false);
		this.txtBemVindoJogador.setText("Bem Vindo Jogador!");
		add(this.txtBemVindoJogador, "cell 2 1,growx");
		this.txtBemVindoJogador.setColumns(10);
	}

}
