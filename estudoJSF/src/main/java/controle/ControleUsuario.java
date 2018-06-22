package controle;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.Usuario;

@ManagedBean(name = "controleUsuario")
@RequestScoped
public class ControleUsuario implements Serializable{

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public ControleUsuario() {
		usuario = new Usuario();
	}
	
	public String recebeDados() {
		FacesMessage msg = new FacesMessage("Dados recebidos com sucesso");
		FacesContext.getCurrentInstance().addMessage("", msg);
		return "formUsuario";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
