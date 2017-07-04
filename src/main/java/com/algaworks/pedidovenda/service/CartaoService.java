package com.algaworks.pedidovenda.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.pedidovenda.model.Cartao;
import com.algaworks.pedidovenda.repository.CartaoDAO;
import com.algaworks.pedidovenda.util.jpa.Transactional;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

public class CartaoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CartaoDAO cartaoDAO;

	@Transactional
	public Cartao salvar(Cartao cartao) {

		if (cartao != null) {
			this.cartaoDAO.salvar(cartao);
			FacesUtil.InfoMessage("Cartao cadastrada com sucesso");
		} else {
			FacesUtil.ErrorMessage("Erro ao tentar cadastrar cartao");
		}

		return cartao;
	}

	public List<Cartao> listarTodos() {
		return cartaoDAO.listarTodos();
	}

	public Cartao porId(Integer id){
		return this.cartaoDAO.porId(id);
	}
	
	
	
	

}
