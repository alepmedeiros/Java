package controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Pessoa;

@ManagedBean(name = "controleTabela")
@SessionScoped
public class ControleTabela implements Serializable{

	private static final long serialVersionUID = 7865055273245829242L;
	
	private List<Pessoa> lista;
	
	public ControleTabela() {
		lista = new ArrayList<Pessoa>();
		lista.add(new Pessoa(1,"Joao","(21)2233-6633"));
		lista.add(new Pessoa(2,"Maria","(22)1111-1122"));
		lista.add(new Pessoa(3,"Paulo","(24)5555-7788"));
		lista.add(new Pessoa(4,"Aline","(45)3333-6655"));
		lista.add(new Pessoa(5,"Kauna","(11)4444-4455"));
		lista.add(new Pessoa(6,"Kelvin","(12)8888-8899"));
	}

	public String salvar() {
		for (Pessoa obj : lista) obj.setEditando(false);
		return null;
	}
	
	public String excluir(Pessoa obj) {
		lista.remove(obj);
		return null;
	}
	
	public List<Pessoa> getLista() {
		return lista;
	}

	public void setLista(List<Pessoa> lista) {
		this.lista = lista;
	}
	
}
