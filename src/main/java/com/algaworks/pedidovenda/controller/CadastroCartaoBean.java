package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.text.ParseException;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Cartao;
import com.algaworks.pedidovenda.service.CartaoService;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@SessionScoped
public class CadastroCartaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cartao cartao;

	@Inject
	private CartaoService cartaoService;
	
	public CadastroCartaoBean(){
		this.limpar();
	}
	
	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
		}
	}

	private void limpar() {
		this.cartao = new Cartao();
	}
	
	public void salvar() throws ParseException{
		this.cartaoService.salvar(cartao);
		this.limpar();
	}

	
	//get and set
	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

}
