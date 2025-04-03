package com.study.java.cod3r.campominado;

import com.study.java.cod3r.campominado.modelo.Tabuleiro;
import com.study.java.cod3r.campominado.visao.TabuleiroConsole;

public class CampoMinadoAplicacao {

    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 3);
        new TabuleiroConsole(tabuleiro);
    }
}
