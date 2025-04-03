package com.study.java.cod3r.javafx.fxml;

import org.controlsfx.control.Notifications;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginControlador {

    @FXML
    private TextField campoEmail;

    @FXML
    private PasswordField campoSenha;

    public void entrar() {
        if (campoEmail == null || campoSenha == null) {
            System.err.println("Campos não injetados corretamente pelo FXML.");
            return;
        }

        String email = campoEmail.getText();
        String senha = campoSenha.getText();

        boolean emailValido = "aluno@cod3r.com.br".equalsIgnoreCase(email);
        boolean senhaValida = "12345678".equalsIgnoreCase(senha);

        if (emailValido && senhaValida) {
            Notifications.create().position(Pos.TOP_RIGHT).title("Login FXML").text("Login efetuado com sucesso!").showInformation();
        } else {
            Notifications.create().position(Pos.TOP_RIGHT).title("Login FXML").text("Usuário e Senha inválidos!").showError();
        }
    }

}
