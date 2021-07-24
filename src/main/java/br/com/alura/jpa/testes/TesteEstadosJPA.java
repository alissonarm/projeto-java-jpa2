package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TesteEstadosJPA {
	
	public static void main(String[] args) {
		
		//Transient - Objeto desvinculado
		Conta conta = new Conta();
		conta.setTitular("Patricia");
		conta.setAgencia(1606);
		conta.setNumero(1015);
		conta.setSaldo(100.0);
		 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		// trasforma o estado de Transient -> Managed
		em.persist(conta);
		
		//Managed -> Removed
		em.remove(conta);
		
		em.getTransaction().commit();
		
	}

}


// Removed: A entidade nesse estado possui um ID, apesar de n�o existir sincroniza��o autom�tica e n�o possuir registro no banco