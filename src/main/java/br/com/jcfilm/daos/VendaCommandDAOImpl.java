package br.com.jcfilm.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import br.com.jcfilm.interfaces.IVendaCommnadService;
import br.com.jcfilm.models.ItemVenda;
import br.com.jcfilm.models.Venda;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class VendaCommandDAOImpl implements IVendaCommnadService{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public int InciarProcessoVenda(Venda venda) {
		// TODO Auto-generated method stub
		try {
			manager.persist(venda);
			return venda.getId();
		}catch (Exception e) {
			// TODO: handle exception
			 throw new RuntimeException(e);
		}finally{
			manager.close();
		}			
	}

	@Override
	@Transactional
	public void InserirProdutosServicosVenda(ItemVenda item) {
		// TODO Auto-generated method stub
		try {
			manager.persist(item);
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
	public void ExcluirItemListaCompra(int id) {
		// TODO Auto-generated method stub
		try {
			manager.createQuery("delete from ItemVenda where id = :id")
			.setParameter("id", id)
			.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);		
		} finally {
			// TODO: handle finally clause
			manager.close();
		}
		
	}

	@Override
	@Transactional
	public void ExcluirItensCarrinhoCompra(int id) {
		// TODO Auto-generated method stub
		try {
			manager.createQuery("delete from ItemVenda where id_venda = :id")
			.setParameter("id", id)
			.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);		
		} finally {
			// TODO: handle finally clause
			manager.close();
		}
	}

	@Override
	@Transactional
	public void UpdateQuantidade(int id, int quantidade) {
		// TODO Auto-generated method stub
		try {
			manager.createQuery("Update ItemVenda set quantidade = :quantidade  where id = :id")
			.setParameter("quantidade", quantidade)
			.setParameter("id", id)
			.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);		
		} finally {
			// TODO: handle finally clause
			manager.close();
		}
		
	}

	@Override
	@Transactional
	public void FinalizarVenda(Venda venda) {
		// TODO Auto-generated method stub
		try {
			manager.createQuery("Update Venda set situacao = :situacao, prazo = :prazo, tempo = :tempo  where id = :id")
			.setParameter("situacao", venda.isSituacao())
			.setParameter("prazo", venda.getPrazo())
			.setParameter("tempo", venda.getTempo())
			.setParameter("id", venda.getId())
			.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);		
		} finally {
			// TODO: handle finally clause
			manager.close();
		}
	}

	@Override
	@Transactional
	public void ExcluirVenda(int id) {
		// TODO Auto-generated method stub		
		try {
			manager.createQuery("delete from Venda where id = :id")
			.setParameter("id", id)
			.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);		
		} finally {
			// TODO: handle finally clause
			manager.close();
		}
	}

}
