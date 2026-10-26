import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Jogar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblHoraDeJogar;
	private JButton btVerdadeiro;
	private JButton btFalso;
	private LinkedList<JButton> listaBotoes;
	private Stack<String> listaFrases;
	private JLabel txtfrase;
	private JLabel Vhbkjndas;
	private JLabel vidas;
	private int vida = 3;
	private final JLabel lblNewLabel = new JLabel("Pontos:");
	private JLabel JBpontuacao;
	private int pontos = 0;

	public Jogar() {

		createContents();
		Arquivo arq = new Arquivo("afirmacoes.txt");
		String[] afirmacoes = arq.ler().split("\n");
		listaFrases = new Stack();
		
		for (String frase : afirmacoes) {
			listaFrases.push(frase);
		}
		
		this.btFalso = new JButton("Falso");
		this.btFalso.setBackground(new Color(255, 117, 117));
		this.btFalso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(this.btFalso, "cell 1 5");
		
		vidas = new JLabel("");
		add(vidas, "cell 1 0");
		
		JBpontuacao = new JLabel("");
		add(JBpontuacao, "cell 1 1");
		
		listaBotoes = new LinkedList<>();
		listaBotoes.add(btVerdadeiro);
		listaBotoes.add(btFalso);
		
		mostraTexto();
		
		for (JButton botao : listaBotoes) {
			botao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					acaoBotao(botao);
				}
			});
		}
		
	}
	
	public void mostraTexto() {
		if(!listaFrases.peek().isEmpty()) {
		String[] jogo = listaFrases.peek().split(";") ;
		txtfrase.setText(jogo[0]);
		}else {
			System.out.print("Frase acabou");
		}
	}
	
	public void acaoBotao(JButton buton) {
		
		String[] jogada = listaFrases.pop().split(";");
		String op = buton.getText();
		
		if(op.equals("Verdadeiro")) {
			
			if(jogada[1].equals("V")) {
				System.out.print("Acertou");
				pontos += 50;
			}else {
				System.out.print("Erroui");
				vida -= 1;
			}
			
		}else {
			if(jogada[1].equals("F")) {
				System.out.print("Acertou");
				pontos += 50;
				
			}else {
				System.out.print("Errou");
				vida -= 1;
			}
			
		}
		JBpontuacao.setText(pontos+"");
		
		mostraTexto();
		
		if	(vida > 0 && listaFrases.isEmpty()) {
			//jogo ganhou
		}else if(vida == 0)  {
			//jogo perdeu
		}
		
		
	}

	private void createContents() {
		setLayout(new MigLayout("", "[grow][grow,center][grow]", "[][][grow][][][grow]"));
		
		Vhbkjndas = new JLabel("Vidas Restantes:");
		add(Vhbkjndas, "flowx,cell 1 0");
		add(lblNewLabel, "flowx,cell 1 1");
		
		this.lblHoraDeJogar = new JLabel("Hora de jogar meus amigos");
		this.lblHoraDeJogar.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(this.lblHoraDeJogar, "cell 1 2");
		
		txtfrase = new JLabel("");
		add(txtfrase, "cell 1 3,alignx center");
		
		this.btVerdadeiro = new JButton("Verdadeiro");
		this.btVerdadeiro.setBackground(Color.GREEN);
		this.btVerdadeiro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		add(this.btVerdadeiro, "flowx,cell 1 5");
	}

}