package com.algaworks.pedidovenda.util.validation;

import com.algaworks.pedidovenda.model.Cartao;

public class CartaoAlteradoEvent {
	
	private Cartao cartao;
	
	public CartaoAlteradoEvent(Cartao cartao){
	  this.cartao = cartao;	
	}
	
	public Cartao getPedido() {
		return cartao;
	}

}
