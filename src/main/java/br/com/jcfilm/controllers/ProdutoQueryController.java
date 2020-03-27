package br.com.jcfilm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jcfilm.interfaces.IProdutoQueryService;
import br.com.jcfilm.models.Produto;

@Controller
@EnableTransactionManagement
public class ProdutoQueryController {
	
	@Autowired
	private IProdutoQueryService IProduto;
	
	@RequestMapping("/TelaCadastroProduto")
	public ModelAndView TelaCadastroProduto(Produto produto) {
		ModelAndView model = new ModelAndView("/tela-cadastro-produtos");
		model.addObject("produtos",IProduto.ListaProdutos());
		return model;
	}

}
