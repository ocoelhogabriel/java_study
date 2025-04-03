package com.study.java.cod3r.exercicios.generics;

public class CaixaObjeto {
	
	private Object coisa;
	
	public void guardar(Object coisa) {
		this.coisa = coisa;
	}
	
	public Object abrir() {
		return coisa;
	}
}
