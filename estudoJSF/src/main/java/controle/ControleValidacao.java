package controle;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;


@ManagedBean(name = "controleValidacao")
@SessionScoped
public class ControleValidacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotEmpty(message="O nome deve ser informado")
	@Length(min=3,max=40,message="O nome de conter entre {min} a {max} caracteres")
	private String nome;
	
	@NotEmpty(message="O telefone deve ser informado")
	@Pattern(regexp="\\(\\d{2}\\)\\d{4}\\-\\d{4}", message="O formato do telefene deve estar (99)9999-9999")
	private String telefone;
	
	@NotEmpty(message="O email deve ser informado")
	@Email(message="Informe um email valido")
	private String email;
	
	@NotNull(message="A idade deve ser informada")
	@Range(min=10, max=80, message="A indade deve estar entre {min} a {max}")
	private Long idade;
	
	@NotNull(message="A nota deve ser informada")
	@Range(min=0,max=10, message="A nota deve estar entre {min} a {max}")
	private Double nota;
	
	public ControleValidacao() {
		// TODO Auto-generated constructor stub
	}

	public String processaDados() {
		String saida = "";
		saida += "Nome: "+nome;
		saida += "Telefone: "+telefone;
		saida += "Email: "+email;
		saida += "Idade: "+idade;
		saida += "Nota: "+nota;
		FacesMessage msg = new FacesMessage(saida);
		FacesContext.getCurrentInstance().addMessage("", msg);
		nome ="";
		telefone = "";
		email = "";
		idade = null;
		nota = null;
		return "formValidacaoBean";
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
}
