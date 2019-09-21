package br.com.fin.control.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fin.control.dao.MetaDao;
import br.com.fin.control.dao.UsuarioDao;
import br.com.fin.control.modelo.Meta;
import br.com.fin.control.modelo.Usuario;

@Named
@ViewScoped
public class MetaBean implements Serializable {
    private static final long serialVersionUID = 1L;

	private Meta meta = new Meta();
	private Integer usuarioId;
	private Integer metaId;
	
	@Inject
	private MetaDao metaDao;
	
	@Inject
	private UsuarioDao usuarioDao;
	
	@Inject
	private FacesContext context;

	private List<Meta> metas;

	public List<Meta> getMetas() {
				
		if(this.metas == null) {
			this.metas = metaDao.listaTodos();
		}	
		return metas;
	}
	
	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Integer getMetaId() {
		return metaId;
	}

	public void setMetaId(Integer metaId) {
		this.metaId = metaId;
	}

	public void gravar() {

		if (meta.getUsuarios().isEmpty()) {
			context.addMessage("usuario", new FacesMessage("A meta deve ser associada a pelo menos um usuario"));
			return;
		}

		if(this.meta.getId() == null) {
			metaDao.adiciona(this.meta);
			this.metas = metaDao.listaTodos();
		} else {
			metaDao.atualiza(this.meta);
			this.metas = metaDao.listaTodos();
		}
		
		this.meta = new Meta();	
	}
	
	public void remover(Meta meta) {
		
		this.metaDao.remove(meta);
		this.metas = metaDao.listaTodos();
	}
	
	public void removerUsuarioDaMeta(Usuario usuario) {
		
		this.meta.removeUsuario(usuario);
	}
	
	public void carregar(Meta meta) {
		
		this.meta = this.metaDao.buscaPorId(meta.getId());
	}
	
	public void gravarUsuario() {
		
		Usuario Usuario = this.usuarioDao.buscaPorId(this.usuarioId);
		this.meta.adicionaUsuario(Usuario);
	}
	
	public List<Usuario> getUsuarioesDometa() {
		
		return this.meta.getUsuarios();
	}
	
	public String formUsuario() {
		
		return "Usuario?faces-redirect=true";
	}

}
