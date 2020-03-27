package br.com.jcfilm.interfaces;

import br.com.jcfilm.models.Produto;

public interface IProdutoCommandService {
	void create(Produto produto);
	void update(Produto produto);
	void delete(int id);
}
