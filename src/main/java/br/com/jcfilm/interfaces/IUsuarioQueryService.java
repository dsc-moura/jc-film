package br.com.jcfilm.interfaces;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.jcfilm.models.Acesso;
import br.com.jcfilm.models.Usuario;

public interface IUsuarioQueryService extends UserDetailsService {
	List<Usuario> ListaUsuarios();
	List<Acesso> ListaAcessos();
	UserDetails searchUser (String email);
}
