package br.com.jcfilm.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jcfilm.interfaces.IProdutoQueryService;
import br.com.jcfilm.models.Produto;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class ProdutoQueryDAOImpl implements IProdutoQueryService{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public List<Produto> ListaProdutos() {
		// TODO Auto-generated method stub
		try {
			Query query = manager.createQuery("from Produto");
			List<Produto> produtos = query.getResultList();
			return produtos;
		}finally{
			manager.close();
		}
	}

}
