package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Cartao;
import com.algaworks.pedidovenda.service.CartaoService;

@Named
@ViewScoped
public class PesquisaCartaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CartaoService cartaoService;

	private Cartao cartaoSelecionado;

	private List<Cartao> listaCartao = new ArrayList<Cartao>();


	public PesquisaCartaoBean() {
	}

	public void pesquisar() {
		this.listaCartao = cartaoService.listarTodos();
	}
	
	
	// GET AND SET
	public List<Cartao> getListaCartao() {
		return listaCartao;
	}

	public void setListaCartao(List<Cartao> listaCartao) {
		this.listaCartao = listaCartao;
	}

	public Cartao getCartaoSelecionado() {
		return cartaoSelecionado;
	}
}
