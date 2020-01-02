package br.com.javaweb.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.javaweb.dao.OrientadorDAO;
import br.com.javaweb.domain.Orientador;
import br.com.javaweb.util.FacesUtil;

@ManagedBean
@ViewScoped
public class OrientadorBean {
	private Orientador orientadorCadastro;
	private List<Orientador> listaOrientadores;
	private List<Orientador> listaOrientadoresFiltrados;

	public List<Orientador> getListaOrientadores() {
		return listaOrientadores;
	}

	public void setListaOrientadores(List<Orientador> listaOrientadores) {
		this.listaOrientadores = listaOrientadores;
	}

	public List<Orientador> getListaOrientadoresFiltrados() {
		return listaOrientadoresFiltrados;
	}

	public void setListaOrientadoresFiltrados(List<Orientador> listaOrientadoresFiltrados) {
		this.listaOrientadoresFiltrados = listaOrientadoresFiltrados;
	}

	public Orientador getOrientadorCadastro() {
		if(orientadorCadastro == null) {
			orientadorCadastro = new Orientador();
		}
		return orientadorCadastro;
	}

	public void setOrientadorCadastro(Orientador orientadorCadastro) {
		this.orientadorCadastro = orientadorCadastro;
	}

	public void novo() {
		orientadorCadastro = new Orientador();
	}

	public void salvar() {
		try {

			OrientadorDAO orientadorDAO = new OrientadorDAO();
			orientadorDAO.salvar(orientadorCadastro);
			orientadorCadastro = new Orientador(); // limpa o objeto no modelo
			FacesUtil.adicionarMsgInfo("Orientador salvo com sucesso!");

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar incluir um orientador: " + ex.getMessage());

		}
	}

	public void excluir() {
		try {

			OrientadorDAO orientadorDAO = new OrientadorDAO();
			orientadorDAO.excluir(orientadorCadastro);

			FacesUtil.adicionarMsgInfo("Orientador removido com sucesso!");

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar excluir um orientador: " + ex.getMessage());

		}
	}
	
	public void editar() {
		try {

			OrientadorDAO orientadorDAO = new OrientadorDAO();
			orientadorDAO.editar(orientadorCadastro);

			FacesUtil.adicionarMsgInfo("Orientador editado com sucesso!");

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar editar os dados do orientador: " + ex.getMessage());

		}
	}
	
	public void listar() {
		try {
				OrientadorDAO orientadorDAO = new OrientadorDAO();
				listaOrientadores = orientadorDAO.listar();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar listar orientadores: " + ex.getMessage());

		}
	}
	
	public void carregar() {
		try {
			String valor = FacesUtil.getParam("oricod");
			
			if(valor != null) {
				Long codigo = Long.parseLong(valor);
				OrientadorDAO orientadorDAO = new OrientadorDAO();
				orientadorCadastro = orientadorDAO.buscarPorCodigo(codigo);
			}else {
				orientadorCadastro = new Orientador();
			}

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao obter os dados do orientador: " + ex.getMessage());

		}
	}
}