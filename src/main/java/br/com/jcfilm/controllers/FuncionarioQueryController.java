package br.com.jcfilm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jcfilm.interfaces.IUsuarioQueryService;
import br.com.jcfilm.models.Acesso;
import br.com.jcfilm.models.Usuario;

@Controller
public class FuncionarioQueryController {

	@Autowired
	IUsuarioQueryService IUsuario;
	
	@RequestMapping("/TelaCadastroFuncionario")
	public ModelAndView TelaCadastroFuncionario(Usuario Usuario, Acesso acesso) {
		ModelAndView model = new ModelAndView("/tela-cadastro-funcionarios");
		model.addObject("funcionarios", IUsuario.ListaUsuarios());
		model.addObject("acessos", IUsuario.ListaAcessos());
		return model;
	}
		
}
