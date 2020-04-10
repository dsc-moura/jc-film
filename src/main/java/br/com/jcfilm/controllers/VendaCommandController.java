package br.com.jcfilm.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

@Controller
@EnableTransactionManagement
public class VendaCommandController {
	
	@Autowired
	private IVendaCommnadService IVenda;

	
	@RequestMapping("/iniciar-processo-venda")
	@ResponseBody
	public int IniciarVenda(@RequestBody Venda venda) {
	
		try {
			venda.setData(Calendar.getInstance());
			 return IVenda.InciarProcessoVenda(venda);
		} catch (Exception e) {
			// TODO: handle exception
			 throw new RuntimeException(e);					
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

}
