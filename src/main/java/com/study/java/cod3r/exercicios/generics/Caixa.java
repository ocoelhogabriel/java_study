package com.study.java.cod3r.exercicios.generics;

public class Caixa<T> {
	
	private T coisa;
	
	public void guardar(T coisa) {
		this.coisa = coisa;
	}
	
	public T abrir() {
		return coisa;
	}
}
