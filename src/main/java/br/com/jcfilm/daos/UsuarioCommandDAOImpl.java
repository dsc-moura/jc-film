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
	@Transactional
	public void update(Usuario usuario) {
		// TODO Auto-generated method stub
		try {
			manager.createQuery("Update Usuario set nome = :nome, sobrenome = :sobrenome, email = :email, ativo = :ativo  where id = :id")
			.setParameter("nome", usuario.getNome())
			.setParameter("sobrenome", usuario.getSobrenome())
			.setParameter("email", usuario.getEmail())
			.setParameter("ativo", usuario.isAtivo())
			.setParameter("id", usuario.getId())
			.executeUpdate();
		} finally {
			// TODO: handle finally clause
			manager.close();
		}	
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	@Transactional
	public void acesso(Acesso acesso) {
		// TODO Auto-generated method stub
		try {
			manager.persist(acesso);
		} finally {
			// TODO: handle finally clause
			manager.close();
		}
		
	}

	@Override
	@Transactional
	public void updateAcesso(Acesso acesso) {
		// TODO Auto-generated method stub
		try {
			manager.createQuery("Update Acesso set acesso = :acesso, senha = :senha  where usuario.id = :id")
			.setParameter("acesso", acesso.isAcesso())
			.setParameter("senha", acesso.getSenha())
			.setParameter("id", acesso.getUsuario().getId())
			.executeUpdate();
		} finally {
			// TODO: handle finally clause
			manager.close();
		}	
		
	}

	@Override
	@Transactional
	public void alteraStatus(int id, boolean status) {
		// TODO Auto-generated method stub
		try {
			manager.createQuery("Update Usuario set ativo = :ativo where id = :id")
			.setParameter("ativo", status)			
			.setParameter("id", id)
			.executeUpdate();
		} finally {
			// TODO: handle finally clause
			manager.close();
		}	
	}

	@Override
	@Transactional
	public void alteraPermissao(int id, boolean permissao) {
		// TODO Auto-generated method stub
		try {
			manager.createQuery("Update Acesso set acesso = :acesso where usuario.id = :id")
			.setParameter("acesso", permissao)					
			.setParameter("id", id)
			.executeUpdate();
		} finally {
			// TODO: handle finally clause
			manager.close();
		}			
	}

}
