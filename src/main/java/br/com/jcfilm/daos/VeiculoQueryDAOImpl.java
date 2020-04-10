package br.com.jcfilm.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jcfilm.interfaces.IVeiculoQueryService;
import br.com.jcfilm.models.Veiculo;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class VeiculoQueryDAOImpl implements IVeiculoQueryService{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public List<Veiculo> ListaVeiculos() {
		// TODO Auto-generated method stub
		try {
			Query query = manager.createQuery("from Veiculo");
			List<Veiculo> Veiculos = query.getResultList();
			return Veiculos;	
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);		
		}finally{
			manager.close();
		}
	}
}
