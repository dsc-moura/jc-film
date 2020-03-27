package br.com.jcfilm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.com.jcfilm.interfaces.IClienteCommandService;
import br.com.jcfilm.models.Cliente;
import br.com.jcfilm.models.ClienteVeiculo;

@Controller
@EnableTransactionManagement
public class ClienteCommandServiceController {
	
	@Autowired
	private IClienteCommandService ICliente;
	
	
	@RequestMapping("/CadastrarCliente")
	public ModelAndView CadastrarCliente(Cliente cliente) {
		ICliente.create(cliente);
		return new ModelAndView("redirect:TelaCadastroCliente");
	}
	
	@RequestMapping("/UpdateCadastroCliente")
	public ModelAndView UpdateCadastroCliente(Cliente cliente) {
		ICliente.update(cliente);
		return new ModelAndView("redirect:TelaCadastroCliente");
	}
	
	@PutMapping(value="excluir-cliente/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void ExcluirCliente(@PathVariable("id") int id) {
		ICliente.delete(id);
	}
	
	@PostMapping(value="cadastrar-novo-cliente")
	@ResponseStatus(HttpStatus.OK)
	public void Cadastro(@RequestBody Cliente cliente){
		try {
			ICliente.create(cliente);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	@PostMapping(value="cadastrar-veiculo-cliente")
	@ResponseStatus(HttpStatus.OK)
	public void CadastroClienteVeiculo(@RequestBody ClienteVeiculo veiculo){
		try {
			ICliente.createVeiculoCliente(veiculo);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
