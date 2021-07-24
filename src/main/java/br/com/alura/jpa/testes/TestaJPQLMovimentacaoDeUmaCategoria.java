package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TestaJPQLMovimentacaoDeUmaCategoria {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";

		Categoria categoria = new Categoria();
		categoria.setId(2L);
				
		TypedQuery<Movimentacao> cq = em.createQuery(jpql, Movimentacao.class);
		cq.setParameter("pCategoria", categoria);

		List<Movimentacao> list = cq.getResultList();

		for (Movimentacao movimentacao : list) {
			System.out.println(movimentacao.getCategoria());
			System.out.println(movimentacao.getDescricao() + " " + movimentacao.getTipoMovimentacao());
		}

	}
}
