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
	public List<Acesso> ListaAcessos() {
		try {
			Query query = manager.createQuery("from Acesso");
			List<Acesso> acessos = query.getResultList();
			return acessos;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);		
		}finally {
			// TODO: handle finally clause
			manager.close();
		}
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserDetails user = null;
		try {
			
			user = searchUser(email);
			return user;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);		
		}
	}
	

	@Override
	@Transactional
	public UserDetails searchUser(String email) {
		// TODO Auto-generated method stub
		try {	
			
			Query qUser = manager.createQuery("from Usuario where email = :email and ativo = :ativo")
					.setParameter("email", email)
					.setParameter("ativo", true);
			List<Usuario> usuarios = qUser.getResultList();
			
			
			Query qAcess = manager.createQuery("from Acesso where usuario.id = :id and acesso = :acesso")
					.setParameter("id", usuarios.get(0).getId())
					.setParameter("acesso", true);
			List<Acesso> acessos = qAcess.getResultList();
		
			/*
			Acesso acesso = new Acesso();
			Usuario usuario = new Usuario();
			
			usuario.setNome("Daniel");
			usuario.setEmail("");
			acesso.setSenha("$2a$10$jdQpiR35ZZVdrFQYUW7q/evtl1Xr6ED3y.pIzukdgzvF0PIBtrmzS");
			acesso.setAcesso(true);
			acesso.setUsuario(usuario);
					
			return new UsuarioDetails(acesso.getUsuario().getNome(), acesso.getUsuario().getEmail(), acesso.getSenha(), acesso.isAcesso());
			*/
			return new UsuarioDetails(acessos.get(0).getUsuario().getNome(), acessos.get(0).getUsuario().getEmail(), acessos.get(0).getSenha(), acessos.get(0).isAcesso());
	
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);		
		} finally {
			// TODO: handle finally clause
			manager.close();
		}
	}
	
	

}
