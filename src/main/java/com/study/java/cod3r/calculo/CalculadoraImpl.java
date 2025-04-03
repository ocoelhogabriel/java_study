package com.study.java.cod3r.calculo;

import com.study.java.cod3r.calculadora.Calculadora;
import com.study.java.cod3r.calculo.interno.OperacoesAritmeticas;
import com.study.java.cod3r.logging.Logger;

public class CalculadoraImpl implements Calculadora {
	
	private String id = "abc";

	private OperacoesAritmeticas opAritmeticas = new OperacoesAritmeticas();

	public double soma(double... nums) {
		Logger.info("Somando...");
		return opAritmeticas.soma(nums);
	}

	public String getId() {
		return id;
	}
}
