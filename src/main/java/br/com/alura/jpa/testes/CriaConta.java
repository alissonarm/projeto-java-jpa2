package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setTitular("Carlos");
		conta.setNumero(1220);
		conta.setAgencia(446);
		conta.setSaldo(50.0);
		
		//Buscar o em.getTransaction() e iniciar a transa��o chamando o m�todo begin(). Depois, faremos o commit().
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		
		//O estado Detached - com o close a conta deixou de ser gerenciada(Managed).
		em.close();
		
		EntityManager em2 = emf.createEntityManager();
		conta.setSaldo(3000.0);

		// transforma nova a conta de Detached(n�o gerenciada) em Managed(gerenciada);
		
		em2.getTransaction().begin();
		em2.merge(conta);
		em2.getTransaction().commit();
		
		
	}

}

// A transa��o � um mecanismo para manter a consist�ncia das altera��es de estado no banco, 
// visto que todas as opera��es precisam ser executadas com sucesso, para que a transa��o seja confirmada.

