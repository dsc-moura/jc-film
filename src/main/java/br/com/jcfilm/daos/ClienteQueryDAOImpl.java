package br.com.jcfilm.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import br.com.jcfilm.interfaces.IClienteQueryService;
import br.com.jcfilm.models.Cliente;
import br.com.jcfilm.models.ClienteVeiculo;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class ClienteQueryDAOImpl  implements IClienteQueryService{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public List<Cliente> BuscaCliente(String cpf) {
		// TODO Auto-generated method stub
		try {
			Query query = manager.createQuery("from Cliente where cpf = :cpf")
					.setParameter("cpf", cpf);	
			List<Cliente> clientes = query.getResultList();
			return clientes;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);		
		}finally {
			// TODO: handle finally clause
		}
		
	}

	@Override
	@Transactional
	public List<Cliente> ListaClientes() {
		// TODO Auto-generated method stub
		try {
			Query query = manager.createQuery("from Cliente");
			List<Cliente> clientes = query.getResultList();
			return clientes;
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
	public List<Cliente> BuscaCliente(int id) {
		// TODO Auto-generated method stub
		try {
			Query query = manager.createQuery("from Cliente where id = :id")
					.setParameter("id", id);	
			List<Cliente> clientes = query.getResultList();
			return clientes;
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
	public List<ClienteVeiculo> ListaVeiculosCliente(int id) {
		// TODO Auto-generated method stub
		try {
			Query query = manager.createQuery("from ClienteVeiculo where id_cliente = :id")
					.setParameter("id", id);	
			List<ClienteVeiculo> clientes = query.getResultList();
			return clientes;
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);	
		}  finally {
			// TODO: handle finally clause
			manager.close();
		}		
	}

	@Override
	@Transactional
	public List<ClienteVeiculo> BuscaDetalheVeiculoCliente(int id) {
		// TODO Auto-generated method stub
		try {
			Query query = manager.createQuery("from ClienteVeiculo where id = :id")
					.setParameter("id", id);	
			List<ClienteVeiculo> clientes = query.getResultList();
			return clientes;
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);	
		} finally {
			// TODO: handle finally clause
			manager.close();
		}		
	}
}
