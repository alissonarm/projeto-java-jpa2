package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraConta {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		// em.find -> pesquisa a conta com a chave prim�ria 1L 
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

// A transa��o � um mecanismo para manter a consist�ncia das altera��es de estado no banco, 
// visto que todas as opera��es precisam ser executadas com sucesso, para que a transa��o seja confirmada.

// Estado Managed ou seja, gerenciado pela JPA:  Portanto, como os dados originais do banco s�o conhecidos, 
// quando fizermos qualquer altera��o dentro dessa entidade e commitarmos a transa��o, haver� a sincroniza��o autom�tica.