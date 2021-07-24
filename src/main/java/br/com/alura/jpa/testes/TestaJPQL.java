package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TestaJPQL {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setId(2L);

//        String query = "select * from movimentacao where conta_id =2";
//        String jpql  = "select m from Movimentacao m where m.conta.id =2";

		String jpql = "select m from Movimentacao m where m.conta=:pConta order by m.valor desc";

		TypedQuery<Movimentacao> cq = em.createQuery(jpql, Movimentacao.class);
		cq.setParameter("pConta", conta);

		List<Movimentacao> list = cq.getResultList();

		for (Movimentacao movimentacao : list) {
			System.out.println(movimentacao.getDescricao() + " " + movimentacao.getTipoMovimentacao());
		}

	}
}
