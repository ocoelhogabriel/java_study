package com.study.java.cod3r.exercicios.oo.abstrato;

public class Cachorro extends Mamifero {
	
	@Override
	public String mover() {
		return "Usando as patas";
	}
	
	@Override
	public String mamar() {
		return "Usando leite";
	}
}
