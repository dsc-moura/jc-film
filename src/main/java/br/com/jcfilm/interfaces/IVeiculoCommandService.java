package br.com.jcfilm.interfaces;

import br.com.jcfilm.models.Veiculo;

public interface IVeiculoCommandService {
	void create(Veiculo veiculo);	
	void update(Veiculo veiculo);
	void delete(int id);
}
