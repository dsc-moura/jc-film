package br.com.jcfilm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.com.jcfilm.interfaces.IProdutoCommandService;
import br.com.jcfilm.models.Produto;

@Controller
@EnableTransactionManagement
public class ProdutoCommandController {
	
	@Autowired
	private IProdutoCommandService IProduto;
	
	@RequestMapping("/CadastrarProduto")
	public ModelAndView CadastrarProduto(Produto produto) {
		IProduto.create(produto);
		return new ModelAndView("redirect:TelaCadastroProduto");
	}
	
	@RequestMapping("/UpdateCadastroProduto")
	public ModelAndView UpdateCadastroProduto(Produto produto) {
		IProduto.update(produto);
		return new ModelAndView("redirect:TelaCadastroProduto");
	}
	
	@PutMapping(value="excluir-produto/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void ExcluirProduto(@PathVariable("id") int id) {
		IProduto.delete(id);
	}
	

}
