package com.study.java.cod3r.jpa.teste.consulta;

import java.util.List;

import com.study.java.cod3r.jpa.infra.DAO;
import com.study.java.cod3r.jpa.modelo.muitospramuitos.Ator;
import com.study.java.cod3r.jpa.modelo.muitospramuitos.Filme;

public class ObterFilmes {

	public static void main(String[] args) {
		
		DAO<Filme> dao = new DAO<>(Filme.class);
		List<Filme> filmes = dao.consultar(
				"obterFilmesComNotaMaiorQue", "nota", 8.5);
		
		for(Filme filme: filmes) {
			System.out.println(filme.getNome() 
					+ " => " + filme.getNota());
			
			for(Ator ator: filme.getAtores()) {
				System.out.println(ator.getNome());
			}
		}
	}
}
