package br.com.fin.control.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fin.control.dao.UsuarioDao;
import br.com.fin.control.modelo.Usuario;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario = new Usuario();
	private Integer usuarioId;

	@Inject
	private UsuarioDao usuarioDao;
	
	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public void carregarUsuarioPeloId() {
		this.usuario = this.usuarioDao.buscaPorId(usuarioId);
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public List<Usuario> getAutores() {
		return this.usuarioDao.listaTodos();
	}

	public String gravar() {

		if(this.usuario.getId() == null) {
			this.usuarioDao.adiciona(this.usuario);
		} else {
			this.usuarioDao.atualiza(this.usuario);
		}
			
		this.usuario = new Usuario();
		
		return "livro?faces-redirect=true ";
	}
	
	public void remover(Usuario autor) {
		this.usuarioDao.remove(autor);
	}
	
	public void carregar(Usuario autor) {
		this.usuario = autor;
	}
}
