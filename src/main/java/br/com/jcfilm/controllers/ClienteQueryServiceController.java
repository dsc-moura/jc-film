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

import br.com.jcfilm.interfaces.IClienteQueryService;
import br.com.jcfilm.interfaces.IVeiculoQueryService;
import br.com.jcfilm.models.Cliente;
import br.com.jcfilm.models.ClienteVeiculo;

@Controller
@EnableTransactionManagement
public class ClienteQueryServiceController {
	
	@Autowired
	private IVeiculoQueryService IVeiculo;
	
	@Autowired
	private IClienteQueryService ICliente;
	
	@RequestMapping("/TelaCadastroCliente")
	public ModelAndView TelaCadastroCliente(Cliente cliente) {
		ModelAndView model = new  ModelAndView("/tela-cadastro-clientes");
		model.addObject("veiculos", IVeiculo.ListaVeiculos());
		model.addObject("clientes", ICliente.ListaClientes());
		return model;
	}
	
	@PutMapping(value="buscar-cliente/{id}")
	@ResponseBody
	public List<Cliente> BuscarCliente(@PathVariable("id") int id) {
		return ICliente.BuscaCliente(id);
	}
	
	@PutMapping(value="buscar-cliente-cpf/{cpf}")
	@ResponseBody
	public List<Cliente> BuscarClienteCpf(@PathVariable("cpf") String cpf) {
		return ICliente.BuscaCliente(cpf);
	}
	
	@RequestMapping("/buscar-veiculos-cliente")	
	public String BuscarVeiculosCliente(@RequestParam(value="id") int id, HttpServletRequest request) {		
		request.setAttribute("clientes",ICliente.ListaVeiculosCliente(id));		
		return "/formulario-cadastro-veiculos";		
	}
	
	@PutMapping(value="buscar-detalhes-veiculo-cliente/{id}")
	@ResponseBody
	public List<ClienteVeiculo> BuscarDetalheVeiculoCliente(@PathVariable("id") int id) {
		return ICliente.BuscaDetalheVeiculoCliente(id);
	}
	
	
}
