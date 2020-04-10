package br.com.jcfilm.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import br.com.jcfilm.interfaces.IProdutoCommandService;
import br.com.jcfilm.models.Produto;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class ProdutoCommandDAOImpl implements IProdutoCommandService {

	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public void create(Produto produto) {
		// TODO Auto-generated method stub
		try {
			manager.persist(produto);
			//return true;
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);		
		}finally{
			manager.close();
		}		
	}

	@Override
	@Transactional
	public void update(Produto produto) {
		// TODO Auto-generated method stub
		try {
			manager.createQuery("update Produto"
					+ " set "
					+ " preco = :preco"
					+ " ,nome = :nome"
					+ " where id = :id"
					)
			.setParameter("preco", produto.getPreco())
			.setParameter("nome", produto.getNome())
			.setParameter("id", produto.getId())
			.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);		
		}finally {
			manager.close();
		}		
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			manager.createQuery("delete from Produto where id = :id")
			.setParameter("id", id)
			.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);		
		}finally {
			manager.close();
		}		
	}
}
