package br.com.fin.control.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class MenuBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer index=0;
	
	public Integer getIndex() {
		return index;
	}
	
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public String paginaLivros() {
		this.index = 0;
		return "livro?faces-redirect=true";
	}
	
	public String paginaAutores() {
		this.index = 1;
		return "autor?faces-redirect=true";
	}

	public String paginaVendas() {
		this.index = 2;
		return "vendas?faces-redirect=true";
	}
}
