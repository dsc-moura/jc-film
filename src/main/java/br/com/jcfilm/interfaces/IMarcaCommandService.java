package br.com.jcfilm.interfaces;

import br.com.jcfilm.models.Marca;

public interface IMarcaCommandService {
	void create(Marca marca);
	void update(Marca marca);
	void delete(int id);
}
