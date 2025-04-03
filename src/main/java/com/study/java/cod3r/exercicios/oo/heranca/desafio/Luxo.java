package com.study.java.cod3r.exercicios.oo.heranca.desafio;

public interface Luxo {

	public void ligarAr();
	abstract void desligarAr();
	
	default int velocidadeDoAr() {
		return 1;
	}
}
