package br.com.fin.control.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fin.control.modelo.Meta;

public class MetaDao implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	EntityManager em;
	
	private DAO<Meta> dao;
	
	@PostConstruct
	void init() {
		this.dao = new DAO<Meta>(this.em, Meta.class);
	}

	public void adiciona(Meta t) {
		dao.adiciona(t);
	}

	public void atualiza(Meta t) {
		dao.atualiza(t);
	}

	public Meta buscaPorId(Integer id) {
		return dao.buscaPorId(id);
	}

	public void remove(Meta t) {
		dao.remove(t);
	}

	public List<Meta> listaTodos() {
		return dao.listaTodos();
	}

}
