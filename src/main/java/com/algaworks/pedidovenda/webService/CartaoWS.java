package com.algaworks.pedidovenda.webService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.algaworks.pedidovenda.model.Cartao;
import com.algaworks.pedidovenda.service.CartaoService;
import com.algaworks.pedidovenda.util.cdi.CDIServiceLocator;
import com.algaworks.pedidovenda.util.validation.CartaoEdicao;

@Path("/cartao")
public class CartaoWS implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@CartaoEdicao
	private CartaoService cartaoService; 
	
	public CartaoWS() {
		/*para gerenciar pelo cdi*/
		cartaoService = CDIServiceLocator.getBean(CartaoService.class);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response exibir(@PathParam(value = "id") int id){
		Response resposta;
		Cartao cartao = this.cartaoService.porId(id);
		
		if(cartao == null){
			resposta = Response.status(Status.NOT_FOUND).build(); // 404
		}else{
			resposta = Response.ok().entity(cartao).build();
		}
		
		return resposta;
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response exibir(){
		Response resposta;
		List<Cartao> cartoes = this.cartaoService.listarTodos();
		
		if(cartoes == null){
			resposta = Response.status(Status.NOT_FOUND).build(); // 404
		}else{
			resposta = Response.ok().entity(cartoes).build();
		}
		
		return resposta;
	}
	
	@GET
	@Path("/listacartao")
	public Response porId(){
		
		List<Cartao> lista = new ArrayList<>();
		
		Cartao c = new Cartao();
		c.setNomeCartao("ITAU");
		c.setBandeiraCartao("MASTER");
		c.setDiaVencimento(20);
		c.setMelhorDiaCartao(15);
		lista.add(c);
		
		Cartao c2 = new Cartao();
		c2.setNomeCartao("ITAU");
		c2.setBandeiraCartao("MASTER");
		c2.setDiaVencimento(20);
		c2.setMelhorDiaCartao(15);
		lista.add(c2);

		Cartao c3 = new Cartao();
		c3.setNomeCartao("ITAU");
		c3.setBandeiraCartao("MASTER");
		c3.setDiaVencimento(20);
		c3.setMelhorDiaCartao(15);
		lista.add(c3);
		
		Cartao c4 = new Cartao();
		c4.setNomeCartao("ITAU");
		c4.setBandeiraCartao("MASTER");
		c4.setDiaVencimento(20);
		c4.setMelhorDiaCartao(15);
		lista.add(c4);

		Response r = null;
		
		try {
			 
				r= Response.ok().entity(c).build();
 
		} catch (Exception e) {
				System.out.println("erro aqui");
		}
		
		return r;
	}
	
	
	
}
