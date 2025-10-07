package br.senac.sp.sus.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FactoryEM {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("senac");
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
