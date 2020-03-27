package br.com.jcfilm.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.jcfilm.interfaces.IProdutoQueryService;
import br.com.jcfilm.interfaces.IUsuarioQueryService;
import br.com.jcfilm.interfaces.IVeiculoQueryService;
import br.com.jcfilm.interfaces.IVendaQueryService;
import br.com.jcfilm.models.Venda;
import br.com.jcfilm.services.VendaService;

@Controller
@EnableTransactionManagement
public class VendaQueryController {
	
	@Autowired
	private IVeiculoQueryService IVeiculo;
	
	@Autowired
	private IProdutoQueryService IProduto;
	
	@Autowired
	private IUsuarioQueryService IUsuario;
	
	@Autowired
	private IVendaQueryService IVenda;
	
	private VendaService VService;

	@RequestMapping("/TelaCadastroVendas")
	public ModelAndView TelaCadastroVendas() {		
		ModelAndView model = new ModelAndView("/tela-cadastro-vendas");
		
		model.addObject("veiculos",IVeiculo.ListaVeiculos());
		model.addObject("produtos",IProduto.ListaProdutos());
		model.addObject("usuarios",IUsuario.ListaUsuarios());	
 		model.addObject("vendas",vendas());
		return model;
	}
	
	@RequestMapping("/buscar-produtos-servicos-cliente-compras")	
	public String BuscarListaProdutoServicosCliente(@RequestParam(value="modo") String modo,@RequestParam(value="id") int id, HttpServletRequest request) {		
		if(modo.equalsIgnoreCase("cliente")) {
			request.setAttribute("itens",IVenda.ListaProdutosServicosVenda(IVenda.BuscaIdVendaCliente(id)));	
		}else {
			request.setAttribute("itens",IVenda.ListaProdutosServicosVenda(id));	
		}
		if(modo.equalsIgnoreCase("garantia")) {
			return "/tabela-lista-itens-vendidos";		
		}else {
			return "/tabela-lista-itens-vendas";	
		}
		
	}
	
	@PutMapping(value="buscar-dados-vendas/{id}")
	@ResponseBody
	public List<Venda> PegarDadosVenda(@PathVariable("id") int id) {
		return IVenda.PegarDadosVenda(id);
	}
	
	public List<Venda> vendas(){
		VService = new VendaService();
		return VService.ListaVendas(IVenda.Vendas(),VService.EncontrarDatasVencimento(IVenda.Vendas()),IVenda.ListaItensVendidos());
	}
	
	
	
}
