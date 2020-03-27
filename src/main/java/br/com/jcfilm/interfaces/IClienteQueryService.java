package br.com.jcfilm.interfaces;

import java.util.List;

import br.com.jcfilm.models.Cliente;
import br.com.jcfilm.models.ClienteVeiculo;

public interface IClienteQueryService {
	List<Cliente> BuscaCliente(String cpf);
	List<Cliente> BuscaCliente(int id);
	List<Cliente> ListaClientes();
	List<ClienteVeiculo> ListaVeiculosCliente(int id);
	List<ClienteVeiculo> BuscaDetalheVeiculoCliente(int id);
}
