package br.com.fin.control.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.fin.control.modelo.Usuario;

public class UsuarioDao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	EntityManager em;
	
	private DAO<Usuario> dao;
	
	@PostConstruct
	void init() {
		this.dao = new DAO<Usuario>(this.em, Usuario.class);
	}

	public boolean existe(Usuario usuario) {

		TypedQuery<Usuario> query = em.createQuery(
				" select u from Usuario u "
						+ " where u.email = :pEmail and u.senha = :pSenha",
				Usuario.class);

		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());
		try {
			@SuppressWarnings("unused")
			Usuario resultado = query.getSingleResult();
		} catch (NoResultException ex) {
			return false;
		}

		return true;
	}
	
	public void adiciona(Usuario t) {
		dao.adiciona(t);
	}

	public void atualiza(Usuario t) {
		dao.atualiza(t);
	}

	public Usuario buscaPorId(Integer id) {
		return dao.buscaPorId(id);
	}

	public void remove(Usuario t) {
		dao.remove(t);
	}

	public List<Usuario> listaTodos() {
		return dao.listaTodos();
	}

}
