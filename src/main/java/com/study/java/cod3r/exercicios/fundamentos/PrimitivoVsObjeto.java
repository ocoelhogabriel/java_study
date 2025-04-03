package com.study.java.cod3r.exercicios.fundamentos;

public class PrimitivoVsObjeto {

	public static void main(String[] args) {
		
		String s = new String("texto");
		s.toUpperCase();
		
		// Wrappers são a versão objeto dos tipos
		// primitivos!
		int a = 123;
		System.out.println(a);
	}
}
