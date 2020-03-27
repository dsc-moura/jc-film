package br.com.jcfilm.interfaces;

import br.com.jcfilm.models.Usuario;

public interface IUsuarioCommandService {
	void create(Usuario usuario);
	void update(Usuario usuario);
	void delete(int id);
}
