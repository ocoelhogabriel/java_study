package com.study.java.cod3r.jpa.teste.basico;

import com.study.java.cod3r.jpa.modelo.basico.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class AlterarUsuario1 {
    @PersistenceContext
    private static EntityManager em;

    public static void main(String[] args) {
        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 7L);
        usuario.setNome("Leonardo");
        usuario.setEmail("leonardo@lanche.com.br");

        em.merge(usuario);

        em.getTransaction().commit();

        em.close();
    }
}
