package br.com.jcfilm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.jcfilm.interfaces.IVendaCommnadService;
import br.com.jcfilm.models.ItemVenda;
import br.com.jcfilm.models.Venda;
import br.com.jcfilm.services.ImprimirService;

@Controller
@EnableTransactionManagement
public class VendaCommandController {
	
	@Autowired
	private IVendaCommnadService IVenda;
	
	private ImprimirService IService;
	
	@RequestMapping("/iniciar-processo-venda")
	@ResponseBody
	public int IniciarVenda(@RequestBody Venda venda) {
		try {
			return IVenda.InciarProcessoVenda(venda);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
			//System.out.println(e.getMessage());
		}	
	}
	
	@RequestMapping("/iniciar-processo-venda-inserir-produto-servico")
	@ResponseStatus(HttpStatus.OK)
	public void InserirProdutosServicosVenda(@RequestBody List<ItemVenda> carrinho) {
		for(ItemVenda venda: carrinho) {
			IVenda.InserirProdutosServicosVenda(venda);
		}
	}
	
	@RequestMapping("/finalizar-venda")
	@ResponseStatus(HttpStatus.OK)
	public void FinalizarVenda(@RequestBody Venda venda) {
		IVenda.FinalizarVenda(venda);
	}
	
	@PutMapping(value="excluir-item-carrinho-compra/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void ExcluirItemCarrinho(@PathVariable("id") int id) {
		IVenda.ExcluirItemListaCompra(id);		
	}
	
	@PutMapping(value="cancelar-venda/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void ExcluirVenda(@PathVariable("id") int id) {
		IVenda.ExcluirItensCarrinhoCompra(id);
		IVenda.ExcluirVenda(id);
	}
	
	
	@PutMapping(value="limpar-itens-carrinho-compra/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void ExcluirItensCarrinhoCompra(@PathVariable("id") int id) {
		IVenda.ExcluirItensCarrinhoCompra(id);
	}
	
	@PutMapping(value="update-quantidade-produto/{id}/{quantidade}")
	@ResponseStatus(HttpStatus.OK)
	public void UpdateQuatidadeItens(@PathVariable("id") int id, @PathVariable("quantidade") int quantidade) {
		IVenda.UpdateQuantidade(id, quantidade);
	}
	
	@PutMapping(value="imprimir-relario/{arquivo}")
	@ResponseStatus(HttpStatus.OK)
	public void ImprimirRelatorio(@PathVariable("arquivo") String arquivo) {
		IService = new ImprimirService();
		
		IService.ImpressaoDeRelatorio("Venda");
	}
}
