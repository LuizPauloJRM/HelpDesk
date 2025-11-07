package com.helpdesk.erp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe responsável por criar e fornecer instâncias de EntityManager.
 * O EntityManager é usado para executar operações no banco (insert, update, delete, select).
 */
public class JPAUtil {

    // Nome do persistence-unit definido no persistence.xml
    private static final String PERSISTENCE_UNIT = "helpdesk";

    // Fábrica de EntityManagers (criada uma única vez durante a execução da aplicação)
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

    /**
     * Retorna uma nova instância de EntityManager.
     * Cada requisição deve abrir e fechar seu próprio EntityManager.
     */
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Fecha a fábrica de EntityManagers (geralmente chamado ao encerrar o servidor).
     */
    public static void close() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
