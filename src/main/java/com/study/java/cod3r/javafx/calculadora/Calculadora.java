package com.study.java.cod3r.javafx.calculadora;

import javafx.scene.layout.VBox;

public class Calculadora extends VBox {

	public Calculadora() {
		BarraTitulo barraTitulo = new BarraTitulo();
		Display display = new Display();
		Teclado teclado = new Teclado();
		
		getStyleClass().add("com.study.java.cod3r.javafx.calculadora");
		
		getChildren().add(barraTitulo);
		getChildren().add(display);
		getChildren().add(teclado);
		
		teclado.noCliqueChame(texto -> {
			if(texto.equals("AC")) {
				display.limpar();
			} else {
				display.addTexto(texto);				
			}
		});
	}
}
