package br.com.jcfilm.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import br.com.jcfilm.interfaces.IUsuarioCommandService;
import br.com.jcfilm.models.Acesso;
import br.com.jcfilm.models.Usuario;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class UsuarioCommandDAOImpl implements IUsuarioCommandService{


	@PersistenceContext
	private EntityManager manager;
	
	@Override
	@Transactional
	public int create(Usuario usuario) {
		// TODO Auto-generated method stub
		try {
			manager.persist(usuario);
			return usuario.getId();
		}catch (Exception e) {
			// TODO: handle exception
			return 0;
		} finally {
			// TODO: handle finally clause
			manager.close();
		}
		
	}

	@Override
	public void update(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void atribuirAcesso(Acesso acesso) {
		// TODO Auto-generated method stub
		try {
			manager.persist(acesso);
		} finally {
			// TODO: handle finally clause
			manager.close();
		}
	}

	@Override
	public void retirarAcesso(Acesso acesso) {
		// TODO Auto-generated method stub
		
	}

}
