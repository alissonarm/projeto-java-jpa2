package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraConta {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		// em.find -> pesquisa a conta com a chave primária 1L 
		Conta conta = em.find(Conta.class, 1L);
		Conta conta2 = em.find(Conta.class, 2L);
		System.out.println(conta.getId() + " " + conta.getTitular() );
		System.out.println(conta2.getId() + " " + conta2.getTitular() );
		
		em.getTransaction().begin();
		conta.setSaldo(100.0);
		conta2.setTitular("Mendonca");
		conta2.setSaldo(1000.0);
		conta2.setNumero(2523);
		em.getTransaction().commit();

	}

}

// A transação é um mecanismo para manter a consistência das alterações de estado no banco, 
// visto que todas as operações precisam ser executadas com sucesso, para que a transação seja confirmada.

// Estado Managed ou seja, gerenciado pela JPA:  Portanto, como os dados originais do banco são conhecidos, 
// quando fizermos qualquer alteração dentro dessa entidade e commitarmos a transação, haverá a sincronização automática.