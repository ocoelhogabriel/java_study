package com.study.java.cod3r.jpa.teste.umpramuitos;

import com.study.java.cod3r.jpa.infra.DAO;
import com.study.java.cod3r.jpa.modelo.basico.Produto;
import com.study.java.cod3r.jpa.modelo.umpramuitos.ItemPedido;
import com.study.java.cod3r.jpa.modelo.umpramuitos.Pedido;

public class NovoPedido {

	public static void main(String[] args) {
		
		DAO<Object> dao = new DAO<>();
		
		Pedido pedido = new Pedido();
		Produto produto = new Produto("Geladeira", 2789.99);
		ItemPedido item = new ItemPedido(pedido, produto, 10);
		
		dao.abrirT()
			.incluir(produto)
			.incluir(pedido)
			.incluir(item)
			.fecharT()
			.fechar();
	}
}
