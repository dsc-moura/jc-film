package br.com.jcfilm.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jcfilm.interfaces.IMarcaCommandService;
import br.com.jcfilm.models.Marca;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class MarcaCommandDAOImpl implements IMarcaCommandService{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	@Transactional
	public void create(Marca marca) {
		// TODO Auto-generated method stub
		try {
			manager.persist(marca);
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);		
		}finally{
			manager.close();
		}			
	}

	@Override
	@Transactional
	public void update(Marca marca) {
		// TODO Auto-generated method stub
		try {
			manager.createQuery("update Marca set nome = :nome where id=:id")
			.setParameter("nome", marca.getNome())
			.setParameter("id", marca.getId())
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
			manager.createQuery("delete from Marca where id = :id")
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
