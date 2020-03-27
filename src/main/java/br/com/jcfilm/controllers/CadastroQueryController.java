package br.com.jcfilm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.com.jcfilm.interfaces.IMarcaQueryService;
import br.com.jcfilm.interfaces.IVeiculoQueryService;
import br.com.jcfilm.models.Marca;
import br.com.jcfilm.models.Veiculo;

@Controller
@EnableTransactionManagement
public class CadastroQueryController {

	@Autowired
	private IMarcaQueryService IMarca;
	
	@Autowired
	private IVeiculoQueryService IVeiculo;
	
	@RequestMapping("/TelaCadastro")
	public ModelAndView TelaCadastro(Marca marca, Veiculo veiculo) {
		ModelAndView model = new ModelAndView("tela-cadastros");
		model.addObject("marcas",IMarca.lista());
		model.addObject("veiculos",IVeiculo.ListaVeiculos());
		return model;
		
	}	
	
}
