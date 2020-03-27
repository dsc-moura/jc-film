package br.com.jcfilm.interfaces;

import br.com.jcfilm.models.Cliente;
import br.com.jcfilm.models.ClienteVeiculo;

public interface IClienteCommandService {
	void create(Cliente cliente);
	void createVeiculoCliente(ClienteVeiculo veiculo);
	void update(Cliente cliente);
	void delete(int id);
}
