//package br.com.fin.control.dao;
//
//import java.io.Serializable;
//
//import javax.annotation.PostConstruct;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import br.com.fin.control.modelo.Usuario;
//
//public class PopulaBanco implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@PersistenceContext
//	EntityManager em;
//	
//	private DAO<Usuario> dao;
//	
//	@PostConstruct
//	void init() {
//		this.dao = new DAO<Usuario>(this.em, Usuario.class);
//	}
//	
//	public void adiciona() {
//		
//		Usuario admin = new Usuario("admin@gmail.com", "admin");	
//		dao.adiciona(admin);
//	}
//	
//}
