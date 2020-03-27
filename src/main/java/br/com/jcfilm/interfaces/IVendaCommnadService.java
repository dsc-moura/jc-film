package br.com.jcfilm.interfaces;

import br.com.jcfilm.models.ItemVenda;
import br.com.jcfilm.models.Venda;

public interface IVendaCommnadService {
	int InciarProcessoVenda(Venda venda);
	void InserirProdutosServicosVenda(ItemVenda item);
	void ExcluirItemListaCompra(int id);
	void ExcluirItensCarrinhoCompra(int id);
	void UpdateQuantidade(int id, int quantidade);
	void FinalizarVenda(Venda venda);
	void ExcluirVenda(int id);
}
