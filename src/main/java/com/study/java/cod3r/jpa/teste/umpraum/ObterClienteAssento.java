package com.study.java.cod3r.jpa.teste.umpraum;

import com.study.java.cod3r.jpa.infra.DAO;
import com.study.java.cod3r.jpa.modelo.umpraum.Assento;
import com.study.java.cod3r.jpa.modelo.umpraum.Cliente;

public class ObterClienteAssento {

	public static void main(String[] args) {
		
		DAO<Cliente> daoCliente = new DAO<>(Cliente.class);
		
		Cliente cliente = daoCliente.obterPorID(1L);
		System.out.println(cliente.getAssento().getNome());

		daoCliente.fechar();
		
		
		DAO<Assento> daoAssento = new DAO<>(Assento.class);
		
		Assento assento = daoAssento.obterPorID(4L);
		System.out.println(assento.getCliente().getNome());
		
		daoAssento.fechar();
	}
}
