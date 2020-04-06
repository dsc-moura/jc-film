package br.com.jcfilm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
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
			IUsuario.atribuirAcesso(FService.CadastrarFuncionario(usuario));
		}
		return new ModelAndView("redirect:TelaCadastroFuncionario");
	}
	
	@RequestMapping("/CadastroAcessoFuncionario")
	public ModelAndView CadastroAcessoFuncionario(Acesso acesso) {
		FuncionarioService FService = new FuncionarioService();
		IUsuario.atribuirAcesso(FService.EncryptPassword(acesso));
		return new ModelAndView("redirect:TelaCadastroFuncionario");
	}
	
	
	
	
	
	
	
	
}
