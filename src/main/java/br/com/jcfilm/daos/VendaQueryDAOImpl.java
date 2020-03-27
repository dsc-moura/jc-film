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
			Query query = manager.createQuery("from ItemVenda where id_venda = :id")
					.setParameter("id", id);
			List<ItemVenda> itens = query.getResultList();
			return itens;	
		}finally{
			manager.close();
		}		
	}

	@Override
	@Transactional
	public int BuscaIdVendaCliente(int id) {
		// TODO Auto-generated method stub
		try {
			Query query = manager.createQuery("Select v.id from Venda v where v.cliente.id = :id and v.servico = 1 and v.situacao = 0")
					.setParameter("id", id);
				return (int) query.getResultList().get(0);
				
		}catch (Exception e) {
					// TODO: handle exception
			return 0;
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
		}finally{
			manager.close();
		}		
	}

}
