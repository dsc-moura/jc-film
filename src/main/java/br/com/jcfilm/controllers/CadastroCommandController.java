package br.com.jcfilm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.com.jcfilm.interfaces.IMarcaCommandService;
import br.com.jcfilm.interfaces.IVeiculoCommandService;
import br.com.jcfilm.models.Marca;
import br.com.jcfilm.models.Veiculo;

@Controller
@EnableTransactionManagement
public class CadastroCommandController {

	@Autowired
	private IMarcaCommandService IMarca;
	
	@Autowired
	private IVeiculoCommandService IVeiculo;
	
	@RequestMapping("/CadastrarMarca")
	public ModelAndView CadastrarMarca(Marca marca) {
		IMarca.create(marca);		
		return new ModelAndView("redirect:TelaCadastro");
	}
	
	@RequestMapping("/CadastrarVeiculo")
	public ModelAndView CadastrarVeiculo(Veiculo veiculo) {
		IVeiculo.create(veiculo);		
		return new ModelAndView("redirect:TelaCadastro");
	}
	
	@PutMapping(value="excluir-marca/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void ExcluirMarca(@PathVariable("id") int id) {
		IMarca.delete(id);
	}
	
	@PutMapping(value="excluir-veiculo/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void ExcluirVeiculo(@PathVariable("id") int id) {
		IVeiculo.delete(id);
	}
	
	@PutMapping(value="update-marca/{id}/{nome}")
	@ResponseStatus(HttpStatus.OK)
	public void UpdateMarca(@PathVariable("id") int id,@PathVariable("nome") String nome) {
		IMarca.update(new Marca(id,nome));
	}
	
	@PutMapping(value="update-veiculo/{id}/{nome}/{marca}")
	@ResponseStatus(HttpStatus.OK)
	public void UpdateVeiculo(@PathVariable("id") int id, @PathVariable("nome") String nome,@PathVariable("marca") int marca) {
		IVeiculo.update(new Veiculo(id,nome,new Marca(marca,null)));
	}
}
