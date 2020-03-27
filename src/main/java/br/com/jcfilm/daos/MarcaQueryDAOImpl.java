package br.com.jcfilm.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jcfilm.interfaces.IMarcaQueryService;
import br.com.jcfilm.models.Marca;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class MarcaQueryDAOImpl implements IMarcaQueryService {

	@PersistenceContext
	private EntityManager manager;
		
	@Override
	@Transactional
	public List<Marca> lista() {
		// TODO Auto-generated method stub
		try {
			Query query = manager.createQuery("from Marca");
			List<Marca> marcas = query.getResultList();
			return marcas;
		} finally {
			// TODO: handle finally clause
			manager.close();
		}
		
	}

}
