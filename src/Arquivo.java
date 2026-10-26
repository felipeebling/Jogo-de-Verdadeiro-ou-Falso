
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Arquivo {
	
	private BufferedWriter bw;
	private BufferedReader br;	
	private String nome;
	
	public Arquivo(String nome) {
		this.nome = nome;
	}
	
	public boolean gravar(String texto) {
		try {
			bw = new BufferedWriter(new FileWriter(this.nome));
			bw.write(texto+"/" +"\n");
			bw.close();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo");
			return false;
		}
	}

	public String ler() {
		String conteudo = "";
		String linha = "";
		try {
			br = new BufferedReader(new FileReader(this.nome));
			while((linha = br.readLine())!= null) {
				conteudo += linha + "\n";
			}
			return conteudo;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao ler arquivo");
			return "#!ERRO!#";
		}
		
	}
}
