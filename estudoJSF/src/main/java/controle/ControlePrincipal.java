package controle;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controlePrincipal")
@SessionScoped
public class ControlePrincipal implements Serializable{

	private static final long serialVersionUID = 1L;

	private String mensagem;
	
	public ControlePrincipal() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		mensagem = "Teste de aplicação JSF "+sdf.format(Calendar.getInstance().getTime());;
	}

	public String sobre() {
		mensagem = "Navegação dinamico";
		return "sobre";
	}
	
	public String sobreRedirecionado() {
		mensagem = "Redirecionado para a pagina sobre.xhtml";
		return "sobre?faces-redirect=true";
	}
	
	public String geraErro() {
		return "erro";
	}
	
	public String geraLogin() {
		return "login";
	}
	
	public String geraComponentes() {
		return "componentesParaSaidaTextoImagens";
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
