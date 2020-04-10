package br.com.jcfilm.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import br.com.jcfilm.interfaces.IVendaQueryService;
import br.com.jcfilm.models.ItemVenda;
import br.com.jcfilm.models.Venda;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class VendaQueryDAOImpl implements IVendaQueryService{

	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public List<ItemVenda> ListaProdutosServicosVenda(int id) {
		// TODO Auto-generated method stub
		try {
			Query query = manager.createQuery("from ItemVenda where venda.id = :id")
					.setParameter("id", id);
			List<ItemVenda> itens = query.getResultList();
			return itens;	
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);		
		}finally{
			manager.close();
		}		
	}

	@Override
	@Transactional
	public int BuscaIdVendaCliente(int id) {
		// TODO Auto-generated method stub
		try {
			Query query = manager.createQuery("from Venda where cliente.id = :id and servico = :servico and situacao = :situacao")
				.setParameter("id", id)
				.setParameter("servico", true)
				.setParameter("situacao", false);
			List<Venda> vendas = query.getResultList();
			
			return vendas.get(0).getId();
				
		}catch (Exception e) {
			 throw new RuntimeException(e);			
		} finally {
			// TODO: handle finally clause
			manager.close();
		}
	}

	@Override
	@Transactional
	public List<Venda> PegarDadosVenda(int id) {
		// TODO Auto-generated method stub
		try {
			Query query = manager.createQuery("from Venda where id = :id")
					.setParameter("id", id);
			List<Venda> itens = query.getResultList();
			return itens;	
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);		
		}finally{
			manager.close();
		}		
	}

	@Override
	@Transactional
	public List<Venda> Vendas() {
		// TODO Auto-generated method stub
		try {
			Query query = manager.createQuery("from Venda");
			List<Venda> vendas = query.getResultList();
			return vendas;	
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);		
		}finally{
			manager.close();
		}		
	}

	@Override
	@Transactional
	public List<ItemVenda> ListaItensVendidos() {
		// TODO Auto-generated method stub
		try {
			Query query = manager.createQuery("from ItemVenda");
			List<ItemVenda> itens = query.getResultList();
			return itens;	
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);		
		}finally{
			manager.close();
		}		
	}

}
