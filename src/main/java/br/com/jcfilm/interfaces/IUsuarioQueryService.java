package br.com.jcfilm.interfaces;

import java.util.List;

import br.com.jcfilm.models.Acesso;
import br.com.jcfilm.models.Usuario;

public interface IUsuarioQueryService {
	List<Usuario> ListaUsuarios();
	List<Acesso> ListaAcessos();
}
