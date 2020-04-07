package br.com.jcfilm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.com.jcfilm.interfaces.IUsuarioCommandService;
import br.com.jcfilm.models.Acesso;
import br.com.jcfilm.models.Usuario;
import br.com.jcfilm.services.FuncionarioService;

@Controller
@EnableTransactionManagement
public class FuncionarioCommandServiceController {
	
	@Autowired
	private IUsuarioCommandService IUsuario;
	
	@RequestMapping("/CadastrarFuncionario")
	public ModelAndView CadastrarFuncionario(Usuario usuario) {
		FuncionarioService FService = new FuncionarioService();
		if(IUsuario.create(usuario) > 0) {
			IUsuario.acesso(FService.CadastrarFuncionario(usuario));
		}
		return new ModelAndView("redirect:TelaCadastroFuncionario");
	}
	
	@RequestMapping("/UpdateAcessoFuncionario")
	public ModelAndView UpdateAcessoFuncionario(Acesso acesso) {
		FuncionarioService FService = new FuncionarioService();
		IUsuario.updateAcesso(FService.EncryptPassword(acesso));
		return new ModelAndView("redirect:TelaCadastroFuncionario");
	}
	
	@RequestMapping("/UpdateCadastroFuncionario")
	public ModelAndView UpdateCadastroFuncionario(Usuario usuario) {
		//FuncionarioService FService = new FuncionarioService();
		IUsuario.update(usuario);
		return new ModelAndView("redirect:TelaCadastroFuncionario");
	}
	
	@PutMapping(value="altera-status-funcionario/{id}/{status}")
	@ResponseStatus(HttpStatus.OK)
	public void Status(@PathVariable("id") int id,@PathVariable("status") boolean status) {
		IUsuario.alteraStatus(id, status);
	}
	
	@PutMapping(value="altera-permissao-funcionario/{id}/{status}")
	@ResponseStatus(HttpStatus.OK)
	public void Permissao(@PathVariable("id") int id,@PathVariable("status") boolean status) {
		IUsuario.alteraPermissao(id, status);;
	}	
	
	
}
