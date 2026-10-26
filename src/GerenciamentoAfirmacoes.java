import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GerenciamentoAfirmacoes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	

	/**
	 * Create the panel.
	 */
	public GerenciamentoAfirmacoes() {
		
		initComponents();
		setBounds(100, 100, 1167, 585);
		setLayout(new MigLayout("", "[][][][][][][][][grow][241.00][grow]", "[][][][][338.00,grow][grow][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 2 4 8 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Afirma\u00E7\u00E3o", "Resposta", "Categoria"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(0).setMinWidth(300);
		table.getColumnModel().getColumn(1).setPreferredWidth(57);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setMinWidth(37);
		scrollPane.setViewportView(table);
		
		JButton btSalvar = new JButton("Salvar Alterações");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = ((DefaultTableModel) table.getModel());
				int linhas = model.getRowCount();
				String conteudo = "";
				
				for (int i = 0 ; i< linhas ; i++) {
					conteudo += model.getValueAt(i, 0) + ";";
					conteudo += model.getValueAt(i, 1) + ";";
					conteudo += model.getValueAt(i, 2) + ";" + "\n";
					
				}
				
				System.out.print(conteudo);
				
			}
		});
		add(btSalvar, "cell 9 5");
		 //DefaultTableModel model = ((DefaultTableModel) table.getModel());
		
		
		
		carregarNaTabela();

	}
	
	public void carregarNaTabela() {
		Arquivo arq = new Arquivo("afirmacoes.txt");
		String[] conteudo = arq.ler().split("\n");
		
		for (String frase : conteudo) {
			String[] secundaria = frase.split(";");
			DefaultTableModel model = ((DefaultTableModel) table.getModel());
			model.addRow(new String[] {secundaria[0],secundaria[1],secundaria[2]}  );
		}
		
		
	
	}
	
	public void initComponents(){
		
	}

}
