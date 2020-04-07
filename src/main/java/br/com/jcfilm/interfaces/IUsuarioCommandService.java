package br.com.jcfilm.interfaces;

import br.com.jcfilm.models.Acesso;
import br.com.jcfilm.models.Usuario;

public interface IUsuarioCommandService {
	int create(Usuario usuario);
	void update(Usuario usuario);
	void acesso(Acesso acesso);
	void alteraStatus(int id, boolean status);
	void alteraPermissao(int id, boolean permissao);
	void updateAcesso(Acesso acesso);
	void delete(int id);
}
