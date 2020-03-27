package br.com.jcfilm.interfaces;

import java.util.List;

import br.com.jcfilm.models.ItemVenda;
import br.com.jcfilm.models.Venda;

public interface IVendaQueryService {
	List<ItemVenda> ListaProdutosServicosVenda(int id);
	List<ItemVenda> ListaItensVendidos();
	int BuscaIdVendaCliente(int id);
	List<Venda> PegarDadosVenda(int id);
	List<Venda> Vendas();
}
