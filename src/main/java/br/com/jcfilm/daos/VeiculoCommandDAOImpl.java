package br.com.jcfilm.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import br.com.jcfilm.interfaces.IVeiculoCommandService;
import br.com.jcfilm.models.ClienteVeiculo;
import br.com.jcfilm.models.Veiculo;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class VeiculoCommandDAOImpl implements IVeiculoCommandService{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	@Transactional
	public void create(Veiculo veiculo) {
		// TODO Auto-generated method stub
		try {
			manager.persist(veiculo);
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
	public void update(Veiculo veiculo) {
		// TODO Auto-generated method stub
		try {
			manager.createQuery("update Veiculo set nome = :nome, id_marca = :id_marca where id=:id")
			.setParameter("nome", veiculo.getNome())
			.setParameter("id_marca", veiculo.getMarca().getId())
			.setParameter("id", veiculo.getId())
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
			manager.createQuery("delete from Veiculo where id = :id")
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
