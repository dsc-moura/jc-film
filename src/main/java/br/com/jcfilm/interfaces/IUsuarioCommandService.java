package br.com.jcfilm.interfaces;

import br.com.jcfilm.models.Acesso;
import br.com.jcfilm.models.Usuario;

public interface IUsuarioCommandService {
	int create(Usuario usuario);
	void update(Usuario usuario);
	void atribuirAcesso(Acesso acesso);
	void retirarAcesso(Acesso acesso);
	void delete(int id);
}
