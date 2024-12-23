package com.lucas.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped // Define que esta classe terá uma única instância compartilhada durante todo o ciclo de vida da aplicação.
public class EntityManagerProducer {

    private EntityManagerFactory factory;

    public EntityManagerProducer() {
        // Inicializa a fábrica de gerenciadores de entidade (EntityManagerFactory) com a unidade de persistência configurada.
        this.factory = Persistence.createEntityManagerFactory("Curso-JSF");
    }

    @Produces
    @RequestScoped // Garante que cada requisição HTTP tenha sua própria instância de EntityManager.
    public EntityManager createEntityManager() {
        // Cria e retorna um EntityManager para operações de banco de dados.
        return this.factory.createEntityManager();
    }

    public void closeEntityManager(@Disposes EntityManager manager) {
        // Fecha o EntityManager automaticamente quando ele não for mais necessário.
        manager.close();
    }
}

