package br.com.jcfilm.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import br.com.jcfilm.interfaces.IUsuarioQueryService;
import br.com.jcfilm.models.Acesso;
import br.com.jcfilm.models.Marca;
import br.com.jcfilm.models.Usuario;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class UsuarioQueryDAOImpl implements IUsuarioQueryService{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	@Transactional
	public List<Usuario> ListaUsuarios() {
		// TODO Auto-generated method stub
		try {
			Query query = manager.createQuery("from Usuario");
			List<Usuario> usuarios = query.getResultList();
			return usuarios;
		} finally {
			// TODO: handle finally clause
			manager.close();
		}
	}

	@Override
	public List<Acesso> ListaAcessos() {
		// TODO Auto-generated method stub
		return null;
	}

}
