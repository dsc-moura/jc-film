package br.com.jcfilm.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.jcfilm.interfaces.IUsuarioQueryService;
import br.com.jcfilm.models.Acesso;
import br.com.jcfilm.models.Marca;
import br.com.jcfilm.models.Usuario;
import br.com.jcfilm.models.UsuarioDetails;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class UsuarioQueryDAOImpl implements IUsuarioQueryService, UserDetailsService{

	private static final Logger logger = Logger.getLogger(UsuarioDetails.class.getSimpleName());
	
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
	@Transactional
	public List<Acesso> ListaAcessos() {
		try {
			Query query = manager.createQuery("from Acesso");
			List<Acesso> acessos = query.getResultList();
			return acessos;
		} finally {
			// TODO: handle finally clause
			manager.close();
		}
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserDetails user = null;
		try {
			user = searchUser(email);
			//user.getAuthorities().add(null);
			return user;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		//return null;
	}

	@Override
	@Transactional
	public UserDetails searchUser(String email) {
		// TODO Auto-generated method stub
		try {
			Query qUser = manager.createQuery("from Usuario where email = :email and ativo = 1")
					.setParameter("email", email);
			List<Usuario> usuarios = qUser.getResultList();
			
			Query qAcess = manager.createQuery("from Acesso where usuario.id = :id and acesso = 1")
					.setParameter("id", usuarios.get(0).getId());
			List<Acesso> acessos = qAcess.getResultList();
			
			return new UsuarioDetails(acessos.get(0).getUsuario().getNome(), acessos.get(0).getUsuario().getEmail(), acessos.get(0).getSenha(), acessos.get(0).isAcesso());
			
		} finally {
			// TODO: handle finally clause
			manager.close();
		}
	}
	
	

}
