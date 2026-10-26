
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Padrao extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public Padrao() {

		initComponents();
		setBounds(100, 100, 450, 280);
		
		
	}
	
	private void initComponents() {
		setLayout(new MigLayout("", "[grow][][grow]", "[grow][][grow]"));
		
		this.lblNewLabel = new JLabel("Bem Vindo Jogador!");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(this.lblNewLabel, "cell 1 1");
	}

}
