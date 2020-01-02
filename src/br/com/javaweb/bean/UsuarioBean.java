package br.com.javaweb.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.javaweb.dao.UsuarioDAO;
import br.com.javaweb.domain.Usuario;
import br.com.javaweb.util.FacesUtil;

@ManagedBean
@ViewScoped
public class UsuarioBean {
	private Usuario usuarioCadastro;
	
	private List<Usuario> listaUsuarios;
	private List<Usuario> listaUsuariosFiltrados;

	public Usuario getUsuarioCadastro() {
		if(usuarioCadastro == null) {
			usuarioCadastro = new Usuario();
		}
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(Usuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<Usuario> getListaUsuariosFiltrados() {
		return listaUsuariosFiltrados;
	}

	public void setListaUsuariosFiltrados(List<Usuario> listaUsuariosFiltrados) {
		this.listaUsuariosFiltrados = listaUsuariosFiltrados;
	}

	public void novo() {
		usuarioCadastro = new Usuario();
	}

	public void salvar() {
		try {

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.salvar(usuarioCadastro);
			usuarioCadastro = new Usuario(); // limpa o objeto no modelo
			FacesUtil.adicionarMsgInfo("Usuario salvo com sucesso!");

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar incluir um usuario: " + ex.getMessage());

		}
	}

	public void excluir() {
		try {

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.salvar(usuarioCadastro);
			
			FacesUtil.adicionarMsgInfo("Usuario removido com sucesso!");

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar excluir um usuario: " + ex.getMessage());

		}
	}
	
	public void editar() {
		try {

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.salvar(usuarioCadastro);
			
			FacesUtil.adicionarMsgInfo("Usuario editado com sucesso!");

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar editar os dados do usuario: " + ex.getMessage());

		}
	}
	
	public void listar() {
		try {
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				listaUsuarios = usuarioDAO.listar();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar listar usuarios: " + ex.getMessage());

		}
	}
	
	public void carregar() {
		try {
			String valor = FacesUtil.getParam("oricod");
			
			if(valor != null) {
				Long codigo = Long.parseLong(valor);
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				usuarioCadastro = usuarioDAO.buscarPorCodigo(codigo);
			}else {
				usuarioCadastro = new Usuario();
			}

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao obter os dados do usuario: " + ex.getMessage());

		}
	}
}