package controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

@ManagedBean(name ="controleComponentes")
@SessionScoped
public class ControleComponentes implements Serializable{

	private static final long serialVersionUID = 1L;

	private String texto;
	
	private String id_Componente;
	
	public ControleComponentes() {
		// TODO Auto-generated constructor stub
	}

	public String geraTexto() {
		texto = "Texto gerado: <> & <b> Texto em negrito</b>";
		return "componentesParte2";
	}
	
	public String executa() {
		return "componentesParte3";
	}
	
	public void listener(ActionEvent event) {
		UIComponent source = event.getComponent();
		id_Componente = source.getId();
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getId_Componente() {
		return id_Componente;
	}

	public void setId_Componente(String id_Componente) {
		this.id_Componente = id_Componente;
	}
	
}
