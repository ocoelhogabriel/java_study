package com.study.java.cod3r.jpa.teste.basico;

import com.study.java.cod3r.jpa.modelo.basico.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AlterarUsuario2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 7L);
        usuario.setNome("Leonardo Leitao");

        // em.merge(usuario);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
