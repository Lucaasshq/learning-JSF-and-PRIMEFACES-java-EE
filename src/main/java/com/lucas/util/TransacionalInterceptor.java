package com.lucas.util;

import java.io.Serializable;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Interceptor // Marca esta classe como um interceptor.
@Transacional // Associa o interceptor a métodos ou classes anotadas com @Transacional.
@Priority(Interceptor.Priority.APPLICATION) // Define a prioridade de execução do interceptor.
public class TransacionalInterceptor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject // Injeta a dependência do EntityManager para manipular transações.
    private EntityManager manager;

    @AroundInvoke // Define que este método será executado antes e depois de um método anotado com @Transacional.
    public Object invoke(InvocationContext context) throws Exception {
        EntityTransaction trx = manager.getTransaction(); // Obtém a transação do EntityManager.
        boolean criador = false; // Flag para identificar se o interceptor criou a transação.

        try {
            if (!trx.isActive()) { // Verifica se a transação está ativa.
                trx.begin(); // Inicia uma nova transação.
                trx.rollback(); // Desfaz qualquer transação anterior.
                
                trx.begin(); // Inicia uma nova transação limpa.
                criador = true; // Marca que o interceptor iniciou a transação.
            }
            return context.proceed(); // Executa o método interceptado.
        } catch (Exception e) {
            if (trx != null && criador) { // Verifica se a transação foi criada pelo interceptor.
                trx.rollback(); // Desfaz a transação em caso de erro.
            }
            throw e; // Relança a exceção.
        } finally {
            if (trx != null && trx.isActive() && criador) { // Verifica se a transação ainda está ativa.
                trx.commit(); // Confirma a transação ao final do método.
            }
        }
    }
}
