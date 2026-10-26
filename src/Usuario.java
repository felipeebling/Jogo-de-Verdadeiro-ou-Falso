
public class Usuario {
private  String nome;
private String apelido;
private String senha;


public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getApelido() {
	return apelido;
}
public void setApelido(String apelido) {
	this.apelido = apelido;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}
public Usuario(String nome, String apelido, String senha) {
	
	this.nome = nome;
	this.apelido = apelido;
	this.senha = senha;
}

public Usuario() {}

public boolean UsuarioSalvo(Usuario user) {
		Arquivo arq = new Arquivo("Usuarios.txt");
		
		String  conteudo = arq.ler();
	
		String addTexto = user.getNome() +";"+ user.getApelido()+
				";" + user.getSenha();
		
		if	(arq.gravar(conteudo  + addTexto)) {
			return true;
		}else {
			return false;
		}
		
}







	
	
}


